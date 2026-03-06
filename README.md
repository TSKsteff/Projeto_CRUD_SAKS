# CRUD Java Desktop – Admin & Funcionários

Este repositório contém duas implementações de um sistema CRUD de usuários com controle de acesso entre administradores e funcionários.

O objetivo do projeto foi estudar arquitetura de aplicações Java Desktop, evoluindo de uma versão simples para uma versão mais organizada utilizando **Spring + JavaFX**.

---

# 📌 Objetivo do Sistema

Criar um sistema CRUD com dois tipos de usuários:

## Admin

* Pode visualizar **todos os funcionários**
* Pode **criar, editar e remover usuários**

## Funcionário

* Pode **visualizar apenas os próprios dados**
* Pode **editar apenas o próprio perfil**

A interface do sistema é **desktop**, construída utilizando **JavaFX**.

---

# 🧩 Projetos no Repositório

O repositório contém **duas versões do mesmo sistema**.

---

# 1️⃣ CRUD-DSF1 (Versão Antiga)

Primeira versão do sistema desenvolvida utilizando **Java puro**.

Esta versão foi criada para aprendizado inicial e **não possui uma arquitetura bem organizada**.

## Características

* Java 17 ou anterior
* Interface feita com **Swing/Forms do NetBeans**
* Conexão direta com **MySQL**
* Código pouco modularizado
* Sem testes
* Estrutura simples

⚠️ Esta versão **não é estável e não foi preparada para testes automatizados**.

---

# Estrutura de Pastas

```text
CRUD-DSF1
│
├─ lib
│   └─ bibliotecas externas
│
├─ nbproject
│   └─ arquivos de configuração do NetBeans
│
├─ src
│   │
│   ├─ SistemasSQL
│   │   └─ telas e lógica principal do sistema
│   │
│   ├─ app
│   │   └─ classe principal da aplicação
│   │
│   └─ conexaoSql
│       └─ classe de conexão com o banco de dados
│
├─ build.xml
│   └─ script de build do projeto
│
└─ manifest.mf
    └─ configuração de execução do jar
```

---

# 2️⃣ Register Services (Versão Moderna)

Esta é a **versão mais recente do projeto**, construída utilizando uma arquitetura mais organizada.

Apesar de **não ser uma aplicação web**, utilizei o **Spring Boot** para facilitar o desenvolvimento.

A interface continua sendo **desktop**, feita com **JavaFX**.

---

# ⚙️ Tecnologias Utilizadas

* Java
* Spring Boot
* JavaFX
* Maven
* MySQL
* Hibernate
* JPA
* Lombok
* JWT
* Bean Validation
* Docker

---

# Por que usar Spring em uma aplicação Desktop?

Mesmo sendo um aplicativo desktop, o Spring ajuda a:

* Organizar melhor a arquitetura
* Facilitar **injeção de dependências**
* Usar **JPA + Hibernate**
* Usar **validação automática**
* Reduzir código boilerplate com **Lombok**
* Implementar **autenticação via JWT**

---

# 🧱 Arquitetura do Projeto

O projeto segue uma separação por responsabilidades.

```
src/main/java/br/saks/register_services
```

```text
register_services
│
├─ Entities
│   └─ entidades do banco de dados
│
├─ Repositories
│   └─ acesso aos dados via JPA
│
├─ configs
│   └─ configurações do Spring e JavaFX
│
├─ dtos
│   └─ objetos de transferência de dados
│
├─ enums
│   └─ enumerações do sistema
│
├─ events
│   └─ eventos internos da aplicação
│
├─ exceptions
│   └─ tratamento de exceções
│
├─ facades
│   └─ camada intermediária entre UI e serviços
│
├─ listeners
│   └─ escutadores de eventos da aplicação
│
├─ securities
│   └─ contexto de autenticação e segurança
│
├─ services
│   └─ regras de negócio
│
├─ utils
│   └─ utilitários e helpers
│
├─ viewmodels
│   └─ lógica entre UI e backend
│
└─ views
    └─ telas JavaFX
```

---

# 📂 Estrutura de Resources

```text
src/main/resources
│
├─ fxml
│   └─ arquivos das telas JavaFX
│
├─ app.key
│   └─ chave privada JWT
│
├─ app.pub
│   └─ chave pública JWT
│
└─ application.yaml
    └─ configurações da aplicação
```

---

# 🐳 Banco de Dados com Docker

Para rodar o banco de dados:

```bash
docker compose up -d
```

Isso irá subir o **MySQL utilizado pelo sistema**.

---

# ▶️ Como Rodar o Projeto

Após iniciar o Docker:

## Atualizar dependências

```bash
mvn clean install -DskipTests
```

ou

```bash
mvn clean install
```

---

## Rodar aplicação

Execute a classe:

```
RegisterServicesApplication.java
```

A interface **JavaFX será iniciada**.

---

# 🔐 Autenticação

O sistema utiliza:

* **JWT (JSON Web Token)**
* geração de **token de acesso**
* controle de **permissões entre admin e usuário**

---

# 📚 Aprendizados com o Projeto

Este projeto foi criado para praticar:

* Arquitetura de aplicações Java
* CRUD com controle de acesso
* Integração **Spring + JavaFX**
* Persistência com **JPA/Hibernate**
* Autenticação com **JWT**
* Estruturação de projetos maiores

---

💡 A segunda versão representa a **evolução da primeira**, trazendo **melhor arquitetura, organização e escalabilidade**.
