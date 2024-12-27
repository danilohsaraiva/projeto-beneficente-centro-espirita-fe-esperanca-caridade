package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PacienteDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BuscaPacienteController implements Initializable {
    @FXML
    private ListView<Paciente> listPacientes;


    @FXML
    private TextField tfBuscaPaciente;

    private ObservableList<Paciente> listaPacientes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaPacientes = FXCollections.observableArrayList();
        listPacientes.setItems(listaPacientes);

        listPacientes.setCellFactory(listView -> new ListCell<Paciente>() {
            @Override
            protected void updateItem(Paciente paciente, boolean empty) {
                super.updateItem(paciente, empty);
                if (empty || paciente == null) {
                    setText(null);
                } else {
                    setText(paciente.getNomeCompletoPaciente() + " - CPF: " + paciente.getCpfPaciente());
                }
            }
        });

        tfBuscaPaciente.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                atualizaListaPaciente(newValue);
            }
        });

        listPacientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Paciente>() {
            @Override
            public void changed(ObservableValue<? extends Paciente> observable, Paciente oldPaciente, Paciente newPaciente) {
                if (newPaciente != null) {
                    // Aqui você pode usar as informações do paciente selecionado
                    System.out.println("Paciente Selecionado:");
                    System.out.println("Nome: " + newPaciente.getNomeCompletoPaciente());
                    System.out.println("Outro item" + newPaciente.getIdPaciente());
                    System.out.println("CPF: " + newPaciente.getCpfPaciente());
                    // Exemplo de uso: redirecionar ou preencher outro campo
                }
            }
        });
    }

    private void atualizaListaPaciente(String filtro) {
        if (filtro == null || filtro.trim().isEmpty()) {
            listaPacientes.clear();
        } else {
            List<Paciente> pacientes = PacienteDao.buscaPacientes(filtro);

            listaPacientes.setAll(pacientes);
        }

    }
}
