package com.cledilsondevcode.foodsys.infrastructure.repository;

import com.cledilsondevcode.foodsys.domain.model.Estado;
import com.cledilsondevcode.foodsys.domain.repository.EstadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {

        TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);

        return query.getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return manager.find(Estado.class, id);
    }

    @Override
    @Transactional
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    @Transactional
    public void remover(Long estadoId) {
        Estado estado = buscar(estadoId);
        if (estado == null){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(estado);
    }
}
