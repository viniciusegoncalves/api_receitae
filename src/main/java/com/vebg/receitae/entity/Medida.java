package com.vebg.receitae.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vebg.receitae.util.Unidade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_medidas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medida {
    public Medida(Long id, int quantidade, Unidade unidade) {
        this.id = id;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private int quantidade;

    @Enumerated(EnumType.STRING)
    private Unidade unidade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medida", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("medida")
    private Set<Ingrediente> ingredientes;
}
