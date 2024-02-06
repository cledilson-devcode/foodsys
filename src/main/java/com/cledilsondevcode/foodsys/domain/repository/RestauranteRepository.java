package com.cledilsondevcode.foodsys.domain.repository;

import com.cledilsondevcode.foodsys.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {


}
