package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;
    @Column(name = "nome_medico")
    private String nomeMedico;
    @Column(name = "cpf_medico")
    private String cpfMedico;
    @Column(name = "data_nascimento_medico")
    private LocalDate dataNascimentoMedico;
    @Column(columnDefinition = "CHAR(1)")
    private String sexo;
    @Column(name = "telefone_medico")
    private String telefoneMedico;
    @Column(name = "email_medico")
    private String emailMedico;
    private String crm;
    @Column(name = "uf_registro_crm", columnDefinition = "CHAR(2)")
    private String ufRegistroCrm;
    @Column(name = "especialidade_medico")
    private String especialidadeMedico;

    @Column(name = "rg_medico")
    private String rgMedico;
    @Column(name = "uf_rg_medico", columnDefinition = "CHAR(2)")
    private String ufRgMedico;

    @OneToOne()
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "fk_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @Column(name = "fk_usuario")
    private Long fkUsuario;
}
