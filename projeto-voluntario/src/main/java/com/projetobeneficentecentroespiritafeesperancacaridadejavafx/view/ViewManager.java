package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.Main;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller.MainController;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class ViewManager {
    private Usuario usuario;
    private static ViewManager instance;


    private Stage sceneMain;


    private final Map<String, Scene> scenes = new HashMap<>();
    private final Map<String, Object> controllers = new HashMap<>();
    private final Map<String, Parent> parents = new HashMap<>();

    public Object getController(TipoTela tipoTela) {
        return controllers.get(tipoTela.toString());
    }

    public static ViewManager getInstance() {
        if (instance == null) {
            instance = new ViewManager();
        }
        return instance;
    }


    public void addScreen(TipoTela tipoTela, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));

        Parent parent = loader.load();

        Object controller = loader.getController();

        controllers.put(tipoTela.toString(), controller);

        scenes.put(tipoTela.toString(), new Scene(parent));

        parents.put(tipoTela.toString(), parent);
    }

    public void showScreen(TipoTela tipo) {
        Scene scene = scenes.get(tipo.toString());


        if (scene != null) {
            sceneMain.setScene(scene);

            sceneMain.show();
        } else {
            System.out.println("Tela não encontrada: " + tipo.toString());
        }
    }

}
