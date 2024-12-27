package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "fk_paciente")
)
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prontuario")
    private Long idProntuario;

    @OneToOne
    @JoinColumn(name = "fk_paciente", referencedColumnName = "id_paciente")
    private Paciente pacienteProntuario;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;
}