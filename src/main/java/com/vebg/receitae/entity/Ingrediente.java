package com.vebg.receitae.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_ingredientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    public Ingrediente(Long id, String nome, Medida medida) {
        this.id = id;
        this.nome = nome;
        this.medida = medida;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @ManyToOne
    @JsonIgnoreProperties("ingredientes")
    private Medida medida;

    @ManyToMany(mappedBy = "ingredientes", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("ingredientes")
    private Set<Receita> receitas;
}
