package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.MedicoDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Medico;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.EnderecoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.MedicoDto;

import java.util.List;

public class MedicoService {
    private final MedicoDao medicoDao;

    public MedicoService() {
        this.medicoDao = new MedicoDao();
    }

    public  boolean adicionaMedico(MedicoDto medicoDto, EnderecoDto enderecoDto) {
        return medicoDao.adicionarMedicoComEndereco(medicoDto.toModel(), enderecoDto.toModel());
    }

    public List<Medico> buscaTodos() {
        return medicoDao.buscaTodos();
    }
}
