package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Long idEndereco;
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;
    private String bairro;
    private String complemento;
    private String numero;
}
