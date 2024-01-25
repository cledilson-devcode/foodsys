package com.cledilsondevcode.foodsys.api.controller;

import com.cledilsondevcode.foodsys.domain.exception.EntidadeEmUsoException;
import com.cledilsondevcode.foodsys.domain.exception.EntidadeNaoEncontradaException;
import com.cledilsondevcode.foodsys.domain.model.Cidade;
import com.cledilsondevcode.foodsys.domain.model.Cozinha;
import com.cledilsondevcode.foodsys.domain.model.Estado;
import com.cledilsondevcode.foodsys.domain.repository.CidadeRepository;
import com.cledilsondevcode.foodsys.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    public CadastroCidadeService cadastroCidadeService;

    @Autowired
    public CidadeRepository cidadeRepository;

    @GetMapping
    public List<Cidade> listar(){
        return cidadeRepository.listar();
    }

    @GetMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId){
        Cidade cidade = cidadeRepository.buscar(cidadeId);
        if (cidade != null){
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade){
        try{
            Cidade cidadeSalva = cadastroCidadeService.salvar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> atuualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade){
        try{
            Cidade cidadeAtual = cadastroCidadeService.buscar(cidadeId);

            if (cidadeAtual != null){
                BeanUtils.copyProperties(cidade, cidadeAtual, "id");
                cidadeAtual = cadastroCidadeService.salvar(cidadeAtual);
                return ResponseEntity.ok(cidadeAtual);

            }
            return ResponseEntity.notFound().build();

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId){
        try {
            cadastroCidadeService.excluir(cidadeId);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();

        }catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }
    }


}
