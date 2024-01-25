package com.cledilsondevcode.foodsys.domain.service;

import com.cledilsondevcode.foodsys.domain.exception.EntidadeEmUsoException;
import com.cledilsondevcode.foodsys.domain.exception.EntidadeNaoEncontradaException;
import com.cledilsondevcode.foodsys.domain.model.Cidade;
import com.cledilsondevcode.foodsys.domain.model.Estado;
import com.cledilsondevcode.foodsys.domain.repository.CidadeRepository;
import com.cledilsondevcode.foodsys.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> listar(){
        return cidadeRepository.listar();
    }

    public Cidade buscar(Long cidadeId){
        return cidadeRepository.buscar(cidadeId);
    }

    public Cidade salvar(Cidade cidade){
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscar(estadoId);

        if (estado == null){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de estado com código %d", estadoId));

        }
        cidade.setEstado(estado);
        return cidadeRepository.salvar(cidade);

    }

    public void excluir(Long cidadeId){
        try{
            cidadeRepository.remover(cidadeId);

        }catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cidade com código %d", cidadeId));

        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));

        }
    }


}
