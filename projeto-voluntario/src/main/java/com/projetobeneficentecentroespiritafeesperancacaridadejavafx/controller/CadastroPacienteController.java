package com.projetobeneficentecentroespiritafeesperancacaridadejavafx.controller;

import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.dao.PacienteDao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Endereco;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Limitacao;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.Paciente;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.EnderecoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.LimitacaoDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.model.dtos.PacienteDto;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.MascaraCPF;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.MascaraCelular;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.MascaraCep;
import com.projetobeneficentecentroespiritafeesperancacaridadejavafx.util.ValidaInput;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroPacienteController implements Initializable {

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

    @FXML
    public void add(javafx.scene.input.MouseEvent mouseEvent) {
        try {


            EnderecoDto enderecoDto = new EnderecoDto();

            String cep = tfCep.getText().replace("-", "");
            enderecoDto.setCep(cep);


            enderecoDto.setLogradouroEndereco(tfEndereco.getText());
            enderecoDto.setCidade(tfCidade.getText());
            enderecoDto.setUf(cbUfRg.getValue().toString());
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

            PacienteDao.adicionaPacienteComEndereco(paciente, endereco);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar Paciente");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbUfEndereco.setItems(FXCollections.observableArrayList(ESTADOS_BRASILEIROS));
        cbUfRg.setItems(FXCollections.observableArrayList(ESTADOS_BRASILEIROS));
        cbRaca.setItems(FXCollections.observableArrayList(RACA_COR_IBGE));

        MascaraCep.aplicaMascaraCpf(tfCep);
        MascaraCPF.applyCpfMask(tfCpf);
        MascaraCelular.applyPhoneMask(tfTelefone);
        MascaraCelular.applyPhoneMask(tfTelefoneEmergencia);
        ValidaInput.somenteNumeros(tfNumero);


        hBoxDeficiencia.setVisible(false);
        hBoxDeficiencia.setManaged(false);
        hBoxDeficienciaOutros.setVisible(false);
        hBoxDeficienciaOutros.setManaged(false);

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
