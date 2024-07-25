package com.vebg.receitae.service;

import com.vebg.receitae.entity.Medida;
import com.vebg.receitae.exception.BadRequestException;
import com.vebg.receitae.repository.MedidaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedidaService {
    private MedidaRepository medidaRepository;

    public MedidaService(MedidaRepository medidaRepository) {
        this.medidaRepository = medidaRepository;
    }

    public List<Medida> create(Medida medida) {
        medidaRepository.save(medida);
        return list();
    }

    public List<Medida> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "unidade");
        return medidaRepository.findAll(sort);
    }

    public List<Medida> update(Long id, Medida medida) {
        Medida medidaExist = medidaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Id não encontrado!"));

        medidaExist.setQuantidade(medida.getQuantidade());
        medidaExist.setIngredientes(medida.getIngredientes());
        medidaExist.setUnidade(medida.getUnidade());

        medidaRepository.save(medidaExist);

        return list();
    }

    public List<Medida> delete(Long id) {
        medidaRepository.deleteById(id);
        return list();
    }
}
