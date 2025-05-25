package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PacienteDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.enuns.TipoTela;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Limitacao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Prontuario;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.EnderecoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.LimitacaoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.PacienteDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.MascaraCPF;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.MascaraCelular;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.MascaraCep;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.ValidaInput;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CadastroPacienteController implements Initializable {

    private int util;

    private static final List<String> ESTADOS_BRASILEIROS = Arrays.asList(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
            "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    );

    private static final List<String> RACA_COR_IBGE = Arrays.asList(
            "Branca",
            "Preta",
            "Parda",
            "Amarela",
            "Indígena",
            "Não Declarada"
    );

    @FXML
    private Button btnAdicionarPaciente;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCancela;

    @FXML
    private Button btnValidarCep;

    @FXML
    private CheckBox cbAudicao;

    @FXML
    private CheckBox cbCognitiva;

    @FXML
    private CheckBox cbLocomocao;

    @FXML
    private ComboBox<String> cbRaca;

    @FXML
    private CheckBox cbSim;

    @FXML
    private ComboBox<String> cbUfEndereco;

    @FXML
    private ComboBox<String> cbUfRg;

    @FXML
    private CheckBox cbVisao;

    @FXML
    private DatePicker dpDataNascimento;

    @FXML
    private HBox hBoxDeficiencia;

    @FXML
    private HBox hBoxDeficienciaOutros;

    @FXML
    private Label lbBairro;

    @FXML
    private Label lbCartaoSus;

    @FXML
    private Label lbCep;

    @FXML
    private Label lbCidade;

    @FXML
    private Label lbComplemento;

    @FXML
    private Label lbCpf;

    @FXML
    private Label lbDataNascimento;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbEndereco;

    @FXML
    private Label lbEscolaridade;

    @FXML
    private Label lbEstadoCivil;

    @FXML
    private Label lbGenero;

    @FXML
    private Label lbNacionalidade;

    @FXML
    private Label lbNaturalidade;

    @FXML
    private Label lbNomeCompleto;

    @FXML
    private Label lbNomeContatoEmergencia;

    @FXML
    private Label lbNumero;

    @FXML
    private Label lbOcupacao;

    @FXML
    private Label lbOutroContatoEmergencia;

    @FXML
    private Label lbQuestionaDeficiencia;

    @FXML
    private Label lbRaca;

    @FXML
    private Label lbRg;

    @FXML
    private Label lbSexo;

    @FXML
    private Label lbTelefone;

    @FXML
    private Label lbTelefoneContatoEmergencia;

    @FXML
    private Label lbTipoDeficiencia;

    @FXML
    private Label lbUfCidade;

    @FXML
    private Label lbUfRg;

    @FXML
    private RadioButton rBtnF;

    @FXML
    private RadioButton rBtnM;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private TextField tfBairro;

    @FXML
    private TextField tfCartaoSus;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfComplemento;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfDeficienciaOutro;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfEscolaridade;

    @FXML
    private TextField tfEstadoCivil;

    @FXML
    private TextField tfGenero;

    @FXML
    private TextField tfNacionalidade;

    @FXML
    private TextField tfNaturalidade;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNomeContatoEmergencia;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfOcupacao;

    @FXML
    private TextField tfOutroEmergencia;

    @FXML
    private TextField tfRg;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfTelefoneEmergencia;
    public void limparCampos() {
        // Limpar campos de texto
        tfNome.clear();
        tfCpf.clear();
        tfRg.clear();
        tfEmail.clear();
        tfEscolaridade.clear();
        tfEstadoCivil.clear();
        tfGenero.clear();
        tfOcupacao.clear();
        tfNaturalidade.clear();
        tfNacionalidade.clear();
        tfCartaoSus.clear();
        tfEndereco.clear();
        tfBairro.clear();
        tfCidade.clear();
        tfComplemento.clear();
        tfNumero.clear();
        tfCep.clear();
        tfTelefone.clear();
        tfNomeContatoEmergencia.clear();
        tfTelefoneEmergencia.clear();
        tfOutroEmergencia.clear();
        tfDeficienciaOutro.clear();

        // Limpar seleção de botões de rádio (sexo)
        sexo.selectToggle(null);

        // Limpar ComboBox
        cbUfEndereco.setValue(null);
        cbUfRg.setValue(null);
        cbRaca.setValue(null);

        // Limpar DatePicker
        dpDataNascimento.setValue(null);

        // Desmarcar CheckBoxes
        cbSim.setSelected(false);
        cbAudicao.setSelected(false);
        cbCognitiva.setSelected(false);
        cbLocomocao.setSelected(false);
        cbVisao.setSelected(false);

        // Ocultar HBox de deficiências, se necessário
        hBoxDeficiencia.setVisible(false);
        hBoxDeficienciaOutros.setVisible(false);
    }

    @FXML
    void cancelaCadastroPaciente(MouseEvent event) {

        // Criação do Alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CANCELAR CADASTRO");
        alert.setHeaderText("Deseja cancelar o cadastro?");

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            limparCampos();
            ViewManager.getInstance().showScreen(TipoTela.PRINCIPAL);
            ViewManager.getInstance().getSceneMain().setTitle("PRINCIPAL");
        }

        // Montagem da descrição de deficiências


    }
    @FXML
    void adicionaPaciente(MouseEvent event) {
        confirmaDadosPacientes();
    }
    @FXML
    void telaCadastraPaciente(ActionEvent event) throws IOException {
        ViewManager.getInstance().showScreen(TipoTela.CADASTRO_PACIENTE);
        ViewManager.getInstance().getSceneMain().setTitle("CADASTRO PACIENTE");


    }

    @FXML
    void telaBuscaPaciente(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.BUSCA_PACIENTE);
        ViewManager.getInstance().getSceneMain().setTitle("BUSCAR PACIENTE");
    }

    @FXML
    void telaAgendamento(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.AGENDAMENTO);
        ViewManager.getInstance().getSceneMain().setTitle("AGENDAMENTO");
    }

    @FXML
    void telaAdmin(ActionEvent event) {
        ViewManager.getInstance().showScreen(TipoTela.ADMIN);
        ViewManager.getInstance().getSceneMain().setTitle("ADMIN");
    }


    public void add() {
        try {


            EnderecoDto enderecoDto = new EnderecoDto();

            String cep = tfCep.getText().replace("-", "");
            enderecoDto.setCep(cep);


            enderecoDto.setLogradouroEndereco(tfEndereco.getText());
            enderecoDto.setCidade(tfCidade.getText());
            enderecoDto.setUf(cbUfEndereco.getValue().toString());
            enderecoDto.setBairro(tfBairro.getText());
            enderecoDto.setComplemento(tfComplemento.getText());
            enderecoDto.setNumero(tfNumero.getText());

            Endereco endereco = enderecoDto.toModel();


            PacienteDto pacienteDto = new PacienteDto();
            String cpf = tfCpf.getText().replace("-", "").replace(".", "");
            pacienteDto.setCpfPaciente(cpf);
            pacienteDto.setNomeCompletoPaciente(tfNome.getText());
            pacienteDto.setDataNascimentoPaciente(dpDataNascimento.getValue());
            pacienteDto.setSexoBiologicoPaciente(rBtnF.isSelected() ? "F" : "M");
            pacienteDto.setEstadoCivil(tfEstadoCivil.getText());
            pacienteDto.setGeneroPaciente(tfGenero.getText());
            pacienteDto.setEmailPaciente(tfEmail.getText());
            pacienteDto.setEscolaridadePaciente(tfEscolaridade.getText());
            pacienteDto.setOcupacaoPaciente(tfOcupacao.getText());
            pacienteDto.setNaturalidade(tfNaturalidade.getText());
            pacienteDto.setNacionalidade(tfNacionalidade.getText());
            pacienteDto.setCorRaca(cbRaca.getValue().toString());
            pacienteDto.setCartaoNascionalSaude(tfCartaoSus.getText());
            pacienteDto.setRgPaciente(tfRg.getText());


            Paciente paciente = pacienteDto.toModel();

            if(cbSim.isSelected()) {
                LimitacaoDto limitacaoDto = new LimitacaoDto();
                limitacaoDto.setEhAudicao(cbAudicao.isSelected());
                limitacaoDto.setEhLocomocao(cbLocomocao.isSelected());
                limitacaoDto.setEhVisao(cbVisao.isSelected());
                limitacaoDto.setEhCognitiva(cbCognitiva.isSelected());
                limitacaoDto.setOutroDescricao(tfDeficienciaOutro.getText());

                Limitacao limitacao = limitacaoDto.toModel();
            }
            Prontuario prontuario = new Prontuario();
            prontuario.setDataAbertura(LocalDate.now());
            paciente.setProntuario(prontuario);

            PacienteDao.adicionaPacienteComEndereco(paciente, endereco);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro realizado");
            alert.setHeaderText(null);
            alert.setContentText("O paciente foi cadastrado com sucesso!");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar Paciente");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no Cadastro");
            alert.setHeaderText("Não foi possível cadastrar o paciente.");
            alert.setContentText("Verifique os dados e tente novamente.");
            alert.showAndWait();
        }
    }

    public void confirmaDadosPacientes() {
        String cpf = tfCpf.getText().replace("-", "").replace(".", "");

        // Criar o alerta de confirmação
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação do Cadastro");
        alert.setHeaderText("Confira os dados do paciente antes de confirmar.");

        // Montagem da descrição de deficiências
        String pcdDescricao = montarDescricaoDeficiencias();

        // Construção do conteúdo formatado
        String contentText = """
        *** DADOS PESSOAIS ***
        Nome: %s
        CPF: %s
        RG: %s - %s
        Data Nascimento: %s
        Sexo: %s
        Gênero: %s
        Estado Civil: %s
        Email: %s
        Escolaridade: %s
        Ocupação: %s
        Naturalidade: %s
        Nacionalidade: %s
        Raça: %s
        Cartão SUS: %s
        
        *** ENDEREÇO ***
        %s, Número: %s
        %s, %s
        %s - %s
        CEP: %s
        %s
        """.formatted(
                tfNome.getText(), cpf, tfRg.getText(), cbUfRg.getValue(),
                dpDataNascimento.getValue(), (rBtnF.isSelected() ? "Feminino" : "Masculino"),
                tfGenero.getText(), tfEstadoCivil.getText(), tfEmail.getText(),
                tfEscolaridade.getText(), tfOcupacao.getText(), tfNaturalidade.getText(),
                tfNacionalidade.getText(), cbRaca.getValue().toString(), tfCartaoSus.getText(),
                tfEndereco.getText(), tfNumero.getText(), tfBairro.getText(),
                (tfComplemento.getText().isEmpty() ? "" : tfComplemento.getText() + ", "),
                tfCidade.getText(), cbUfEndereco.getValue(), tfCep.getText(), pcdDescricao
        );

        // Criando um TextArea para exibir o conteúdo formatado
        TextArea textArea = new TextArea(contentText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        // Personalizando o DialogPane para exibir o TextArea
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setExpandableContent(textArea);
        dialogPane.setExpanded(true); // Mantém a área expandida por padrão

        // Exibir o alerta e capturar a resposta do usuário
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                add();
                limparCampos();
            } else {

            }
        });
    }


    private String montarDescricaoDeficiencias() {
        if (cbSim.isSelected()) {
            StringBuilder descricao = new StringBuilder("\n\n*** Limitação ***\n");
            if (cbAudicao.isSelected()) descricao.append("Auditiva\n");
            if (cbCognitiva.isSelected()) descricao.append("Cognitiva\n");
            if (cbLocomocao.isSelected()) descricao.append("Locomotora\n");
            if (cbVisao.isSelected()) descricao.append("Visão\n");
            if (!tfDeficienciaOutro.getText().isEmpty()) descricao.append(tfDeficienciaOutro.getText());

            return descricao.toString();
        } else {
            return "\n\n*** Limitação ***\nNão possuí";
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hBoxDeficiencia.setVisible(false);


        cbUfEndereco.setItems(FXCollections.observableArrayList(ESTADOS_BRASILEIROS));
        cbUfRg.setItems(FXCollections.observableArrayList(ESTADOS_BRASILEIROS));
        cbRaca.setItems(FXCollections.observableArrayList(RACA_COR_IBGE));

        MascaraCep.aplicaMascaraCpf(tfCep);
        MascaraCPF.applyCpfMask(tfCpf);
        MascaraCelular.applyPhoneMask(tfTelefone);
        MascaraCelular.applyPhoneMask(tfTelefoneEmergencia);
        ValidaInput.somenteNumeros(tfNumero);




        System.out.println("Inicializando controlador...");

        if (cbSim == null) {
            System.out.println("Erro: cbSim está nulo!");
        }
        if (hBoxDeficiencia == null) {
            System.out.println("Erro: hBoxDeficiencia está nulo!");
        }
        if (hBoxDeficienciaOutros == null) {
            System.out.println("Erro: hBoxDeficienciaOutros está nulo!");
        }

        // Configuração do listener
        cbSim.selectedProperty().addListener((observable, oldValue, newValue) -> {
            hBoxDeficiencia.setVisible(newValue);
            hBoxDeficiencia.setManaged(newValue);
            hBoxDeficienciaOutros.setVisible(newValue);
            hBoxDeficienciaOutros.setManaged(newValue);
        });
    }
}
