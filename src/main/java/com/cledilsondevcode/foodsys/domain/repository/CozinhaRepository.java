package com.cledilsondevcode.foodsys.domain.repository;

import java.util.List;
import com.cledilsondevcode.foodsys.domain.model.*;

public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long cozinhaId);

}
