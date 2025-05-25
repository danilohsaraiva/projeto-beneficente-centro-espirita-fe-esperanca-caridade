package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PacienteDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.TelefoneContatoEmergencia;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.PacienteDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.TelefoneContatoEmergenciaDto;

import java.util.List;

public class PacienteService {
    public static Paciente buscaPacientePorCPF(String cpf) {
        return PacienteDao.buscaPacientePorCPF(cpf);
    }
    /*public static Endereco buscaEndereco(Long id, EnderecoDto enderecoDto) {
    }*/



    public static boolean adicionaPaciente(PacienteDto pacienteDto) {
        return PacienteDao.adicionaPaciente(pacienteDto.toModel());
    }

    public static List<TelefoneContatoEmergencia> buscaListaContatoEmergencia(Long idPaciente) {
        return PacienteDao.buscaListaContatoEmergencia(idPaciente);
    }

    public static boolean adicionaTelefoneContatoEmergencia(Long idPaciente, TelefoneContatoEmergenciaDto telefoneContatoEmergenciaDto) {
        return PacienteDao.adicionaTelefoneContatoEmergencia(idPaciente, telefoneContatoEmergenciaDto.toModel());
    }

    public static boolean removeTelefoneContatoEmergencia(Long idPaciente, Long idTelefoneContatoEmergencia) {
        return PacienteDao.removeTelefoneContatoEmergencia(idPaciente, idTelefoneContatoEmergencia);
    }

}
