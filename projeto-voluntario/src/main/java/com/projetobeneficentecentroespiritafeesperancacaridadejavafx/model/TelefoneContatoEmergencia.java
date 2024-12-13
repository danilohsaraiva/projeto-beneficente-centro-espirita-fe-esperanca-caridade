package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "fk_paciente", referencedColumnName = "id_paciente")
    private Paciente paciente = new Paciente();
}
