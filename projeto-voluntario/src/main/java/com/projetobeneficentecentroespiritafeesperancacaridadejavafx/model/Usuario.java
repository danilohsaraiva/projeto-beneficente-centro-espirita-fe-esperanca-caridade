package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    private String login;
    private String senha;
    @Column(name = "tipo_acesso", columnDefinition = "CHAR(3)")
    private String tipoAcesso;
}
