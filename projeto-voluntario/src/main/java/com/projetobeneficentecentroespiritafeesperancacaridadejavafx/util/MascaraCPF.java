package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util;

import javafx.scene.control.TextField;

public class MascaraCPF {
        public static void applyCpfMask(TextField textField) {
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                // Remove todos os caracteres não numéricos
                String numericValue = newValue.replaceAll("[^\\d]", "");

                // Limita a 11 dígitos
                if (numericValue.length() > 11) {
                    numericValue = numericValue.substring(0, 11);
                }

                // Formata o texto como CPF
                StringBuilder formatted = new StringBuilder();
                if (numericValue.length() > 3) {
                    formatted.append(numericValue, 0, 3).append(".");
                    if (numericValue.length() > 6) {
                        formatted.append(numericValue, 3, 6).append(".");
                        if (numericValue.length() > 9) {
                            formatted.append(numericValue, 6, 9).append("-");
                            formatted.append(numericValue.substring(9));
                        } else {
                            formatted.append(numericValue.substring(6));
                        }
                    } else {
                        formatted.append(numericValue.substring(3));
                    }
                } else {
                    formatted.append(numericValue);
                }

                // Atualiza o texto do TextField com o CPF formatado
                textField.setText(formatted.toString());

                // Mantém o cursor no final do texto
                textField.positionCaret(formatted.length());
            });
        }
}
