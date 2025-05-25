package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PacienteDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.ProntuarioDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.*;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service.MedicoService;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service.PsicologoService;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.MascaraCPF;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import org.hibernate.query.ResultListTransformer;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AgendamentoController implements Initializable {

    Paciente paciente;
    Medico medico;
    Psicologo psicologo;

    @FXML
    private Button btnAgendar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnValidaCpfAgendamentoMedico;

    @FXML
    private Button btnValidaCpfAtendimentoPsicologico;

    @FXML
    private ComboBox<Medico> cbMedico;

    @FXML
    private ComboBox<Psicologo> cbPsicologo;

    @FXML
    private DatePicker dateInicioSintomasAnamneseMedica;

    @FXML
    private DatePicker dateInicioSintomasAnamnesePsicologo;

    @FXML
    private HBox hboxMedico;

    @FXML
    private HBox hboxPsicologo;

    @FXML
    private Label lbMedico;

    @FXML
    private Label lbNomePacienteAtendimentoMedico;

    @FXML
    private Label lbNomePacienteAtendimentoPsicologo;

    @FXML
    private Label lbPsicologo;

    @FXML
    private TextField tfAlergiaAnamneseMedica;

    @FXML
    private TextField tfAlergiaAnamnesePsicologo;

    @FXML
    private TextField tfComorbidadesAnamneseMedica;

    @FXML
    private TextField tfComorbilidadeAnamnesePsicologo;

    @FXML
    private TextField tfCpfAtendimentoMedico;

    @FXML
    private TextField tfCpfAtendimentoPsicologo;

    @FXML
    private TextField tfGlicemiaAnamneseMedica;

    @FXML
    private TextField tfMedicamentoContinuoAnamneseMedica;

    @FXML
    private TextField tfMedicamentoUsoAnamnesePsicologo;

    @FXML
    private TextField tfMotivoConsultaAnamnesePsicologo;

    @FXML
    private TextField tfMotivoConsultaMedico;

    @FXML
    private TextField tfObservacaoAnamneseMedico;

    @FXML
    private TextField tfObservacaoAnamnesePsicologo;

    @FXML
    private TextField tfPressaoAnamneseMedico;

    @FXML
    private TextField tfSintomasAnamneseMedica;

    @FXML
    private TextField tfSintomasAnamnesePsicologo;

    @FXML
    private TextField tfTratamentoAnteriorAnamnesePsicologo;

    @FXML
    private TextField tfTratamentosAnterioresAnamneseMedica;

    @FXML
    private VBox vBoxAgendamentoMedico;

    @FXML
    private VBox vbAgendamentoPsicologo;


    @FXML
    void agendaConsulta(MouseEvent event) {
        if(lbMedico.getFont().getStyle().contains("Bold")) {
            Long idMedico = cbMedico.getSelectionModel().getSelectedItem().getIdMedico();



            //Criando Anamnese Clinica
            AnamneseAtendimendoClinico anamneseClinico  = new AnamneseAtendimendoClinico();
            anamneseClinico.setMotivoConsultaDescricao(tfMotivoConsultaMedico.getText());

            anamneseClinico.setSintomasAssociados(tfSintomasAnamneseMedica.getText());
            anamneseClinico.setComorbidade(tfComorbidadesAnamneseMedica.getText());
            anamneseClinico.setDataInicio(dateInicioSintomasAnamneseMedica.getValue());
            anamneseClinico.setTratamentosAnteriores(tfTratamentosAnterioresAnamneseMedica.getText());
            anamneseClinico.setUsoMedicamento(tfMedicamentoContinuoAnamneseMedica.getText());
            anamneseClinico.setAlergia(tfAlergiaAnamneseMedica.getText());
            anamneseClinico.setPressaoArterial(tfPressaoAnamneseMedico.getText());
            anamneseClinico.setGlicemia(tfGlicemiaAnamneseMedica.getText());
            anamneseClinico.setObservacao(tfObservacaoAnamneseMedico.getText());

            //Criando Consulta
            ConsultaMedica cm = new ConsultaMedica();
            cm.setDataConsulta(LocalDate.now());
            cm.setStatus("Aberto");
            cm.setFkProntuarioPaciente(ProntuarioDao.buscaProntuario(paciente.getIdPaciente()).getIdProntuario());
            cm.setFkMedicoPlantao(idMedico);


        } else if(lbPsicologo.getFont().getStyle().contains("Bold")) {

        }
    }

    @FXML
    void edita(MouseEvent event) {

    }

    @FXML
    void telaAdmin(ActionEvent event) {

    }

    @FXML
    void telaBuscaPaciente(ActionEvent event) {

    }

    @FXML
    void telaCadastroPaciente(ActionEvent event) {

    }
    @FXML
    void selecionaAtendimentoMedico() {
        vbAgendamentoPsicologo.setManaged(false);
        vbAgendamentoPsicologo.setVisible(false);

        vBoxAgendamentoMedico.setManaged(true);
        vBoxAgendamentoMedico.setVisible(true);

        lbMedico.setStyle("-fx-background-color: lightblue; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 5px;");
        lbPsicologo.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-weight: normal;");

        hboxMedico.setVisible(false);
        hboxPsicologo.setVisible(false);

        limparCamposMedico();
    }

    @FXML
    void selecionaAtendimentoPsicologo() {
        vbAgendamentoPsicologo.setManaged(true);
        vbAgendamentoPsicologo.setVisible(true);

        vBoxAgendamentoMedico.setManaged(false);
        vBoxAgendamentoMedico.setVisible(false);

        hboxPsicologo.setVisible(false);
        hboxMedico.setVisible(false);
        lbPsicologo.setStyle("-fx-background-color: lightblue; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 5px;");
        lbMedico.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-weight: normal;");

        limparCamposPsicologo();
    }


    @FXML
    void validaCpfAtendimentoMedico(MouseEvent event) {
        String cpfPaciente = tfCpfAtendimentoMedico.getText().replace(".","").replace("-","");

        paciente = PacienteDao.buscaPacientePorCPF(cpfPaciente);

        if(paciente != null) {
            lbNomePacienteAtendimentoMedico.setText(paciente.getNomeCompletoPaciente());
            hboxMedico.setVisible(true);
        } else {
            lbNomePacienteAtendimentoMedico.setText("CPF NÃO ENCONTRADO");
            hboxMedico.setVisible(false);
        }
    }

    @FXML
    void validaCpfAtendimentoPsicologico(MouseEvent event) {
        String cpfPaciente = tfCpfAtendimentoPsicologo.getText().replace(".","").replace("-","");
        Paciente paciente = PacienteDao.buscaPacientePorCPF(cpfPaciente);
        if(paciente != null) {
            lbNomePacienteAtendimentoPsicologo.setText(paciente.getNomeCompletoPaciente());
            hboxPsicologo.setVisible(true);
        } else {
            lbNomePacienteAtendimentoPsicologo.setText("CPF NÃO ENCONTRADO");
            hboxPsicologo.setVisible(false);
        }
    }

    @FXML
    private void limparCamposMedico() {
        tfCpfAtendimentoMedico.clear();
        lbNomePacienteAtendimentoMedico.setText("");
        cbMedico.setValue(null);
        dateInicioSintomasAnamneseMedica.setValue(null);
        tfAlergiaAnamneseMedica.clear();
        tfComorbidadesAnamneseMedica.clear();
        tfGlicemiaAnamneseMedica.clear();
        tfMedicamentoContinuoAnamneseMedica.clear();
        tfMotivoConsultaMedico.clear();
        tfPressaoAnamneseMedico.clear();
        tfSintomasAnamneseMedica.clear();
        tfTratamentosAnterioresAnamneseMedica.clear();
    }

    @FXML
    private void limparCamposPsicologo() {
        tfCpfAtendimentoPsicologo.clear();
        lbNomePacienteAtendimentoPsicologo.setText("");
        cbPsicologo.setValue(null);
        dateInicioSintomasAnamnesePsicologo.setValue(null);
        tfAlergiaAnamnesePsicologo.clear();
        tfComorbilidadeAnamnesePsicologo.clear();
        tfMedicamentoUsoAnamnesePsicologo.clear();
        tfMotivoConsultaAnamnesePsicologo.clear();
        tfSintomasAnamnesePsicologo.clear();
        tfTratamentoAnteriorAnamnesePsicologo.clear();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vbAgendamentoPsicologo.setManaged(false);
        vbAgendamentoPsicologo.setVisible(false);

        vBoxAgendamentoMedico.setVisible(false);
        vbAgendamentoPsicologo.setManaged(false);

        MascaraCPF.applyCpfMask(tfCpfAtendimentoMedico);
        MascaraCPF.applyCpfMask(tfCpfAtendimentoPsicologo);

        lbMedico.setOnMouseClicked(event -> selecionaAtendimentoMedico());
        lbPsicologo.setOnMouseClicked(event -> selecionaAtendimentoPsicologo());

        carregarMedicos();
        carregarPsicologos();

        cbMedico.setCellFactory(lv -> new ListCell<Medico>() {
            @Override
            protected void updateItem(Medico medico, boolean empty) {
                super.updateItem(medico, empty);
                setText(empty || medico == null ? null : medico.getNomeMedico());
            }
        });

        // Define a exibição correta quando um item é selecionado
        cbMedico.setConverter(new StringConverter<Medico>() {
            @Override
            public String toString(Medico medico) {
                return medico != null ? medico.getNomeMedico() : "";
            }

            @Override
            public Medico fromString(String string) {
                return null; // Não precisa ser implementado para exibição
            }
        });

        cbPsicologo.setCellFactory(lv -> new ListCell<Psicologo>() {
            @Override
            protected void updateItem(Psicologo psicologo, boolean empty) {
                super.updateItem(psicologo, empty);
                setText(empty || psicologo == null ? null : psicologo.getNomePsicologo());
            }
        });

        // Define a exibição correta quando um item é selecionado
        cbPsicologo.setConverter(new StringConverter<Psicologo>() {
            @Override
            public String toString(Psicologo psicologo) {
                return psicologo != null ? psicologo.getNomePsicologo() : "";
            }

            @Override
            public Psicologo fromString(String string) {
                return null; // Não precisa ser implementado para exibição
            }
        });
    }

    private void carregarMedicos() {
        MedicoService ms = new MedicoService();

        List<Medico> medicosList = ms.buscaTodos();
        ObservableList<Medico> medicos = FXCollections.observableArrayList(medicosList);
        cbMedico.setItems(medicos);
    }

    private void carregarPsicologos() {
        PsicologoService ps = new PsicologoService();

        List<Psicologo> psicologosList = ps.buscaTodosPsicologos();
        ObservableList<Psicologo> psicologos = FXCollections.observableArrayList(psicologosList);
        cbPsicologo.setItems(psicologos);
    }
}
