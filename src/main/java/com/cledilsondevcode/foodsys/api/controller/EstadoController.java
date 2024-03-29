package com.cledilsondevcode.foodsys.api.controller;

import com.cledilsondevcode.foodsys.domain.exception.EntidadeEmUsoException;
import com.cledilsondevcode.foodsys.domain.exception.EntidadeNaoEncontradaException;
import com.cledilsondevcode.foodsys.domain.model.Estado;
import com.cledilsondevcode.foodsys.domain.repository.EstadoRepository;
import com.cledilsondevcode.foodsys.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscar(@PathVariable Long estadoId){

        Optional<Estado> estado = estadoRepository.findById(estadoId);
        if (estado.isPresent()) {
            return ResponseEntity.ok(estado.get());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Estado adicionar(@RequestBody Estado estado){
        return cadastroEstadoService.salvar(estado);
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado){
        Optional<Estado> estadoAtual = estadoRepository.findById(estadoId);

        if (estadoAtual.isPresent()){
            BeanUtils.copyProperties(estado, estadoAtual.get(),"id");
            Estado estadoSalvar = cadastroEstadoService.salvar(estadoAtual.get());
            return ResponseEntity.ok(estadoSalvar);

        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Estado> remover(@PathVariable Long estadoId){
        try {
            cadastroEstadoService.excluir(estadoId);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){
        return ResponseEntity.notFound().build();

        }catch (
        EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }
    }



}
