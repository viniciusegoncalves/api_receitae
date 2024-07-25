package com.vebg.receitae.web;

import com.vebg.receitae.entity.Ingrediente;
import com.vebg.receitae.service.IngredienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {
    private IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @PostMapping
    ResponseEntity<List<Ingrediente>> create(@Valid @RequestBody Ingrediente ingrediente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ingredienteService.create(ingrediente));
    }

    @GetMapping
    List<Ingrediente> list() {
        return ingredienteService.list();
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Ingrediente>> listByName(@PathVariable String nome) {
        List<Ingrediente> ingredientes = ingredienteService.listByName(nome);
        if (ingredientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(ingredientes);
    }
    @GetMapping("/{id}")
    Ingrediente getById(@PathVariable Long id) {
        return ingredienteService.getById(id);
    }
    @PutMapping("/{id}")
    List<Ingrediente> update(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        return ingredienteService.update(id,ingrediente);
    }

    @DeleteMapping("/{id}")
    List<Ingrediente> delete(@PathVariable Long id) {
        return ingredienteService.delete(id);
    }
}

