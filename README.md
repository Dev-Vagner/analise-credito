# Aplicação de Análise de Crédito
Este repositório reúne os componentes da aplicação de análise de crédito, desenvolvida para simular a avaliação de crédito dos usuários e informar se a proposta foi aprovada ou não. 

A aplicação foi estruturada com uma arquitetura de microsserviços, composta por três serviços principais: proposta, análise de crédito e notificação. Para a comunicação entre os serviços, foi implementada mensageria assíncrona utilizando RabbitMQ, além de mecanismos de resiliência, como filas mortas (DLQs), garantindo que os serviços possam operar de forma independente, mesmo em caso de falhas nos outros serviços.

## Ferramentas utilizadas
  - **Java 17 / Spring Boot**: Para o desenvolvimento da aplicação;
  - **RabbitMQ**: Para a implementação da comunicação assíncrona entre os serviços;
  - **PostgreSQL**: Banco de dados relacional para o armazenamento de dados;
  - **Spring Data JPA**: Para a comunicação com o banco de dados;
  - **Java Mail Sender**: Para o envio de email;
  - **Docker / Docker Compose**: Para containerização e gerenciamento de ambientes.

## Funcionalidades
  - `POST /proposta`: Cadastra uma nova proposta;
    - Exemplo de request
      ```bash
      {
          "nome": "Romeu",
          "sobrenome": "Cruz",
          "email": "romeu.cruz@hotmail.com",
          "telefone": "11 94321 4325",
          "cpf": "83798515724",
          "renda": 44044.43,
          "valorSolicitado": 20420.35,
          "prazoPagamento": 15
      }
        ```
    - Exemplo de response
      ```bash
      {
          "id": 1,
          "nome": "Romeu",
          "sobrenome": "Cruz",
          "email": "romeu.cruz@hotmail.com",
          "telefone": "11 94321 4325",
          "cpf": "83798515724",
          "renda": 44044.43,
          "valorSolicitadoFmt": "¤20,420.35",
          "prazoPagamento": 15,
          "aprovada": null,
          "observacao": null
      }
        ```
  - `GET /proposta`: Mostra todas as propostas cadastradas;
    - Exemplo de response
      ```bash
      [
          {
              "id": 1,
              "nome": "Romeu",
              "sobrenome": "Cruz",
              "email": "romeu.cruz@hotmail.com",
              "telefone": "11 94321 4325",
              "cpf": "83798515724",
              "renda": 44044.43,
              "valorSolicitadoFmt": "¤20,420.35",
              "prazoPagamento": 15,
              "aprovada": true,
              "observacao": null
          },
          {
              "id": 2,
              "nome": "Mauro",
              "sobrenome": "Parker",
              "email": "maurop@gmail.com",
              "telefone": "81 93425 4321",
              "cpf": "79680319346",
              "renda": 2857.93,
              "valorSolicitadoFmt": "¤14,209.67",
              "prazoPagamento": 23,
              "aprovada": false,
              "observacao": "Operação não permitida. Cliente Mauro com nome negativado"
          },
          {
              "id": 3,
              "nome": "Ivan",
              "sobrenome": "Finley",
              "email": "ivanfin@outlook.com",
              "telefone": "55 91234 5431",
              "cpf": "82218472980",
              "renda": 12791.39,
              "valorSolicitadoFmt": "¤92,975.79",
              "prazoPagamento": 12,
              "aprovada": true,
              "observacao": null
          }
      ]
        ```

## Configuração e Execução
  - ### Dependências:
    - Docker / Docker Compose
  - ### Passo-a-passo:
    1. Clone o repositório:
        ```bash
        git clone https://github.com/Dev-Vagner/analise-credito.git
        ```
    2. Navegue até o diretório do projeto:
        ```bash
        cd analise-credito
        ```
    3. Insira todas as variáveis de ambiente do arquivo .env:
       - Caso tenha dúvidas em como conseguir criar uma senha de aplicativo para o seu gmail, siga esse tutorial: https://support.google.com/accounts/answer/185833?hl=pt-BR
    4. No diretório raiz do projeto, execute o comando:
      ```bash
        docker-compose up -d
      ```
    5. Acesse os dados da aplicação:
       - Acesse a API em: `http://localhost:8080`
       - Acesse a interface gráfica do RabbitMQ em: `http://localhost:15672`
         - Dados de login (default):
           - Username: guest
           - Password: guest

---

**Autor:** Vagner Bruno

**Data:** Novembro de 2024
