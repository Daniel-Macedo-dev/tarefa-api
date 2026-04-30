# ✅ Tarefa API

API REST desenvolvida com Java e Spring Boot para gerenciamento de tarefas, com foco em organização em camadas, operações CRUD e boas práticas de desenvolvimento backend.

## 📌 Descrição

A Tarefa API permite:

- cadastrar tarefas
- listar tarefas
- buscar tarefa por ID
- substituir uma tarefa por completo
- atualizar parcialmente uma tarefa
- remover tarefa por ID

O projeto utiliza banco de dados H2 em memória, facilitando testes e desenvolvimento sem necessidade de configuração externa.

## 🛠️ Tecnologias utilizadas

- Java 24
- Spring Boot 3.5.5
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Springdoc OpenAPI
- Maven

## 🧱 Estrutura do projeto

```text
tarefa-api/
├── swagger/
│   └── openapi.yaml
├── tarefa-api/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/danielMacedo/tarefa_api/
│   │   │   │   ├── business
│   │   │   │   ├── controller
│   │   │   │   ├── dto
│   │   │   │   ├── exceptions
│   │   │   │   └── infrastructure
│   │   │   │       ├── entities
│   │   │   │       └── repository
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
└── README.md
```

## 🏗️ Organização em camadas

- `controller`: exposição dos endpoints REST
- `business`: regras de negócio
- `dto`: objetos de entrada e saída da API
- `exceptions`: tratamento global de exceções
- `infrastructure.entities`: entidades JPA
- `infrastructure.repository`: acesso aos dados com Spring Data JPA

## 🚀 Funcionalidades

- **POST** `/tarefa` → criar tarefa
- **GET** `/tarefa` → listar tarefas
- **GET** `/tarefa/{id}` → buscar tarefa por ID
- **PUT** `/tarefa/{id}` → substituir tarefa por completo
- **PATCH** `/tarefa/{id}/status` → atualizar parcialmente uma tarefa
- **DELETE** `/tarefa/{id}` → remover tarefa por ID

## 📝 Regras atuais da API

- Ao criar uma tarefa, o campo `status` é definido como `false`.
- A entidade possui o campo `createdAt`, preenchido automaticamente no momento da persistência.
- O endpoint `PATCH /tarefa/{id}/status` atualmente permite atualização parcial de:
  - `titulo`
  - `descricao`
  - `status`

> **Observação:** apesar de a rota terminar com `/status`, o comportamento atual do serviço permite atualizar qualquer combinação desses três campos.

## ▶️ Como executar

### 1. Clonar o repositório

```bash
git clone https://github.com/Daniel-Macedo-dev/tarefa-api.git
```

### 2. Entrar na pasta do projeto

```bash
cd tarefa-api/tarefa-api
```

### 3. Executar a aplicação

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

Ou, se preferir:

```bash
mvn spring-boot:run
```

## 🌐 Acessos locais

### API

```text
http://localhost:8080/tarefa
```

### Console do H2

```text
http://localhost:8080/h2-console
```

Use os seguintes dados no console:

- **JDBC URL:** `jdbc:h2:mem:meubanco`
- **User Name:** `sa`
- **Password:** deixe em branco

## 📄 Documentação OpenAPI

A especificação manual da API está disponível em:

```text
swagger/openapi.yaml
```

## ✅ Exemplos de requisição

### Criar tarefa

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar controller, service e repository"
}
```

### Substituir tarefa por completo

```json
{
  "titulo": "Estudar Java",
  "descricao": "Revisar orientação a objetos",
  "status": true
}
```
### Atualizar tarefa parcialmente

```json
{
  "titulo": "Estudar Spring",
  "status": true
}
```

Também é possível atualizar apenas um campo:

```json
{
  "descricao": "Revisar DTOs e tratamento de exceções"
}
```

## 📦 Estrutura de resposta

A API utiliza `TarefaResponseDTO` nas respostas de leitura e atualização, contendo:

- `id`
- `titulo`
- `descricao`
- `status`
- `createdAt`

## ❗ Tratamento de erros

O projeto possui tratamento global para:

- recurso não encontrado (`404 Not Found`)
- requisição inválida (`400 Bad Request`)
- erros genéricos (`500 Internal Server Error`)

## 📚 Objetivo do projeto

Este projeto foi desenvolvido para praticar:

- construção de APIs REST com Spring Boot
- separação em camadas
- uso de DTOs
- persistência com JPA
- tratamento de exceções
- documentação de API

## 👨‍💻 Autor
Daniel Macedo
