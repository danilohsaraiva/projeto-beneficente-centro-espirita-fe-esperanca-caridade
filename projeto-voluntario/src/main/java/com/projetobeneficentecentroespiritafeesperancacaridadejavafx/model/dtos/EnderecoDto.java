package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import lombok.Data;

@Data
public class EnderecoDto {
    private String cep;
    private String logradouroEndereco;
    private String cidade;
    private String uf;
    private String bairro;
    private String complemento;
    private String numero;

    public Endereco toModel() {
        Endereco endereco = new Endereco();
        endereco.setCep(this.cep);
        endereco.setLogradouroEndereco(this.logradouroEndereco);
        endereco.setCidade(this.cidade);
        endereco.setUf(this.uf);
        endereco.setBairro(this.bairro);
        endereco.setComplemento(this.complemento);
        endereco.setNumero(this.numero);
        return endereco;
    }
}
