package com.projetobeneficentecentroespiritafeesperancacaridadejavafx;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller.MainController;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PacienteDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;
import java.util.List;

@Data
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        try {
            ViewManager viewManager = ViewManager.getInstance();
            viewManager.setSceneMain(stage);

            viewManager.addScreen(TipoTela.CADASTRO_PACIENTE,"cadastro-paciente-view.fxml");
            viewManager.addScreen(TipoTela.PRINCIPAL, "principal-view.fxml");
            viewManager.addScreen(TipoTela.LOGIN,"hello-view.fxml");
            viewManager.addScreen(TipoTela.BUSCA_PACIENTE, "busca-paciente.fxml");
            viewManager.addScreen(TipoTela.ADMIN, "admin.fxml");
            viewManager.addScreen(TipoTela.AGENDAMENTO, "agendamento.fxml");
            viewManager.addScreen(TipoTela.AGENDAMENTOS, "agendamentos.fxml");



        } catch (Exception e) {
            e.printStackTrace();
        }

        ViewManager.getInstance().showScreen(TipoTela.LOGIN);
        ViewManager.getInstance().getSceneMain().setTitle("LOGIN");
        ViewManager.getInstance().getSceneMain().setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}