package com.cledilsondevcode.foodsys.domain.repository;

import com.cledilsondevcode.foodsys.domain.model.*;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Restaurante restaurante);

}
