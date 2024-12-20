package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util;

import javafx.scene.control.TextField;

public class MascaraCelular {
    public static void applyPhoneMask(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Remove todos os caracteres não numéricos
            String numericValue = newValue.replaceAll("[^\\d]", "");

            // Limita a 11 dígitos (DDD + número)
            if (numericValue.length() > 11) {
                numericValue = numericValue.substring(0, 11);
            }

            // Formata o texto como número de telefone
            StringBuilder formatted = new StringBuilder();
            if (numericValue.length() > 0) {
                formatted.append("(");
                formatted.append(numericValue, 0, Math.min(2, numericValue.length()));
            }
            if (numericValue.length() > 2) {
                formatted.append(") ");
                formatted.append(numericValue, 2, Math.min(7, numericValue.length()));
            }
            if (numericValue.length() > 7) {
                formatted.append("-");
                formatted.append(numericValue.substring(7));
            }

            // Atualiza o texto do TextField com o número formatado
            textField.setText(formatted.toString());

            // Mantém o cursor no final do texto
            textField.positionCaret(formatted.length());
        });
    }
}
