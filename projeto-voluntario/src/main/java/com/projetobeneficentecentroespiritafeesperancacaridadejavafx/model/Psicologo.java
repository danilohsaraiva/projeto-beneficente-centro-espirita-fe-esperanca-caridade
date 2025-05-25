package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.converter.TipoAtendimentoConverter;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoAtendimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Psicologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_psicologo")
    private Long idPsicologo;
    @Column(name = "nome_psicologo")
    private String nomePsicologo;
    @Column(name = "data_nascimento_profissional")
    private LocalDate anoNascimentoProfissional;
    @Column(name = "sexo_psicologo")
    private String sexoPsicologo;
    @Column(name = "telefone_psicologo")
    private String telefonePsicologo;
    private String email;
    private String crp;
    @Column(name = "uf_registro_crp", columnDefinition = "CHAR(2)")
    private String ufRegistroCrp;
    private String especialidade;
    @Column(name= "rg_psicologo")
    private String rgPsicologo;
    @Column(name= "ur_rg", columnDefinition = "CHAR(2)")
    private String urRg;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "fk_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;
}
