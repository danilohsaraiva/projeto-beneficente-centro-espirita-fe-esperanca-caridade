package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PacienteDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.PacienteDto;

import java.util.List;

public class PacienteService {
    public List<Endereco> buscaEndereco;

    public boolean adicionaPaciente(PacienteDto pacienteDto) {
        boolean ehAdicionado = false;

        PacienteDao.adicionaPaciente(pacienteDto.toModel());

        return ehAdicionado;
    }
}
