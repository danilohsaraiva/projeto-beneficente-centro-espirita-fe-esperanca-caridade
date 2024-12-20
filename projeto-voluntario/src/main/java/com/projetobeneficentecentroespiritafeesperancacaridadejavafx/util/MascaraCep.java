package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class MascaraCep {
    public static void aplicaMascaraCpf(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            private boolean ehAtualizado = false;
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String stringAnterior, String stringNova) {
                if(ehAtualizado) {
                    return;
                }

                ehAtualizado = true;

                String valorLimpo = stringNova.replaceAll("[^0-9]", "");


                StringBuilder mascaraBuilder = new StringBuilder();
                for (int i = 0; i < valorLimpo.length(); i++) {
                    if (i == 5) {
                        mascaraBuilder.append("-");
                    }
                    mascaraBuilder.append(valorLimpo.charAt(i));
                }

                textField.setText(mascaraBuilder.length() > 9 ? mascaraBuilder.substring(0,9) : mascaraBuilder.toString());
                textField.positionCaret(mascaraBuilder.length());

                ehAtualizado = false;
            }
        });
    }
}
