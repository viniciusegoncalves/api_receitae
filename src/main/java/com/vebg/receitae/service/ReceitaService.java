package com.vebg.receitae.service;

import com.vebg.receitae.entity.Ingrediente;
import com.vebg.receitae.entity.Receita;
import com.vebg.receitae.exception.BadRequestException;
import com.vebg.receitae.repository.IngredienteRepository;
import com.vebg.receitae.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReceitaService {

    public ReceitaService(ReceitaRepository receitaRepository, IngredienteRepository ingredienteRepository) {
        this.receitaRepository = receitaRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    ReceitaRepository receitaRepository;

    IngredienteRepository ingredienteRepository;


    public List<Receita> create(Receita receita) {
        Set<Ingrediente> ingredientes = new HashSet<>();
        for (Ingrediente ingrediente : receita.getIngredientes()) {
            if (ingrediente.getId() != null) {
                ingrediente = ingredienteRepository.findById(ingrediente.getId()).orElseThrow(
                        () -> new IllegalArgumentException("Ingrediente não encontrado"));
            }
            ingredientes.add(ingrediente);
        }
        receita.setIngredientes(ingredientes);
        receitaRepository.save(receita);
        return list();
    }

    public List<Receita> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return receitaRepository.findAll(sort);
    }

    public Receita getById(UUID id) {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("não encontrado!"));
    }

    public List<Receita> listByName(String nome) {
        return receitaRepository.findAllByNomeContainingIgnoreCase(nome);
    }


    public List<Receita> update(UUID id, Receita receita) {
        Receita receitaExist = receitaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Id não encontrado!"));

        receitaExist.setNome(receita.getNome());
        receitaExist.setModoPreparo(receita.getModoPreparo());
        receitaRepository.save(receitaExist);

        return list();
    }

    public List<Receita> delete(UUID id) {
        receitaRepository.deleteById(id);
        return list();
    }
}

