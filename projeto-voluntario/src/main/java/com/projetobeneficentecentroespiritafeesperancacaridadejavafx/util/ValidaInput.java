package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util;

import javafx.scene.control.TextField;

public class ValidaInput {
    public static void somenteNumeros(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Verifica se o novo valor contém apenas números
            if (!newValue.matches("\\d*")) {
                // Se não for número, restaura o valor anterior
                textField.setText(oldValue);
            }
        });
    }
}
