USE `dbcentroespirita`;

-- Inserções para a tabela Limitacao
INSERT INTO `Limitacao` (`id_limitacao`, `eh_cognitiva`, `eh_locomocao`, `eh_visao`, `eh_audicao`, `outro_descricao`)
VALUES
(1, 1, 0, 0, 0, 'Dificuldade de aprendizado'),
(2, 0, 1, 0, 0, 'Uso de muletas'),
(3, 0, 0, 1, 0, 'Baixa visão'),
(4, 0, 0, 0, 1, 'Surdez parcial'),
(5, 1, 1, 0, 0, 'Deficiência cognitiva e locomotora');

-- Inserções para a tabela Endereco
INSERT INTO `Endereco` (`id_endereco`, `cep`, `logradouroEndereco`, `cidade`, `uf`, `bairro`, `complemento`, `numero`)
VALUES
(1, '12345678', 'Rua das Flores', 'São Paulo', 'SP', 'Centro', 'Apto 101', '10'),
(2, '87654321', 'Avenida Brasil', 'Rio de Janeiro', 'RJ', 'Copacabana', 'Bloco A', '200'),
(3, '11223344', 'Rua Amazonas', 'Belo Horizonte', 'MG', 'Savassi', 'Casa', '55'),
(4, '55667788', 'Avenida Paulista', 'São Paulo', 'SP', 'Bela Vista', NULL, '1500'),
(5, '99887766', 'Rua Paraná', 'Curitiba', 'PR', 'Centro Cívico', 'Sala 5', '30');

-- Inserções para a tabela Prontuario
INSERT INTO `Prontuario` (`id_prontuario`, `data_abertura`)
VALUES
(1, '2024-01-15 10:30:00'),
(2, '2024-02-10 14:00:00'),
(3, '2024-03-05 09:15:00'),
(4, '2024-04-20 11:45:00'),
(5, '2024-05-18 08:00:00');

-- Inserções para a tabela Paciente
INSERT INTO `Paciente` (`id_paciente`, `cpfPaciente`, `rg_paciente`, `nome_completo_paciente`, `data_nascimento_paciente`, `sexo_biologico_paciente`, `estado_civil`, `genero_paciente`, `email_paciente`, `escolaridade_paciente`, `ocupacao_paciente`, `fk_limitacao`, `fk_endereco`, `naturalidade`, `nacionalidade`, `cor_raca`, `cartao_nascional_saude`, `fk_prontuario`)
VALUES
(1, '12345678901', 'MG123456', 'João Silva', '1980-05-15 00:00:00', 'M', 'Casado', 'Masculino', 'joao.silva@gmail.com', 'Ensino Médio Completo', 'Operador de Máquinas', 1, 1, 'São Paulo', 'Brasileiro', 'Branco', '123456789012345', 1),
(2, '23456789012', 'RJ987654', 'Maria Oliveira', '1990-07-20 00:00:00', 'F', 'Solteira', 'Feminino', 'maria.oliveira@gmail.com', 'Ensino Superior Incompleto', 'Estudante', 2, 2, 'Rio de Janeiro', 'Brasileira', 'Parda', '234567890123456', 2),
(3, '34567890123', 'MG567890', 'Carlos Santos', '1975-03-10 00:00:00', 'M', 'Divorciado', 'Masculino', 'carlos.santos@gmail.com', 'Ensino Técnico Completo', 'Técnico Eletrônico', NULL, 3, 'Belo Horizonte', 'Brasileiro', 'Negro', '345678901234567', 3),
(4, '45678901234', 'SP678901', 'Ana Costa', '2000-11-25 00:00:00', 'F', 'Solteira', 'Feminino', 'ana.costa@gmail.com', 'Ensino Superior Completo', 'Engenheira', NULL, 4, 'São Paulo', 'Brasileira', 'Branca', '456789012345678', 4),
(5, '56789012345', 'PR345678', 'Pedro Lima', '1985-06-30 00:00:00', 'M', 'Casado', 'Masculino', 'pedro.lima@gmail.com', 'Ensino Médio Incompleto', 'Motorista', 5, 5, 'Curitiba', 'Brasileiro', 'Amarelo', '567890123456789', 5);

-- Inserções para a tabela TelefoneContatoEmergencia
INSERT INTO `TelefoneContatoEmergencia` (`id_telefone_contato_emergencia`, `nome_contato_emergencia`, `telefone_contato_emergencia`)
VALUES
(1, 'Carlos Souza', '(11) 91234-5678'),
(2, 'Luciana Alves', '(21) 98765-4321'),
(3, 'Roberto Gomes', '(31) 99876-5432'),
(4, 'Fernanda Ribeiro', '(41) 98712-3456'),
(5, 'Patrícia Mendes', '(19) 99321-8765');

