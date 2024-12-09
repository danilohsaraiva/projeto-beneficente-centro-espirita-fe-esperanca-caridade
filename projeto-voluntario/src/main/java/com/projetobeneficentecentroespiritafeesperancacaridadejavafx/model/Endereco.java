package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long idEndereco;
    @Column(columnDefinition = "CHAR(8)")
    private String cep;
    @Column(name = "logradouro_endereco")
    private String logradouroEndereco;
    private String cidade;
    @Column(columnDefinition = "CHAR(2)")
    private String uf;
    private String bairro;
    private String complemento;
    private String numero;
}
