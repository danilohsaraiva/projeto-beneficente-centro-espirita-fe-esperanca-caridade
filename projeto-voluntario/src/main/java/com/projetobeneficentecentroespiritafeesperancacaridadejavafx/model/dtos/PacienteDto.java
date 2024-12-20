package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    private String cpfPaciente;
    private String rgPaciente;
    private String nomeCompletoPaciente;
    private LocalDate dataNascimentoPaciente;
    private String sexoBiologicoPaciente;
    private String estadoCivil;
    private String generoPaciente;
    private String emailPaciente;
    private String escolaridadePaciente;
    private String ocupacaoPaciente;
    private String naturalidade;
    private String nacionalidade;
    private String corRaca;
    private String cartaoNascionalSaude;

    public Paciente toModel() {
        Paciente paciente = new Paciente();
        paciente.setCpfPaciente(getCpfPaciente());
        paciente.setRgPaciente(getRgPaciente());
        paciente.setNomeCompletoPaciente(getNomeCompletoPaciente());
        paciente.setDataNascimentoPaciente(getDataNascimentoPaciente());
        paciente.setSexoBiologicoPaciente(getSexoBiologicoPaciente());
        paciente.setEstadoCivil(getEstadoCivil());
        paciente.setGeneroPaciente(getGeneroPaciente());
        paciente.setEmailPaciente(getEmailPaciente());
        paciente.setEscolaridadePaciente(getEscolaridadePaciente());
        paciente.setOcupacaoPaciente(getOcupacaoPaciente());
        paciente.setNacionalidade(getNacionalidade());
        paciente.setCorRaca(getCorRaca());
        paciente.setNaturalidade(getNaturalidade());
        paciente.setCartaoNascionalSaude(getCartaoNascionalSaude());
        return paciente;
    }
}
