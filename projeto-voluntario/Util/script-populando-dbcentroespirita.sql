USE `dbcentroespirita`;

-- Inserções para a tabela Limitacao
INSERT INTO `Limitacao` (`id_limitacao`, `eh_cognitiva`, `eh_locomocao`, `eh_visao`, `eh_audicao`, `outro_descricao`)
VALUES
(1, 1, 0, 0, 0, 'Dificuldade de aprendizado'),
(2, 0, 1, 0, 0, 'Uso de muletas'),
(3, 0, 0, 1, 0, 'Baixa visão'),
(4, 0, 0, 0, 1, 'Surdez parcial'),
(5, 1, 1, 0, 0, 'Deficiência cognitiva e locomotora');

-- Inserindo dados na tabela Endereco
INSERT INTO `dbcentroespirita`.`Endereco` (`cep`, `logradouro_endereco`, `cidade`, `uf`, `bairro`, `complemento`, `numero`)
VALUES 
('30130001', 'Rua da Bahia', 'Belo Horizonte', 'MG', 'Centro', NULL, '101'),
('30140000', 'Avenida Afonso Pena', 'Belo Horizonte', 'MG', 'Centro', NULL, '2000'),
('04547006', 'Rua Joaquim Floriano', 'São Paulo', 'SP', 'Itaim Bibi', 'Apto 12', '321'),
('01014000', 'Rua Direita', 'São Paulo', 'SP', 'Sé', NULL, '15'),
('88010001', 'Rua Felipe Schmidt', 'Florianópolis', 'SC', 'Centro', NULL, '50'),
('30120060', 'Avenida Amazonas', 'Belo Horizonte', 'MG', 'Prado', 'Sala 501', '220'),
('40010000', 'Praça da Sé', 'Salvador', 'BA', 'Sé', NULL, '1'),
('60165082', 'Avenida Santos Dumont', 'Fortaleza', 'CE', 'Centro', NULL, '567'),
('78048000', 'Rua 24 de Outubro', 'Cuiabá', 'MT', 'Centro', NULL, '300'),
('64001400', 'Rua Coelho de Resende', 'Teresina', 'PI', 'Centro', 'Casa 5', '150');




-- Inserindo dados na tabela Paciente
INSERT INTO `dbcentroespirita`.`Paciente` 
(`cpf_paciente`, `rg_paciente`, `nome_completo_paciente`, `data_nascimento_paciente`, `sexo_biologico_paciente`, 
 `estado_civil`, `genero_paciente`, `email_paciente`, `escolaridade_paciente`, `ocupacao_paciente`, `fk_limitacao`, 
 `fk_endereco`, `naturalidade`, `nacionalidade`, `cor_raca`, `cartao_nascional_saude`)
VALUES 
('12345678901', 'MG123456', 'João Silva', '1980-05-15', 'M', 'Casado', 'Masculino', 'joao.silva@gmail.com', 
 'Ensino Médio Completo', 'Engenheiro', NULL, 1, 'Belo Horizonte', 'Brasileira', 'Branca', '123456789001'),
('98765432100', 'MG987654', 'Maria Oliveira', '1990-08-20', 'F', 'Solteira', 'Feminino', 'maria.oliveira@hotmail.com', 
 'Superior Completo', 'Professora', NULL, 2, 'Belo Horizonte', 'Brasileira', 'Parda', '123456789002'),
('45678912302', 'SP123456', 'Pedro Santos', '1975-11-10', 'M', 'Divorciado', 'Masculino', 'pedro.santos@yahoo.com', 
 'Ensino Médio Completo', 'Comerciante', NULL, 3, 'São Paulo', 'Brasileira', 'Negra', '123456789003'),
('32165498701', 'SP654321', 'Ana Paula Lima', '1985-03-25', 'F', 'Viúva', 'Feminino', 'ana.paula@gmail.com', 
 'Ensino Médio Completo', 'Cabeleireira', NULL, 4, 'São Paulo', 'Brasileira', 'Indígena', '123456789004'),
('78912345600', 'SC789123', 'Carlos Alberto', '1995-06-12', 'M', 'Solteiro', 'Masculino', 'carlos.alberto@gmail.com', 
 'Superior Completo', 'Advogado', NULL, 5, 'Florianópolis', 'Brasileira', 'Branca', '123456789005'),
('12378945600', 'MG321987', 'Luiza Ferreira', '1992-09-18', 'F', 'Casada', 'Feminino', 'luiza.ferreira@outlook.com', 
 'Ensino Superior', 'Nutricionista', NULL, 6, 'Belo Horizonte', 'Brasileira', 'Parda', '123456789006'),
