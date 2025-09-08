# ✅📋 Tarefa API ✅📋

Projeto em Java para gerenciar tarefas, aplicando boas práticas de arquitetura com **camadas separadas** e regras de negócio claras.

## 📝 Descrição

Esta API REST em Java permite cadastrar, listar, buscar, atualizar e remover tarefas.  
Utiliza o banco de dados em memória **H2**, facilitando testes e desenvolvimento sem necessidade de configuração externa.

A arquitetura está organizada em **camadas**:  
- **Controller**: define os endpoints REST  
- **Service**: contém as regras de negócio  
- **Repository**: acesso ao banco de dados  
- **Entities**: mapeamento das tabelas  

## ⚙️ Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- Banco de dados H2 (em memória)
- Maven
- Lombok

## 🗂️ Estrutura do Projeto

- `controller`: endpoints REST  
- `business`: regras de negócio (services)  
- `infrastructure.entities`: entidades JPA  
- `infrastructure.repository`: repositórios (JPA)  

## 🚀 Funcionalidades

- **Cadastrar nova tarefa** (`POST /tarefa`)  
- **Listar todas as tarefas** (`GET /tarefa`)  
- **Buscar tarefa por ID** (`GET /tarefa/{id}`)  
- **Remover tarefa por ID** (`DELETE /tarefa/{id}`)  
- **Atualizar tarefa (substituição completa)** (`PUT /tarefa/{id}`)  
- **Atualizar apenas o status da tarefa** (`PATCH /tarefa/{id}/status`)

## 📄 Documentação OpenAPI
O arquivo [`openapi.yaml`](openapi.yaml) contém a especificação completa da API de tarefas.
  

## ▶️ Como rodar

1. Clone o repositório:

```bash
git clone https://github.com/Daniel-Macedo-dev/tarefa_api.git
```

2. Abra o projeto na IDE (IntelliJ, Eclipse, etc).  
3. Configure JDK 17+.  
4. Execute:

```bash
mvn spring-boot:run
```

5. Acesse a API:

```
http://localhost:8080/tarefa
```

6. Para acessar o console web do banco H2 (útil para ver e manipular dados):

```
http://localhost:8080/h2-console
```

- **JDBC URL:** `jdbc:h2:mem:testdb`  
- **Usuário:** `sa`  
- **Senha:** *(deixe em branco)*

---

Qualquer dúvida ou sugestão, fique à vontade para abrir uma issue ou pull request.  
Obrigado por conferir o projeto! 🧊🥳
