package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;
    @Column(name = "cpf_paciente")
    private String cpfPaciente;
    @Column(name = "rg_paciente")
    private String rgPaciente;
    @Column(name = "nome_completo_paciente")
    private String nomeCompletoPaciente;
    @Column(name = "data_nascimento_paciente")
    private LocalDate dataNascimentoPaciente;
    @Column(name = "sexo_biologico_paciente", columnDefinition = "CHAR(1)")
    private String sexoBiologicoPaciente;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "genero_paciente")
    private String generoPaciente;
    @Column(name = "email_paciente")
    private String emailPaciente;
    @Column(name = "escolaridade_paciente")
    private String escolaridadePaciente;
    @Column(name = "ocupacao_paciente")
    private String ocupacaoPaciente;
    private String naturalidade;
    private String nacionalidade;
    @Column(name = "cor_raca")
    private String corRaca;
    @Column(name = "cartao_nascional_saude")
    private String cartaoNascionalSaude;

    @OneToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "fk_limitacao", referencedColumnName = "id_limitacao")
    private Limitacao limitacao;


    @OneToOne()
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "fk_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<TelefoneContatoEmergencia> telefonesDeEmergencia = new HashSet<>();

    @OneToOne(mappedBy = "pacienteProntuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Prontuario prontuario;

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", nomeCompletoPaciente='" + nomeCompletoPaciente + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                '}';
    }

}
