## **Requisitos Funcionais**
| **ID** | **Nome da Regra**                                             | **Descrição**                                                                 | **Tipo**        | **Área de Aplicação**       | **Condições**                                                            | **Entrada**       | **Saída**                       | **Responsável**        |  **Status Implementação** |
|--------|---------------------------------------------------------------|-------------------------------------------------------------------------------|-----------------|-----------------------------|--------------------------------------------------------------------------|-------------------|---------------------------------|------------------------|---------------------------|
| RF1    | Validação de CPF                                              | O CPF informado deve ser válido e único no sistema.                           |    Restrição    | Cadastro de Paciente        | O CPF deve conter 11 dígitos e passar na validação de cálculo do dígito. | CPF do usuário    | Registro válido ou erro         | Analista de Requisitos | Não Implementado          |
| RF2    | Permissão de acesso (Usuário Admin.)                          | O usuário Admin. tem acesso a todo sistema.                                   |   Condicional   |     Acesso ao Sistema       | Ao acessar o Sistema o usuário tem acesso a todo ele.                    | Login e Senha     | Registro válido ou erro         | Analista de Requisitos | Não Implementado          |
| RF3    | Validação de Endereço                                         | O Cep informado deve ser válido dentro do sistema.                            |    Restrição    | Cadastro de Paciente        | O Cep deve conter 8 digitos e ser válido                                 | CEP do endereço   | Registro válido ou erro         | Analista de Requisitos | Não implementado          |
| RF4    | A triagem é feita junto ao preenchimento da ficha do paciente | Utilizar o Manchester Triage System (Emergência, Muito Urgente, Urgente, Pouco urgente, Não Urgente) |  Condicional | Cadastrp de Paciente | Avaliação da Gravidade clinica do paciente | Seleção baseada em Manchester Triage System | Organização automática dos pacientes para atendimento| Analista de Requisitos  | Não Implementado |
| RF5    | O sistema deve realizar Backup dos dados de maneira automática| Deve-se realizar o Backup dos Dados, abstraindo do usuário.                   |   Procedural    | Banco de Dados              | Definir Backup Automático                                                | Dados a serem salvos | Mensagem de sucesso ou erro | Analista de Requisitos  | Não implementado          |
| RF6    | Não disponibilizar a atualização de dados do Prontuário ápos a 0h do dia da consulta | Nâo permitir a alteração do documento por motivos legais|   Restrição    |   Prontuário do Paciente    | Alteração permitida somente por x tempo                                  |Dados do Prontuário|       Integridade dos Dados     | Analista de Requisitos | Não implementado          |                                          


## **Requisitos Não Funcionais**
| **ID** | **Nome da Regra**                               | **Descrição**                                                                 | **Tipo**        | **Área de Aplicação**       | **Condições**                                                            | **Entrada**       | **Saída**                       | **Responsável**        |  **Status Implementação** |
|--------|-------------------------------------------------|-------------------------------------------------------------------------------|-----------------|-----------------------------|--------------------------------------------------------------------------|-------------------|---------------------------------|------------------------|---------------------------|
| RNF1   | Lei do Prontuário Eletrônico (Lei 13.787)       | Respeitar aspectos legais em torno do sigilo médico (assinatura eletrônica)   | Regulamentar       | Dados Paciente / Prontuário | Dados do paciente devem ser acessados somente por pessoa autorizada      | Dados cadastrais, prontuário | Visualização e menuseio somente por pessoa altorizada | Analista de Requisitos | Não Implementado |
| RNF2   | Sistema deve ser Intuitivo                      | O sistema deve ser intuitivo, fácil de usar e alto explicativo tantos para usuários do sistema quanto para pacientes |  Heurística  |   Melhorar experiência dos usuários do sistema e pacientes         |    Melhor UX possível | Todo ciclo de vida da UX | - | Analista de Requisitos | Não Implementada |



### **Tipos de Regra de Negócio**
1. **Restrição**<br>
Definição: Regras que limitam ou restringem ações ou entradas no sistema. São condições obrigatórias que devem ser atendidas.


2. **Derivada**<br>
Definição: Regras que geram novos valores ou informações a partir de dados existentes, geralmente por cálculos ou inferências.

3. **Condicional**<br>
Definição: Regras que determinam o que deve acontecer com base em condições específicas.

4. **Procedural**<br>
Definição: Regras que definem etapas ou ações a serem seguidas em processos específicos. Costumam detalhar o "como" algo deve ser feito.

5. **Regulamentar**<br>
Definição: Regras impostas por leis, normas ou regulamentações externas que a organização deve cumprir.

6. **Heurística**<br>
Definição: Regras baseadas em boas práticas, experiência ou aproximações, em vez de regras estritamente definidas.