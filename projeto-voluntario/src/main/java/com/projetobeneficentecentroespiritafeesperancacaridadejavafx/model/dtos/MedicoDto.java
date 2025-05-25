package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDto {
    private String nomeMedico;
    private String cpfMedico;
    private LocalDate dataNascimentoMedico;
    private String sexo;
    private String telefoneMedico;
    private String emailMedico;
    private String crm;
    private String ufRegistroCrm;
    private String especialidadeMedico;
    private String rgMedico;
    private String ufRgMedico;

    public Medico toModel() {
        Medico medico = new Medico();
        medico.setNomeMedico(nomeMedico);
        medico.setCpfMedico(cpfMedico);
        medico.setDataNascimentoMedico(dataNascimentoMedico);
        medico.setSexo(sexo);
        medico.setTelefoneMedico(telefoneMedico);
        medico.setEmailMedico(emailMedico);
        medico.setCrm(crm);
        medico.setUfRegistroCrm(ufRegistroCrm);
        medico.setEspecialidadeMedico(especialidadeMedico);
        medico.setRgMedico(rgMedico);
        medico.setUfRgMedico(ufRgMedico);
        return medico;
    }
}
