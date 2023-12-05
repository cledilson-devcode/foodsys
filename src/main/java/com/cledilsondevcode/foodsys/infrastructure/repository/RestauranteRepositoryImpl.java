package com.cledilsondevcode.foodsys.infrastructure.repository;

import com.cledilsondevcode.foodsys.domain.repository.RestauranteRepository;
import com.cledilsondevcode.foodsys.domain.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> listar(){
        TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
        return query.getResultList();

//        return manager.createQuery("from restaurante", Restaurante.class).getResultList();
    }
    @Override
    public Restaurante buscar(Long id){
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante){
        return manager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante){
        restaurante = buscar(restaurante.getId());
        manager.remove(restaurante);
    }
}
