package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Psicologo;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsicologoDto {

    private String nomePsicologo;
    private LocalDate anoNascimentoProfissional;
    private String sexoPsicologo;
    private String telefonePsicologo;
    private String email;
    private String crp;
    private String ufRegistroCrp;
    private String especialidade;
    private String rgPsicologo;
    private String urRg;

    public Psicologo toModel() {
        Psicologo psicologo = new Psicologo();
        psicologo.setNomePsicologo(this.nomePsicologo);
        psicologo.setAnoNascimentoProfissional(this.anoNascimentoProfissional);
        psicologo.setSexoPsicologo(this.sexoPsicologo);
        psicologo.setTelefonePsicologo(this.telefonePsicologo);
        psicologo.setEmail(this.email);
        psicologo.setCrp(this.crp);
        psicologo.setUfRegistroCrp(this.ufRegistroCrp);
        psicologo.setEspecialidade(this.especialidade);
        psicologo.setRgPsicologo(this.rgPsicologo);
        psicologo.setUrRg(this.urRg);

        return psicologo;
    }

}
