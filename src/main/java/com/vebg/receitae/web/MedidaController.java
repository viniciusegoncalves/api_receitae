package com.vebg.receitae.web;

import com.vebg.receitae.entity.Medida;
import com.vebg.receitae.service.MedidaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medidas")
public class MedidaController {
    private MedidaService medidaService;

    public MedidaController(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    @PostMapping
    ResponseEntity<List<Medida>> create(@Valid @RequestBody Medida medida) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medidaService.create(medida));
    }

    @GetMapping
    List<Medida> list() {
        return medidaService.list();
    }

    @PutMapping("/{id}")
    List<Medida> update(@PathVariable Long id, @RequestBody Medida medida) {
        return medidaService.update(id,medida);
    }

    @DeleteMapping("/{id}")
    List<Medida> delete(@PathVariable Long id) {
        return medidaService.delete(id);
    }
}
