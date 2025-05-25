package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.MedicoDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PsicologoDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Medico;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Psicologo;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.EnderecoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.MedicoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.PsicologoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service.MedicoService;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.service.PsicologoService;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnValidaCepPsicologo;

    @FXML
    private Button btnValidadeCepMedico;

    @FXML
    private DatePicker dataNascimentoPsicologo;

    @FXML
    private DatePicker dateNascimentoMedico;

    @FXML
    private HBox hboxMedico;

    @FXML
    private HBox hboxPsicologo;

    @FXML
    private Label lbMedico;

    @FXML
    private Label lbPsicologo;

    @FXML
    private ListView<Medico> listViewMedicos;

    @FXML
    private ListView<Psicologo> listViewPsicologos;

    @FXML
    private RadioButton rbFemininoMedico;

    @FXML
    private RadioButton rbFemininoPsicologo;

    @FXML
    private RadioButton rbMasculinoMedico;

    @FXML
    private RadioButton rbMasculinoPsicologo;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private TextField tfBairroEnderecoMedico;

    @FXML
    private TextField tfCepEnderecoMedico;

    @FXML
    private TextField tfCepEnderecoPsicologo;

    @FXML
    private TextField tfCidadeEnderecoMedico;

    @FXML
    private TextField tfCidadeEnderecoPsicologo;

    @FXML
    private TextField tfComplementoEnderecoMedico;

    @FXML
    private TextField tfComplementoEnderecopsicologo;

    @FXML
    private TextField tfCpfMedico;

    @FXML
    private TextField tfCpfPsicologo;

    @FXML
    private TextField tfCrmMedico;

    @FXML
    private TextField tfCrpPsicologo;

    @FXML
    private TextField tfEmailMedico;

    @FXML
    private TextField tfEmailPsicologo;

    @FXML
    private TextField tfEspecialidadeMedico;

    @FXML
    private TextField tfEspecialidadePsicologo;

    @FXML
    private TextField tfLogradouroEnderecoPsicologo;

    @FXML
    private TextField tfLogradouroMedico;

    @FXML
    private TextField tfNomeMedico;

    @FXML
    private TextField tfNomePsicologo;

    @FXML
    private TextField tfNumeroEnderecoMedico;

    @FXML
    private TextField tfNumeroEnderecoPsicologo;

    @FXML
    private TextField tfRgMedico;

    @FXML
    private TextField tfRgPsicologo;

    @FXML
    private TextField tfTelefoneMedico;

    @FXML
    private TextField tfTelefonePsicologo;

    @FXML
    private TextField tfUfCrm;

    @FXML
    private TextField tfUfCrpPsicologo;

    @FXML
    private TextField tfUfEnderecoMedico;

    @FXML
    private TextField tfUfEnderecoPsicologo;

    @FXML
    private TextField tfUfRg;

    @FXML
    private TextField tfUfRgPsicologo;

    private ObservableList<Medico> listaMedicos;
    private ObservableList<Psicologo> listaPsicologos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listViewMedicos.setVisible(false);
        listViewMedicos.setManaged(false);

        listViewPsicologos.setVisible(false);
        listViewPsicologos.setManaged(false);

        btnAdicionar.setVisible(false);
        btnAdicionar.setManaged(false);

        btnEditar.setVisible(false);
        btnEditar.setManaged(false);

        hboxMedico.setVisible(false);
        hboxMedico.setManaged(false);

        hboxPsicologo.setVisible(false);
        hboxPsicologo.setManaged(false);


        listaMedicos = FXCollections.observableArrayList();
        listViewMedicos.setItems(listaMedicos);


        listaPsicologos = FXCollections.observableArrayList();
        listViewPsicologos.setItems((listaPsicologos));

        listViewMedicos.setCellFactory(listView -> new ListCell<Medico>() {
            @Override
            protected void updateItem(Medico medico, boolean empty) {
                super.updateItem(medico, empty);
                if (empty || medico == null) {
                    setText(null);
                } else {
                    setText(medico.getNomeMedico() + " - CRM: " + medico.getCrm());
                }
            }
        });

        // Configura a exibição personalizada no ListView de psicólogos
        listViewPsicologos.setCellFactory(listView -> new ListCell<Psicologo>() {
            @Override
            protected void updateItem(Psicologo psicologo, boolean empty) {
                super.updateItem(psicologo, empty);
                if (empty || psicologo == null) {
                    setText(null);
                } else {
                    setText(psicologo.getNomePsicologo() + " - CRP: " + psicologo.getCrp());
                }
            }
        });


        carregarMedicos();
        carregarPsicologos();


        lbMedico.setOnMouseClicked(event -> selecionarMedicos());
        lbPsicologo.setOnMouseClicked(event -> selecionarPsicologos());


        btnConfirmar.setOnAction(event -> {
            try {
                if (lbMedico.getFont().getStyle().contains("Bold")) {
                    MedicoDto medicoDto = criarMedicoDto();
                    EnderecoDto enderecoDto = criarEnderecoDto();
                    MedicoService medicoService = new MedicoService();

                    if (medicoService.adicionaMedico(medicoDto, enderecoDto)) {
                        carregarMedicos();
                        exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Médico adicionado com sucesso!");

                    } else {
                        exibirAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao adicionar o médico.");
                    }
                }
                // Verifica se o lbPsicologo está em negrito
                else if (lbPsicologo.getFont().getStyle().contains("Bold")) {
                    PsicologoDto psicologoDto = criarPsicologoDto();
                    EnderecoDto enderecoDto = criarEnderecoDto();

                    PsicologoService psicologoService = new PsicologoService();
                    if(psicologoService.adicionaPsicologo(psicologoDto, enderecoDto)) {
                        carregarPsicologos();
                        exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Psicologo adicionado com sucesso!");
                    } else {
                        exibirAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao adicionar o psicologo.");
                    }
                }
            } catch (Exception e) {
                exibirAlerta(Alert.AlertType.ERROR, "Erro", "Ocorreu um erro inesperado!");
                e.printStackTrace();
            }
        });

    }

    private void inicializarListenersListas() {

    }

    private MedicoDto criarMedicoDto() {
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setNomeMedico(tfNomeMedico.getText());
        medicoDto.setCpfMedico(tfCpfMedico.getText());
        medicoDto.setDataNascimentoMedico(dateNascimentoMedico.getValue());
        if (rbFemininoMedico.isSelected()) {
            medicoDto.setSexo("F");
        } else if (rbMasculinoMedico.isSelected()) {
            medicoDto.setSexo("M");
        }
        medicoDto.setEspecialidadeMedico(tfEspecialidadeMedico.getText());
        medicoDto.setTelefoneMedico(tfTelefoneMedico.getText());
        medicoDto.setEmailMedico(tfEmailMedico.getText());
        medicoDto.setCrm(tfCrmMedico.getText());

        medicoDto.setUfRegistroCrm(tfUfCrm.getText());

        medicoDto.setRgMedico(tfRgMedico.getText());
        medicoDto.setUfRgMedico(tfUfRg.getText());

        return medicoDto;
    }

    public PsicologoDto criarPsicologoDto() {
        PsicologoDto psicologoDto = new PsicologoDto();
        psicologoDto.setNomePsicologo(tfNomePsicologo.getText());
        psicologoDto.setTelefonePsicologo(tfTelefonePsicologo.getText());
        psicologoDto.setEmail(tfEmailPsicologo.getText());
        psicologoDto.setCrp(tfCrpPsicologo.getText());
        psicologoDto.setUfRegistroCrp(tfUfCrpPsicologo.getText());
        psicologoDto.setEspecialidade(tfEspecialidadePsicologo.getText());
        psicologoDto.setRgPsicologo(tfRgPsicologo.getText());
        psicologoDto.setUrRg(tfUfRgPsicologo.getText());
        psicologoDto.setAnoNascimentoProfissional(dataNascimentoPsicologo.getValue());

        if (rbFemininoPsicologo.isSelected()) {
            psicologoDto.setSexoPsicologo("F");
        } else if (rbMasculinoPsicologo.isSelected()) {
            psicologoDto.setSexoPsicologo("M");
        }

        return psicologoDto;
    }


    private EnderecoDto criarEnderecoDto() {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setLogradouroEndereco(tfBairroEnderecoMedico.getText());
        enderecoDto.setNumero(tfNumeroEnderecoMedico.getText());
        enderecoDto.setComplemento(tfComplementoEnderecoMedico.getText());
        enderecoDto.setCep(tfCepEnderecoMedico.getText());
        enderecoDto.setBairro(tfBairroEnderecoMedico.getText());
        enderecoDto.setCidade(tfCidadeEnderecoMedico.getText());
        enderecoDto.setUf(tfUfEnderecoMedico.getText());

        return enderecoDto;
    }


    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void carregarMedicos() {
        MedicoService ms = new MedicoService();
        List<Medico> medicos = ms.buscaTodos();
        listaMedicos.setAll(medicos);
    }

    private void carregarPsicologos() {
        PsicologoDao psicologoDao = new PsicologoDao();
        List<Psicologo> psicologos = psicologoDao.buscaTodos();
        listaPsicologos.setAll(psicologos);
    }

    private void habilitaBotoesAdicionar() {
        btnConfirmar.setVisible(true);
        btnConfirmar.setManaged(true);

        btnCancelar.setVisible(true);
        btnCancelar.setManaged(true);
    }

    private void desabilitaBotoes() {
        btnAdicionar.setVisible(false);
        btnAdicionar.setManaged(false);

        btnEditar.setVisible(false);
        btnEditar.setManaged(false);

        btnConfirmar.setVisible(false);
        btnConfirmar.setManaged(false);

        btnCancelar.setVisible(false);
        btnCancelar.setManaged(false);
    }

    private void desabilitaListas() {
        listViewPsicologos.setVisible(false);
        listViewPsicologos.setManaged(false);

        listViewMedicos.setVisible(false);
        listViewMedicos.setManaged(false);
    }


    private void esconderTodosVBoxes() {
        hboxMedico.setVisible(false);
        hboxMedico.setManaged(false);

        hboxPsicologo.setVisible(false);
        hboxPsicologo.setManaged(false);
    }

    @FXML
    void selecionarMedicos() {
        esconderTodosVBoxes();
        desabilitaBotoes();
        listViewMedicos.setVisible(true);
        listViewMedicos.setManaged(true);

        listViewPsicologos.setVisible(false);
        listViewPsicologos.setManaged(false);

        btnAdicionar.setVisible(true);
        btnAdicionar.setManaged(true);

        btnEditar.setVisible(true);
        btnEditar.setManaged(true);

        lbMedico.setStyle("-fx-background-color: lightblue; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 5px;");
        lbPsicologo.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-weight: normal;");
    }

    @FXML
    void selecionarPsicologos() {
        desabilitaBotoes();
        esconderTodosVBoxes();
        listViewMedicos.setVisible(false);
        listViewMedicos.setManaged(false);

        listViewPsicologos.setVisible(true);
        listViewPsicologos.setManaged(true);

        btnAdicionar.setVisible(true);
        btnAdicionar.setManaged(true);

        btnEditar.setVisible(true);
        btnEditar.setManaged(true);

        lbPsicologo.setStyle("-fx-background-color: lightblue; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 5px;");
        lbMedico.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-weight: normal;");
    }


    @FXML
    void telaAgendar(ActionEvent event) throws IOException {
        ViewManager.getInstance().changeScreen(TipoTela.AGENDAMENTO, "AGENDAMENTO");
    }

    @FXML
    void telaCadastroPaciente(ActionEvent event) throws IOException {
        ViewManager.getInstance().showScreen(TipoTela.CADASTRO_PACIENTE);
        ViewManager.getInstance().getSceneMain().setTitle("CADASTRO PACIENTE");

    }

    @FXML
    void telaBuscaPaciente(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.BUSCA_PACIENTE);
        ViewManager.getInstance().getSceneMain().setTitle("BUSCAR PACIENTE");
    }

    @FXML
    void telaAdmin(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.ADMIN);
        ViewManager.getInstance().getSceneMain().setTitle("ADMIN");
    }


    public void edita(MouseEvent mouseEvent) {
        System.out.println("Editado!");
    }

    @FXML
    public void adicionaProfissional(MouseEvent mouseEvent) {
        esconderTodosVBoxes(); // Esconde ambos antes de exibir o correto
        desabilitaBotoes();

        if (lbMedico.getFont().getStyle().contains("Bold")) {
            desabilitaListas();
            System.out.println("Adicionando Médico...");
            hboxMedico.setVisible(true);
            hboxMedico.setManaged(true);

            habilitaBotoesAdicionar();
        } else {
            desabilitaListas();
            System.out.println("Adicionando Psicólogo...");
            hboxPsicologo.setVisible(true);
            hboxPsicologo.setManaged(true);
            habilitaBotoesAdicionar();
        }
    }
}
