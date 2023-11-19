<h5 align="center"> <img src = "https://github.com/Time-1-ADS/ProjetoGSW/blob/sprints/Imagens%20Geral/Fatec_logo.png" width="20" height="20" /> Linguagem de programação II / Projeto leilões eletrônicos </h5>

# Alunos
### Danilo Verginio da Silva
### Antonio Roberto de Almeida Zago

## :clipboard: Forma de utilizar:
* Clonar ou baixar o repositório do projeto;
* No postman importar o arquivo  _"Leilão eletronico.postman_collection.json"_  que está disponível na raiz do projeto;
* Importar o projeto pelo Maven na IDE de preferência (Eclipse, Visual Studio Code, etc...)
* Rodar o projeto em  LeilaoEletronicoLp2Application que se encontra no package com.fatec.leilaoEletronicoLp2;
* Com o projeto ativo é possivel realizar testes, utilizando o postman enviando requisições (Post,Put, Get,Delete). 
* O banco de dados é h2 ou seja aas informações só ficaram diponivel durante o uso da solução.
* Após iniciar  o projeto a documentação das APIs está disponivel em :http://localhost:8080/swagger-ui/index.html
* **OBSERVAÇÃO:** Os tipos de dispositivos de informática e tipos de veiculos são as especificadas nos requisitos

## :clipboard: Passo a passo cadastros:
**1.** Ao iniciar o projeto os tipos de dispositivos de informátca e tipos de veículos seram inseridos automaticamente

  ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/327d83df-0d6f-4fa6-9d57-d100da31ed89)

**2.** Cadastrar as entidades financeiras que serão utilizadas nos cadastros dos leilões

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/5fb4641a-67e7-473e-8001-8e05b6576d06)

**3.** Cadastrar os leilões informando uma data futura para a data de ocorrência e um id de entidade financeira existente

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/053e0080-45ee-49ee-8500-e60c53c9905b)

   **Resposta:**
   
   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/3cdd11fd-fa20-4f1a-8b30-cba14db5afb4)

**4.** Cadastrar os usuários que vão interagir com o sistema dando lances em veiculos e dispositivos de informática

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/1ba0d33f-2154-4fa7-9f89-9727378518ac)

   **Resposta:**

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/afbb3e35-aed4-49e3-9b07-0517231a941d)

**5.** Cadastrar os veículos que vão estar disponiveis nos leilões, informando um leilão preexistente e com data futura e um id de tipo de veiculo válido (1-Carros, 2-Motos, 3-Caminhões,4-Utilitários ).

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/b6a77f31-5767-4410-896d-8c3f8b0607b2)

   **Resposta:**

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/e248475f-e564-4210-a488-d7aefd6c37fb)

**6.** Cadastrar os dispositivos de informática que vão estar disponiveis nos leilões, informando um leilão preexistente e com data futura e um id de tipo de dispositivo de informática válido (1-Notebooks, 2-Monitores, 3-Hubs, 4-Switches, 5-Roteadores ).

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/7d51488c-cec8-4bed-b3dd-284ef9aa4904)

   **Resposta:**

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/7a66c3e5-e549-4b01-95e7-80356973aa14)

**7.** Cadastrar os lances dos usuários nos veiculos preexistentes no sistema, informando um id de veiculo válido e um cpf de cliente válido

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/602952e5-5499-45fb-a8c0-5f4749048fe5)

   **Resposta:**

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/8aae4469-ad0f-40ed-ae93-b00e95d9f65c)


**8.** Cadastrar os lances dos usuários nos dispositivos de informática preexistentes no sistema, informando um id de dispositivo de informática válido e um cpf de cliente válido
 
   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/d9579c31-7ee6-41e9-a728-17ee2ad34d7e)

   **Resposta:**

   ![image](https://github.com/Antonio-Zago/leilaoEletronicoLp2/assets/80283126/1048abd1-b0cf-441f-8eb9-d866374de1b5)


## :Funcionalidades da Operação do Sistema de Leilão Eletrônico:

**1.** Listagem dos leilões registrados no sistema, ordenados por data de ocorrência;

**Resposta:**

**2.**  Detalhamento de um leilão específico, apresentando seu detalhes (lista de produtos
ordenado por nome, entidade financeira associada, dados do leilão, quantidade total de
produtos e demais dados pertinentes ao domínio);

**Resposta:**

**3.** Detalhamento de um produto associado ao leilão, apresentando todos os dados
pertinentes ao mesmo;

**Resposta:**


**4.** Filtro de busca de produtos em um leilão por:
a. Faixa de valores do lance inicial (min < R$ < max), sendo os valores mínimos e
máximos informados pelo usuário;
b. Faixa de valores considerando o lance inicial + lances adicionais (min < R$ < max),
sendo os valores mínimos e máximos informados pelo usuário;
c. Palavra chave contida no nome do produto; e
d. Tipo de produto.

**Resposta:**


**5.** Possibilitar a um cliente previamente cadastrado no sistema dar um lance de valor (R$)
para um produto específico – As devidas validações deverão ser mapeadas e
implementadas pelos membros do grupo em relação à regras de consistência dos lances
registrados;

**Resposta:**


**6.** Apresentação do histórico de lances realizado para um produto específico, destacando o
produto, cliente e valor do lance – Ordenação pelo ID do lance correspondente;

**Resposta:**


**7.** Sistema deverá automaticamente analisar a faixa de horário do leilão (início e fim), caso
o mesmo esteja ocorrendo no momento correspondente. Uma vez ultrapassado o
horário de finalização, ao consultar o detalhamento do leilão, o sistema deverá
apresentar a relação de produtos acompanhado de seus respectivos clientes
(ganhadores do leilão, caso o status seja FINALIZADO, senão não deverá apresentar o
cliente), valor do lance vencedor (R$) e o status de atua do leilão;

**Resposta:**


**8.** Todo leilão deverá ter atrelado ao mesmo três status chaves:
a. EM ABERTO - Para leilões registrados, porém ainda não iniciados;
b. EM ANDAMENTO - Para leilões registrados, cuja data e faixa de horário do leilão
estiverem ocorrendo no exato momento de operação do sistema; e
c. FINALIZADO – Para leilões cujo horário atual ultrapassou os limites da faixa de
horário registrada para ocorrência do leilão.
d. Observação: A gestão e tratamento dos status do leilão deverá ser executada
automaticamente pelo sistema, ou seja, não haverá funcionalidade para indicar
que o leilão foi registrado, iniciou-se ou foi finalizado. Isso deve ser processado
com base no horário atual e horários e início e fim do leilão.

**Resposta:**

**9.** O sistema deverá prover também uma funcionalidade de exportação dos detalhes do
leilão para um arquivo com extensão .DET contendo todas as informações do leilão,
seus produtos, clientes participantes do leilão, entidade financeira associada e histórico
de lances de cada produto (estrutura interna do arquivo será JSON).

**Resposta:**   



   






## :pencil2: Diagrama entidade relacionamento

<img src="https://github.com/Antonio-Zago/leilaoEletronicoLp2/blob/main/Leil%C3%A3o_Eletr%C3%B4nico_Physical_Export-2023-08-26_10-14.png">
          