-- Inserções para a tabela Usuario
INSERT INTO `Usuario` (`id_usuario`, `login`, `senha`, `tipo_acesso`)
VALUES
(1, 'admin', 'admin123', 'MED'),
(2, 'user1', 'user123', 'MED'),
(3, 'user2', 'user456', 'MED'),
(4, 'psico1', 'psico123', 'MED'),
(5, 'medico1', 'medico123', 'MED');

-- Inserções para a tabela Medico
INSERT INTO `dbcentroespirita`.`Medico` (`id_medico`, `nome_medico`, `cpf_medico`, `data_nascimento_medico`, `sexo`, `fk_endereco`, `telefone_medico`, `email_medico`, `crm`, `uf_registro_crm`, `especialidade_medico`, `fk_usuario`, `rg_medico`, `uf_rg_medico`)
VALUES
(1, 'Dr. Carlos Silva', '12345678901', '1980-03-15 00:00:00', 'M', 1, '(31) 99876-5432', 'carlos.silva@clinic.com', '12345', 'MG', 'Cardiologia', 1, 'MG1234567', 'MG'),
(2, 'Dra. Ana Maria', '98765432100', '1985-07-20 00:00:00', 'F', 2, '(31) 98888-7777', 'ana.maria@clinic.com', '54321', 'SP', 'Pediatria', 2, 'SP8765432', 'SP'),
(3, 'Dr. João Oliveira', '19283746500', '1990-05-25 00:00:00', 'M', 3, '(31) 97777-8888', 'joao.oliveira@clinic.com', '67890', 'RJ', 'Ortopedia', 3, 'RJ9876543', 'RJ'),
(4, 'Dra. Beatriz Costa', '10293847560', '1982-12-30 00:00:00', 'F', 4, '(31) 96666-9999', 'beatriz.costa@clinic.com', '98765', 'RS', 'Dermatologia', 4, 'RS5432109', 'RS'),
(5, 'Dr. Fernando Almeida', '56473829100', '1975-01-10 00:00:00', 'M', 5, '(31) 95555-4444', 'fernando.almeida@clinic.com', '11223', 'ES', 'Neurologia', 5, 'ES7654321', 'ES');

-- Inserções para a tabela Endereco
INSERT INTO `Endereco` (`id_endereco`, `cep`, `logradouroEndereco`, `cidade`, `uf`, `bairro`, `complemento`, `numero`) 
VALUES 
(6, '12345001', 'Rua A', 'Cidade A', 'SP', 'Bairro A', 'Casa 10', '100'),
(7, '12345002', 'Rua B', 'Cidade B', 'RJ', 'Bairro B', 'Apartamento 202', '200'),
(8, '12345003', 'Rua C', 'Cidade C', 'MG', 'Bairro C', 'Sobrado 303', '300'),
(9, '12345004', 'Rua D', 'Cidade D', 'BA', 'Bairro D', 'Casa 404', '400'),
(10, '12345005', 'Rua E', 'Cidade E', 'ES', 'Bairro E', 'Apartamento 505', '500');

INSERT INTO `Usuario` (`id_usuario`, `login`, `senha`, `tipo_acesso`)
VALUES
(6, 'admin2', 'admin456', 'PSI'),
(7, 'user3', 'user789', 'PSI'),
(8, 'user4', 'user101', 'PSI'),
(9, 'psico2', 'psico456', 'PSI'),
(10, 'medico2', 'medico456', 'PSI');



-- Inserções para a tabela Psicologo
INSERT INTO `dbcentroespirita`.`Psicologo` (`id_psicologo`, `nome_psicologo`, `data_nascimento_profissional`, `sexo_psicologo`, `fk_endereco`, `telefone_psicologo`, `email`, `crp`, `uf_registro_crp`, `especialidade`, `fk_usuario`, `rg_psicologo`, `ur_rg`, `tipo_atendimento`)
VALUES
(1, 'Psic. Marcos Pereira', '1988-04-10 00:00:00', 'M', 6, '(31) 94444-3333', 'marcos.pereira@clinic.com', '45678', 'MG', 'Terapia Cognitiva', 6, 'MG6789012', 'MG', 'Individual'),
(2, 'Psic. Clara Souza', '1992-09-18 00:00:00', 'F', 7, '(31) 93333-2222', 'clara.souza@clinic.com', '98761', 'SP', 'Psicologia Infantil', 7, 'SP7890123', 'SP', 'Familiar'),
(3, 'Psic. Roberto Lima', '1980-11-22 00:00:00', 'M', 8, '(31) 92222-1111', 'roberto.lima@clinic.com', '12398', 'RJ', 'Psicoterapia', 8, 'RJ8901234', 'RJ', 'Grupo'),
(4, 'Psic. Juliana Martins', '1985-06-05 00:00:00', 'F', 9, '(31) 91111-0000', 'juliana.martins@clinic.com', '34987', 'RS', 'Terapia de Casal', 9, 'RS9012345', 'RS', 'Casal'),
(5, 'Psic. Thiago Santos', '1995-08-12 00:00:00', 'M', 10, '(31) 90000-5555', 'thiago.santos@clinic.com', '76432', 'ES', 'Psicologia Comportamental', 10, 'ES0123456', 'ES', 'Individual');

