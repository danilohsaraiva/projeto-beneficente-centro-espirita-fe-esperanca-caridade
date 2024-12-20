package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller.PrincipalController;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;

@Data
public class PrincipalView {

    private static Stage stagePrincipal;
    private PrincipalController principalController;

}