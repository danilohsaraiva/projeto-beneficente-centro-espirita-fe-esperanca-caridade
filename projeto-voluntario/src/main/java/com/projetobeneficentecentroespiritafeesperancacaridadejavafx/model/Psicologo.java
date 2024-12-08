package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoAtendimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Psicologo {
    private Long idPsicologo;
    private String nomePsicologo;
    private LocalDate anoNascimentoProfissional;
    private String sexoPsicologo;
    private Long fkEndereco;
    private String telefonePsicologo;
    private String email;
    private String crp;
    private String ufRegistroCrp;
    private String especialidade;
    private Long fkUsuario;
    private String rgPsicologo;
    private String urRg;
    private Enum<TipoAtendimento> tipoAtendimento;

}
