package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view.ViewManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.Data;

import java.io.IOException;

@Data
public class PrincipalController {

    private Usuario usuario;
    private Parent layoutCadastroPaciente;
    private Parent pacienteBusca;





    @FXML
    void telaCadastroPaciente(ActionEvent event) throws IOException {
        ViewManager.getInstance().showScreen(TipoTela.CADASTRO_PACIENTE);
        ViewManager.getInstance().getSceneMain().setTitle("CADASTRO PACIENTE");


    }

    @FXML
    void telaBuscaPaciente(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.BUSCA_PACIENTE);
        ViewManager.getInstance().getSceneMain().setTitle("BUSCAR PACIENTE");
    }

    @FXML
    void telaAdmin(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.ADMIN);
        ViewManager.getInstance().getSceneMain().setTitle("ADMINISTRADOR");
    }

    @FXML
    void telaAgendar(ActionEvent event) throws IOException{
        ViewManager.getInstance().changeScreen(TipoTela.AGENDAMENTO,"AGENDAMENTO");
        ViewManager.getInstance().getSceneMain().setTitle("AGENDAMENTO");
    }


    @FXML
    void visualizarAtendimentos(ActionEvent event) {
        ViewManager.getInstance().changeScreen(TipoTela.AGENDAMENTOS, "AGENDAMENTOS");
        ViewManager.getInstance().getSceneMain().setTitle("AGENDAMENTOS");
    }
}
