package com.cledilsondevcode.foodsys.domain.repository;

import java.util.List;
import com.cledilsondevcode.foodsys.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findTodasByNomeContaining(String nome);

    boolean existsByNome(String nome);

}
