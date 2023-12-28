package com.cledilsondevcode.foodsys.api.controller;

import com.cledilsondevcode.foodsys.domain.exception.EntidadeEmUsoException;
import com.cledilsondevcode.foodsys.domain.exception.EntidadeNaoEncontradaException;
import com.cledilsondevcode.foodsys.domain.model.Restaurante;
import com.cledilsondevcode.foodsys.domain.service.CadastroRestauranteService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

/**
 * Controlador responsável por lidar com operações relacionadas a restaurantes.
 */

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    /**
     * Serviço para operações de intermediação crud com relação ao cadastro de restaurantes
     */
    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    /**
     * Endpoint para listar todos os resteurantes com suas respectivas cozinhas cadastradas
     *
     * @return Uma lista de restaurantes.
     */
    @GetMapping
    public List<Restaurante> buscar(){
        return cadastroRestauranteService.listar();
    }

    /**
     * Endpoint para buscar um restaurante pelo ID com sua respectiva cozinha
     *
     * @param restauranteId É o ID do restaurante a ser buscado.
     * @return ResponseEntity contendo o restaurante encontrado, ou status 404 se não encontrado, ou 409 para conflito caso exista alguma cozinha cadastrada.
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId){
        Restaurante restaurante = cadastroRestauranteService.buscar(restauranteId);
        return ResponseEntity.ok(restaurante);

    }

    /**
     * Endpoint para salvar restaurante pelo ID
     *
     * @param restaurante É o ID do restaurante a ser salvo
     * @return
     */
    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante){

        try {
            Restaurante restauranteSalvo = cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restauranteSalvo);

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    /**
     * Atualizar um restaurante existente com base no ID e dados fornecidos
     *
     * @param restauranteId É o ID do restaurante a ser atualizado.
     * @param restaurante São os dados do restaurante a serem atualizados
     * @return ResponseEntity contendo o restaurante atualizado, ou staus 400 para uma informação inexistente como o ID da cozinha ,ou status 404 se o restaurante não for encontrado.
     */
    @PutMapping("/{restauranteId}")
    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante){

        try {
            Restaurante restauranteAtual = cadastroRestauranteService.buscar(restauranteId);
            if (restauranteAtual != null){
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
                restauranteAtual = cadastroRestauranteService.salvar(restauranteAtual);
                return ResponseEntity.ok(restauranteAtual);

            }
            return ResponseEntity.notFound().build();
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
