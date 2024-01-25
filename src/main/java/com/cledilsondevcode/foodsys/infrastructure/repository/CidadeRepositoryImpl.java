package com.cledilsondevcode.foodsys.infrastructure.repository;

import com.cledilsondevcode.foodsys.domain.model.Cidade;
import com.cledilsondevcode.foodsys.domain.repository.CidadeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Cidade> listar() {

        TypedQuery query = manager.createQuery("from Cidade", Cidade.class);

        return query.getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Long cidadeId) {
        Cidade cidade = buscar(cidadeId);
        manager.remove(cidade);
    }
}
