package com.cledilsondevcode.foodsys.infrastructure.repository.specification;

import com.cledilsondevcode.foodsys.domain.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class RestauranteComNomSemelhanteSpec implements Specification<Restaurante> {

    private String nome;

    public RestauranteComNomSemelhanteSpec(String nome) {
        this.nome = nome;
    }

    @Override
    public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }
}