('65498732101', 'BA456123', 'José Rodrigues', '1960-02-28', 'M', 'Viúvo', 'Masculino', 'jose.rodrigues@gmail.com', 
 'Ensino Fundamental Completo', 'Aposentado', NULL, 7, 'Salvador', 'Brasileira', 'Negra', '123456789007'),
('45612378902', 'CE789654', 'Rita de Cássia', '1978-12-05', 'F', 'Separada', 'Feminino', 'rita.cassia@yahoo.com', 
 'Ensino Médio Completo', 'Funcionária Pública', NULL, 8, 'Fortaleza', 'Brasileira', 'Branca', '123456789008'),
('78965412303', 'MT321456', 'Marcelo Cardoso', '1983-04-15', 'M', 'Casado', 'Masculino', 'marcelo.cardoso@hotmail.com', 
 'Ensino Técnico', 'Técnico em TI', NULL, 9, 'Cuiabá', 'Brasileira', 'Parda', '123456789009'),
('32145678904', 'PI654987', 'Patrícia Nunes', '1997-07-30', 'F', 'Solteira', 'Feminino', 'patricia.nunes@gmail.com', 
 'Ensino Médio Completo', 'Estudante', NULL, 10, 'Teresina', 'Brasileira', 'Indígena', '123456789010');

-- Inserções para a tabela Prontuario
INSERT INTO `Prontuario` (`id_prontuario`, `data_abertura`,`fk_paciente`)
VALUES
(1, '2024-01-15 10:30:00',1),
(2, '2024-02-10 14:00:00',2),
(3, '2024-03-05 09:15:00',3),
(4, '2024-04-20 11:45:00',4),
(5, '2024-05-18 08:00:00',5);

INSERT INTO `dbcentroespirita`.`TelefoneContatoEmergencia` 
(`nome_contato_emergencia`, `telefone_contato_emergencia`, `fk_paciente_contato`)
VALUES 
('Carlos Silva', '31987654321', 1),
('Fernanda Lima', '31976543210', 2),
('Lucas Rocha', '11987654321', 3),
('Juliana Souza', '11976543210', 4),
('Mariana Alves', '48987654321', 5),
('Paulo Freitas', '31985473210', 6),
('Tatiana Barros', '71987654321', 7),
('Cláudio Ramos', '85976543210', 8),
('Renata Oliveira', '65987654321', 9),
('Isabela Fonseca', '86976543210', 10);
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


INSERT INTO `Usuario` (`id_usuario`, `login`, `senha`, `tipo_acesso`)
VALUES
(6, 'admin2', 'admin456', 'PSI'),
(7, 'user3', 'user789', 'PSI'),
(8, 'user4', 'user101', 'PSI'),
(9, 'psico2', 'psico456', 'PSI'),
(10, 'medico2', 'medico456', 'PSI');



-- Inserções para a tabela Psicologo
INSERT INTO `dbcentroespirita`.`Psicologo` (`id_psicologo`, `nome_psicologo`, `data_nascimento_profissional`, `sexo_psicologo`, `fk_endereco`, `telefone_psicologo`, `email`, `crp`, `uf_registro_crp`, `especialidade`, `fk_usuario`, `rg_psicologo`, `ur_rg`)
VALUES
(1, 'Psic. Marcos Pereira', '1988-04-10 00:00:00', 'M', 6, '(31) 94444-3333', 'marcos.pereira@clinic.com', '45678', 'MG', 'Terapia Cognitiva', 6, 'MG6789012', 'MG'),
(2, 'Psic. Clara Souza', '1992-09-18 00:00:00', 'F', 7, '(31) 93333-2222', 'clara.souza@clinic.com', '98761', 'SP', 'Psicologia Infantil', 7, 'SP7890123', 'SP'),
(3, 'Psic. Roberto Lima', '1980-11-22 00:00:00', 'M', 8, '(31) 92222-1111', 'roberto.lima@clinic.com', '12398', 'RJ', 'Psicoterapia', 8, 'RJ8901234', 'RJ'),
(4, 'Psic. Juliana Martins', '1985-06-05 00:00:00', 'F', 9, '(31) 91111-0000', 'juliana.martins@clinic.com', '34987', 'RS', 'Terapia de Casal', 9, 'RS9012345', 'RS'),
(5, 'Psic. Thiago Santos', '1995-08-12 00:00:00', 'M', 10, '(31) 90000-5555', 'thiago.santos@clinic.com', '76432', 'ES', 'Psicologia Comportamental', 10, 'ES0123456', 'ES');










