# Teste Técnico — API de Usuários

Aplicação desenvolvida em **Java com Spring Boot** para gerenciamento de usuários através de uma API REST.

O projeto implementa as operações básicas de um CRUD, permitindo criar, listar, consultar, atualizar e remover usuários.

## Funcionalidades

* Criar usuário
* Listar usuários
* Buscar usuário por ID
* Atualizar usuário
* Remover usuário
* Validação dos dados informados
* Validação de e-mail
* Validação de senha
* Impedir cadastro de usuários com e-mail duplicado
* Retorno adequado para usuários inexistentes
* Persistência dos dados em banco de dados MySQL

## Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* MySQL Workbench
* Maven
* Git/GitHub

## Estrutura do projeto

```text
teste-desenvolvedor-java-junior/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── entrevista/
│   │   │           └── TesteTecnico/
│   │   │               ├── Controller/
│   │   │               │   └── UsuarioController.java
│   │   │               │
│   │   │               ├── Model/
│   │   │               │   └── UsuarioModel.java
│   │   │               │
│   │   │               ├── Repository/
│   │   │               │   └── UsuarioRepository.java
│   │   │               │
│   │   │               └── TesteTecnicoApplication.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Modelo de usuário

O usuário possui os seguintes dados:

| Campo      | Tipo   | Obrigatório |
| ---------- | ------ | ----------- |
| `id`       | int    | Não, gerado automaticamente |
| `nome`     | String | Sim |
| `email`    | String | Sim |
| `password` | String | Sim |
| `idade`    | int    | Não |
| `endereco` | String | Não |

O campo `id` é gerado automaticamente pela aplicação no momento do cadastro.

## Validações

A aplicação realiza validações básicas nos dados recebidos para cadastro e atualização de usuários, conforme os requisitos do teste técnico.

### Nome

O campo `nome` é obrigatório e não pode ser enviado vazio.

### E-mail

O campo `email` é obrigatório e deve possuir um formato válido.

Também não é permitido cadastrar dois usuários com o mesmo endereço de e-mail.

### Senha

O campo `password` é obrigatório e deve possuir um tamanho mínimo definido pela aplicação.

### Usuário inexistente

As operações de busca, atualização e exclusão verificam se o usuário informado existe antes de concluir a operação.

Caso o usuário não seja encontrado, a API retorna uma resposta adequada informando que o recurso não existe.

## Endpoints

A API disponibiliza os seguintes endpoints:

| Método | Endpoint      | Descrição             |
| ------ | ------------- | --------------------- |
| POST   | `/users`      | Criar usuário         |
| GET    | `/users`      | Listar usuários       |
| GET    | `/users/{id}` | Buscar usuário por ID |
| PUT    | `/users/{id}` | Atualizar usuário     |
| DELETE | `/users/{id}` | Remover usuário       |

A aplicação é executada, por padrão, em:

```text
http://localhost:8080
```

---

## Criar usuário

### POST `/usuarios`

Cria um novo usuário na aplicação.

Exemplo de requisição:

```json
{
  "nome": "Matheus Silva",
  "email": "matheus@email.com",
  "password": "senhaSegura123",
  "idade": 26,
  "endereco": "Brasília - DF"
}
```

A API recebe os dados enviados no corpo da requisição e realiza o cadastro do usuário no banco de dados.

---

## Listar usuários

### GET `/usuarios`

Retorna todos os usuários cadastrados.

Exemplo:

```http
GET http://localhost:8080/usuarios
```

Resposta esperada:

```json
[
  {
    "id": 1,
    "nome": "Matheus Silva",
    "email": "matheus@email.com",
    "password": "senhaSegura123",
    "idade": 26,
    "endereco": "Brasília - DF"
  }
]
```

---

## Buscar usuário por ID

### GET `/usuarios/{id}`

Retorna um usuário específico utilizando o ID informado.

Exemplo:

```http
GET http://localhost:8080/usuarios/1
```

Resposta esperada:

```json
{
  "id": 1,
  "nome": "Matheus Silva",
  "email": "matheus@email.com",
  "password": "senhaSegura123",
  "idade": 26,
  "endereco": "Brasília - DF"
}
```

Caso o usuário não seja encontrado, a API deve retornar uma resposta adequada informando que o recurso não existe.

---

## Atualizar usuário

### PUT `/usuarios/{id}`

Atualiza os dados de um usuário existente.

Exemplo:

```http
PUT http://localhost:8080/usuarios/1
```

Corpo da requisição:

```json
{
  "nome": "Matheus Silva Alterado",
  "email": "matheus.novo@email.com",
  "password": "novaSenha123",
  "idade": 27,
  "endereco": "Planaltina - DF"
}
```

A API localiza o usuário pelo ID informado e atualiza os dados enviados no corpo da requisição.

---

## Remover usuário

### DELETE `/usuarios/{id}`

Remove um usuário pelo ID informado.

Exemplo:

```http
DELETE http://localhost:8080/usuarios/1
```

Caso o usuário exista, ele será removido da base de dados.

Caso o usuário não seja encontrado, a API deve retornar uma resposta adequada informando que o recurso não existe.

---

# Validações

A aplicação realiza validações básicas nos dados recebidos para cadastro e atualização de usuários.

### Nome

O campo `nome` é obrigatório e não deve ser enviado vazio.

### E-mail

O campo `email` é obrigatório e deve possuir um formato válido.

Também não deve ser permitido cadastrar mais de um usuário com o mesmo e-mail.

### Senha

O campo `password` é obrigatório e deve possuir tamanho mínimo definido pela aplicação.

### Idade

O campo `idade` é utilizado para armazenar a idade do usuário.

### Endereço

O campo `endereco` é utilizado para armazenar o endereço do usuário.

### Usuário inexistente

As operações de busca, atualização e exclusão devem verificar se o usuário existe antes de concluir a operação.

---
# Banco de dados

O projeto utiliza **MySQL** para persistência dos dados.

O **MySQL Workbench** pode ser utilizado para criar, visualizar e gerenciar o banco de dados da aplicação.

Para  o banco de dados, foi executado o comando abaixo no MySQL Workbench:

```sql
CREATE DATABASE usuarios_db;
```

Depois, selecione o banco criado:

```sql
USE usuarios_db;
```

As tabelas da aplicação são criadas e atualizadas automaticamente pelo Hibernate, conforme a configuração definida no arquivo `application.properties`.

---

# Configuração da aplicação

A conexão com o banco de dados deve ser configurada no arquivo:

```text
src/main/resources/application.properties
```

Exemplo de configuração:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usuarios_db
spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Substitua `SUA_SENHA` pela senha configurada no MySQL.

---

# Como executar o projeto

## Pré-requisitos

Antes de executar o projeto, é necessário possuir as seguintes ferramentas instaladas:

* Java JDK 17 ou superior
* Git
* MySQL Server
* MySQL Workbench
* IDE de sua preferência, como IntelliJ IDEA, Eclipse ou Visual Studio Code

O projeto utiliza Maven Wrapper, por isso não é obrigatório ter o Maven instalado globalmente na máquina.

## 1. Clonar o repositório

```bash
git clone https://github.com/souzamtech/teste-desenvolvedor-java-junior.git
```

Acesse a pasta do projeto:

```bash
cd teste-desenvolvedor-java-junior
```

## 2. Configurar o banco de dados

Abra o MySQL Workbench e execute:

```sql
CREATE DATABASE usuarios_db;
```

Em seguida, configure o arquivo `application.properties` com o usuário e senha do seu MySQL.

## 3. Executar a aplicação

No Windows:

```bash
.\mvnw spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Após a inicialização, a API estará disponível em:

