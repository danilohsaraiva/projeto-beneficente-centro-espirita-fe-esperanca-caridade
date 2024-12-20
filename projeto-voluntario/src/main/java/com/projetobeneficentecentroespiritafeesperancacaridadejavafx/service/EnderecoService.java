package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.EnderecoDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.EnderecoDto;

public class EnderecoService {
    public static boolean adicionaEndereco(EnderecoDto enderecoDto) {
        boolean ehAdicionado = false;
        return ehAdicionado = EnderecoDao.adicionaEndereco(enderecoDto.toModel());
    }

    public static Endereco buscaEndereco(Long id) {
        return EnderecoDao.buscaEndereco(id);
    }
}
