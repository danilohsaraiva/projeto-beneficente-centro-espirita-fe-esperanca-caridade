package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PsicologoDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Psicologo;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.EnderecoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.PsicologoDto;

import java.util.List;

public class PsicologoService {
    private final PsicologoDao psicologoDao;

    public PsicologoService() {
        this.psicologoDao = new PsicologoDao();
    }

    public List<Psicologo> buscaTodosPsicologos() {
         return psicologoDao.buscaTodos();
    }

    public boolean adicionaPsicologo(PsicologoDto psicologoDto, EnderecoDto enderecoDto) {
        return psicologoDao.adicionaPsicologo(psicologoDto.toModel(), enderecoDto.toModel());
    }
}