```text
http://localhost:8080
```

---

# Testando a API

A API pode ser testada utilizando ferramentas como:

* Postman
* Insomnia
* Thunder Client

Também é possível testar as requisições do tipo `GET` diretamente pelo navegador.

## Criar usuário

```http
POST http://localhost:8080/usuarios
```

Body JSON:

```json
{
  "nome": "Matheus Silva",
  "email": "matheus@email.com",
  "password": "senhaSegura123",
  "idade": 26,
  "endereco": "Brasília - DF"
}
```

## Listar usuários

```http
GET http://localhost:8080/usuarios
```

## Buscar usuário por ID

```http
GET http://localhost:8080/usuarios/1
```

## Atualizar usuário

```http
PUT http://localhost:8080/usuarios/1
```

Body JSON:

```json
{
  "nome": "Matheus Silva Alterado",
  "email": "matheus.novo@email.com",
  "password": "novaSenha123",
  "idade": 27,
  "endereco": "Planaltina - DF"
}
```

## Remover usuário

```http
DELETE http://localhost:8080/usuarios/1
```

---

# Códigos HTTP

A API utiliza códigos HTTP para representar o resultado das operações.

| Código | Descrição |
| ------ | --------- |
| `200 OK` | Requisição realizada com sucesso |
| `201 Created` | Usuário criado com sucesso |
| `204 No Content` | Operação realizada sem conteúdo para retornar |
| `400 Bad Request` | Dados inválidos na requisição |
| `404 Not Found` | Usuário não encontrado |
| `409 Conflict` | E-mail já cadastrado |
| `500 Internal Server Error` | Erro interno do servidor |

---

# Considerações finais

O projeto foi desenvolvido como parte de um teste técnico para demonstrar conhecimentos em desenvolvimento de APIs REST utilizando Java e Spring Boot.

A aplicação implementa as operações básicas de um CRUD de usuários, utilizando persistência com MySQL e organização em camadas com Controller, Model e Repository.

O foco principal do projeto é apresentar uma solução funcional, organizada e objetiva, atendendo aos requisitos propostos no desafio técnico.

---

## Autor

Desenvolvido por **Matheus Souza**.

GitHub: https://github.com/souzamtech
