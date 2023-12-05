package com.cledilsondevcode.foodsys.domain.repository;


import com.cledilsondevcode.foodsys.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();

    Permissao buscar(Long id);

    Permissao salvar(Permissao permissao);

    void remover(Permissao permissao);

}
