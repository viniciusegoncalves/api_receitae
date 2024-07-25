package com.vebg.receitae.repository;

import com.vebg.receitae.entity.Ingrediente;
import com.vebg.receitae.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ReceitaRepository extends JpaRepository<Receita, UUID> {
    public List<Receita> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
