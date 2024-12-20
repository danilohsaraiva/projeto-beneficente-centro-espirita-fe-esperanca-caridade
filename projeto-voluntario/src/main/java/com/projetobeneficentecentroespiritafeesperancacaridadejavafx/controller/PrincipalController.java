package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view.PrincipalView;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.Data;

import java.io.IOException;

@Data
public class PrincipalController {

    PrincipalView principalView;
    private Usuario usuario;
    private Parent layoutCadastroPaciente;
    private Parent pacienteBusca;

    public void setPrincipalView(PrincipalView principalView) {
        this.principalView = principalView;
    }



    @FXML
    void cadastroPaciente(ActionEvent event) throws IOException {
        ViewManager viewManager = ViewManager.getInstance();
        viewManager.showScreen(TipoTela.CADASTRO_PACIENTE);
    }
}
