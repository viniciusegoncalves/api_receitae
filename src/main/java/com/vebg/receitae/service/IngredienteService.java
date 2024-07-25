package com.vebg.receitae.service;

import com.vebg.receitae.entity.Ingrediente;
import com.vebg.receitae.exception.BadRequestException;
import com.vebg.receitae.repository.IngredienteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<Ingrediente> create(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
        return list();
    }

    public List<Ingrediente> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return ingredienteRepository.findAll(sort);
    }

    public Ingrediente getById(Long id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("ID " + id + " não encontrado!"));
    }

    public List<Ingrediente> listByName(String nome) {
        return ingredienteRepository.findAllByNomeContainingIgnoreCase(nome);
    }


    public List<Ingrediente> update(Long id, Ingrediente ingrediente) {
        Ingrediente ingredienteExist = ingredienteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Id não encontrado!"));

        ingredienteExist.setNome(ingrediente.getNome());
        ingredienteExist.setMedida(ingrediente.getMedida());
        ingredienteRepository.save(ingredienteExist);

        return list();
    }

    public List<Ingrediente> delete(Long id) {
        ingredienteRepository.deleteById(id);
        return list();
    }
}
