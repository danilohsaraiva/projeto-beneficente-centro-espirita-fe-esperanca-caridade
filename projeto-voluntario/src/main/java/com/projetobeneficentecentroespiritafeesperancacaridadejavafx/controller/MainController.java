package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.Main;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Usuario;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.UsuarioDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service.UsuarioService;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lombok.Data;

@Data
public class MainController {
    //Armazena a instância da tela para chamar os métodos diretamente, sem precisar instanciar objetos
    private Main main;

    @FXML
    private PasswordField pwdSenha;

    @FXML
    private TextField txfUsuario;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void fazLogin(MouseEvent event) {

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setLogin(txfUsuario.getText());
        usuarioDto.setSenha(pwdSenha.getText());



        try {
            Usuario usuario = UsuarioService.validaUsuario(usuarioDto);
            if (usuario != null) {
                ViewManager.getInstance().showScreen(TipoTela.PRINCIPAL);
            }
        } catch (Exception e) {
            System.out.println("Usuário/Senha Inválidos!");
        }
    }
}
