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
    void cadastroPaciente(ActionEvent event) throws IOException {
        ViewManager.getInstance().showScreen(TipoTela.CADASTRO_PACIENTE);
        Stage stage = (Stage) ViewManager.getInstance().getSceneMain().getScene().getWindow();
        ViewManager.getInstance().getSceneMain().setTitle("CADASTRO PACIENTE");


    }

    @FXML
    void buscaPaciente(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.BUSCA_PACIENTE);
        ViewManager.getInstance().getSceneMain().setTitle("BUSCAR PACIENTE");
        ViewManager.getInstance().getSceneMain().setMaximized(true);
    }
}
