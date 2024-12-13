package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.EnderecoDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.EnderecoDto;

public class EnderecoService {
    public boolean adicionaEndereco(EnderecoDto enderecoDto) {
        boolean ehAdicionado = false;
        return ehAdicionado = EnderecoDao.adicionaEndereco(enderecoDto.toModel());
    }
}
