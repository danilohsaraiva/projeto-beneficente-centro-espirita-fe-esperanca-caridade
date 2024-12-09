package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TelefoneContatoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone_contato_emergencia")
    private Long idTelefoneContatoEmergencia;
    @Column(name = "nome_contato_emergencia")
    private String nomeContatoEmergencia;
    @Column(name = "telefone_contato_emergencia")
    private String telefoneContatoEmergencia;

    @ManyToMany
    @JoinTable(
            name = "ContatoEmergenciaPaciente",
            joinColumns = @JoinColumn(name = "fk_telefone_contato_emergencia"),
            inverseJoinColumns = @JoinColumn(name = "fk_paciente")
    )
    private Set<Paciente> contatos = new HashSet<>();
}
