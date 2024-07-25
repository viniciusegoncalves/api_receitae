package com.vebg.receitae.web;

import com.vebg.receitae.entity.Receita;
import com.vebg.receitae.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    private ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @PostMapping
    ResponseEntity<List<Receita>> create(@RequestBody Receita receita) {
        List<Receita> receitas = receitaService.create(receita);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(receitas);
    }

    @GetMapping
    List<Receita> list() {
        return receitaService.list();
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Receita>> listByName(@PathVariable String nome) {
        List<Receita> receitas = receitaService.listByName(nome);
        if (receitas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(receitas);
    }
    @GetMapping("/{id}")
    Receita getById(@PathVariable UUID id) {
        return receitaService.getById(id);
    }
    @PutMapping("/{id}")
    List<Receita> update(@PathVariable UUID id, @RequestBody Receita receita) {
        return receitaService.update(id,receita);
    }

    @DeleteMapping("/{id}")
    List<Receita> delete(@PathVariable UUID id) {
        return receitaService.delete(id);
    }
}
