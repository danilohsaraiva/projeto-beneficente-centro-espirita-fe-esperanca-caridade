package com.projetobeneficentecentroespiritafeesperancacaridadejavafx;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller.MainController;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
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




        } catch (Exception e) {
            e.printStackTrace();
        }

        ViewManager.getInstance().showScreen(TipoTela.LOGIN);
    }

    public static void main(String[] args) {
        launch();
    }
}