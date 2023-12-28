package com.cledilsondevcode.foodsys.domain.service;

import com.cledilsondevcode.foodsys.domain.exception.EntidadeEmUsoException;
import com.cledilsondevcode.foodsys.domain.exception.EntidadeNaoEncontradaException;
import com.cledilsondevcode.foodsys.domain.model.Cozinha;
import com.cledilsondevcode.foodsys.domain.model.Restaurante;
import com.cledilsondevcode.foodsys.domain.repository.CozinhaRepository;
import com.cledilsondevcode.foodsys.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Serviço para operações de intermediação crud com relação ao cadastro de restaurantes
 */
@Service
public class CadastroRestauranteService {

    /**
     * Repositório para acesso a dados relacionados aos restaurantes
     */
    @Autowired
    private RestauranteRepository restauranteRepository;

    /**
     * Repositório para acesso a dados relaciondos aos restaurantes
     */
    @Autowired
    private CozinhaRepository cozinhaRepository;

    /**
     * Lista todos os restaurantes cadastrados
     *
     * @return Uma lista de objetos Restaurante.
     */
    public List<Restaurante> listar(){
        return restauranteRepository.listar();
    }

    /**
     * Busca um restaurante pelo ID
     *
     * @param restauranteId É o ID do restaurante a ser buscado.
     * @return O restaurante encontrado
     */
    public Restaurante buscar(Long restauranteId){

            return restauranteRepository.buscar(restauranteId);

    }

    /**
     * Salva um restaurante
     *
     * @param restaurante É o objeto restaurante a ser salvo
     * @return O restaurante salvo
     */
    public Restaurante salvar(Restaurante restaurante){

            Long cozinhaId = restaurante.getCozinha().getId();
            Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

            if (cozinha == null){
                throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
            }
            restaurante.setCozinha(cozinha);

            return restauranteRepository.salvar(restaurante);

    }

}