-- Inserções para a tabela AnamneseAtendimentoPsicologico
INSERT INTO `dbcentroespirita`.`AnamneseAtendimentoPsicologico` 
(`id_anamnese_psicologico`, `motivo_consulta_descricao`, `tempo_sintomas`, `fatores_agravantes`, `medicamentos_uso`) 
VALUES 
(1, 'Ansiedade Generalizada', '6 meses', 'Estresse no trabalho', 'Fluoxetina'),
(2, 'Depressão Moderada', '2 anos', 'Perda de um familiar', 'Sertralina'),
(3, 'Transtorno Obsessivo Compulsivo', '1 ano', 'Preocupações constantes', 'Paroxetina'),
(4, 'Síndrome do Pânico', '3 meses', 'Exposição a situações de pressão', 'Escitalopram'),
(5, 'Estresse pós-traumático', '4 anos', 'Acidente de carro', 'Venlafaxina');

-- Inserções para a tabela AnamneseAtendimentoClinico
INSERT INTO `dbcentroespirita`.`AnamneseAtendimendoClinico` 
(`id_anamnese_clinico`, `motivo_consulta_descricao`, `data_inicio`, `sintomas_assossiados`, `tratamento_anteriores`, `uso_medicamento`) 
VALUES 
(1, 'Dor abdominal', '2024-12-01 09:00:00', 'Náusea, febre', 'Antibióticos para infecção', 'Omeprazol'),
(2, 'Hipertensão', '2024-12-02 10:00:00', 'Dor de cabeça, tontura', 'Monitoramento de pressão', 'Losartana'),
(3, 'Asma', '2024-12-03 11:30:00', 'Falta de ar, tosse', 'Uso de inaladores', 'Salbutamol'),
(4, 'Diabetes Tipo 2', '2024-12-04 14:00:00', 'Fadiga, sede excessiva', 'Controle glicêmico', 'Metformina'),
(5, 'Artrite reumatoide', '2024-12-05 15:30:00', 'Dor nas articulações', 'Fisioterapia', 'Methotrexato');

-- Inserções para a tabela Atendimento
INSERT INTO `dbcentroespirita`.`Atendimento` 
(`id_atendimento`, `fk_prontuario`, `tipo_atendimento`, `prioridade`, `status_atendimento`, `tratamento`, `diagnostico`, `observacao`) 
VALUES
(1, 1, 0, 'Emergência', 'Concluído', 'Sutura na mão direita', 'Laceração por objeto cortante', 'Paciente atendido no mesmo dia'),
(2, 2, 1, 'Muito urgente', 'Em Aguardo', 'Nebulização com broncodilatador', 'Crise asmática', 'Paciente com histórico de asma'),
(3, 3, 0, 'Urgente', 'Pendente', 'Analgésicos e anti-inflamatórios', 'Cefaleia tensional', 'Relatou dores frequentes na região frontal'),
(4, 4, 1, 'Pouco urgente', 'Cancelado', NULL, NULL, 'Paciente desmarcou o atendimento'),
(5, 5, 0, 'Não Urgente', 'Concluído', 'Ajuste de medicação', 'Hipertensão controlada', 'Consulta de rotina realizada'),
(6, 1, 1, 'Emergência', 'Não Compareceu', NULL, NULL, 'Paciente faltou sem aviso prévio'),
(7, 2, 0, 'Muito urgente', 'Concluído', 'Troca de curativo', 'Ferida superficial cicatrizando', 'Paciente respondeu bem ao tratamento'),
(8, 3, 1, 'Urgente', 'Reaberto', 'Exames laboratoriais solicitados', 'Suspeita de anemia', 'Aguardando resultados dos exames'),
(9, 4, 0, 'Pouco urgente', 'Concluído', 'Consulta psicológica', 'Ansiedade leve', 'Encaminhado para acompanhamento mensal'),
(10, 5, 1, 'Não Urgente', 'Concluído', 'Revisão clínica sem intervenções', 'Saúde geral estável', 'Paciente sem queixas no momento');


