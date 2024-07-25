package com.vebg.receitae.repository;

import com.vebg.receitae.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    public List<Ingrediente> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
