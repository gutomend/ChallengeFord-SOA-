# 🚘 AutoSpec API

---
Sistema desenvolvido para padronização automática de especificações técnicas automotivas, permitindo consolidar informações vindas da concorrência em um formato único, organizado e comparável.
---

# 👨‍🎓 Integrantes

- Augusto Mendonça — RM558371
- Gabriel Vasquez — RM557056
- Gustavo Oliveira — RM556348

---

# 👨‍🏫 Disciplina

Arquitetura Orientada a Serviços e Web Services

---

# 🏫 Instituição

FIAP — Faculdade de Informática e Administração Paulista
---

# 📚 Sobre o Projeto

O projeto tem como objetivo receber dados técnicos automotivos de diferentes fontes e transformá-los em uma estrutura padronizada.

A solução foi desenvolvida utilizando:

- Arquitetura Orientada a Serviços (SOA)
- APIs RESTful
- Spring Boot
- PostgreSQL
- Swagger/OpenAPI
- Flyway

---

# 🎯 Problema Resolvido

Fabricantes e concorrentes utilizam nomenclaturas diferentes para especificações técnicas automotivas.

Exemplo:

| Entrada Original | Saída Padronizada |
|---|---|
| Horse Power | Potencia |
| HP | Potencia |
| Engine | Motor |
| Torque Máximo | Torque |

O sistema recebe informações técnicas e automaticamente converte para um padrão único e comparável.

---

# 🏗️ Arquitetura da Solução

A aplicação segue arquitetura em camadas:

```text
controller
 ↓
service
 ↓
repository
 ↓
database
```

## 📌 Responsabilidades

| Camada | Responsabilidade |
|---|---|
| Controller | Exposição dos endpoints REST |
| Service | Regras de negócio |
| Repository | Comunicação com banco |
| Model | Entidades JPA |
| DTO | Transporte de dados |
| Exception | Tratamento global de erros |

---

# 🛠️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 21 | Linguagem principal |
| Spring Boot | Framework backend |
| Spring Web | APIs REST |
| Spring Data JPA | Persistência |
| PostgreSQL | Banco de dados |
| Flyway | Controle de migrations |
| Swagger/OpenAPI | Documentação da API |
| Maven | Gerenciamento de dependências |
| Lombok | Redução de boilerplate |

---

# 📂 Estrutura do Projeto

```text
src/main/java/br/com/fiap/autospec_api

├── controller
├── service
├── repository
├── model
├── dto
└── exception
```

---

# ⚙️ Funcionalidades Implementadas

## ✅ Cadastro de veículos

Permite cadastrar veículos juntamente com suas especificações técnicas.

---

## ✅ Consulta de veículos

Retorna veículos e especificações padronizadas.

---

## ✅ Padronização automática

Serviço responsável por normalizar atributos técnicos.

### Exemplo

```text
Horse Power → Potencia
Engine → Motor
```

---

## ✅ Consulta técnica padronizada

Simula integração com dados da concorrência e retorna informações já padronizadas.

---

# 🌐 Endpoints da API

---

# 🚗 1. Cadastrar veículo

## POST
```http
/api/veiculos
```

## Exemplo Request

```json
{
  "marca": "Ford",
  "modelo": "Ranger",
  "versao": "Raptor",
  "especificacoes": [
    {
      "atributo": "Motor",
      "valor": "3.0 V6 Bi-Turbo"
    },
    {
      "atributo": "Potencia",
      "valor": "397 cv"
    }
  ]
}
```

---

# 📋 2. Listar veículos

## GET
```http
/api/veiculos
```

---

# 🔄 3. Padronizar atributo técnico

## POST
```http
/api/padronizacao
```

## Exemplo Request

```json
{
  "atributo": "Horse Power"
}
```

## Exemplo Response

```json
{
  "atributoOriginal": "Horse Power",
  "atributoPadronizado": "Potencia"
}
```

---

# 🔍 4. Consulta técnica padronizada

## GET
```http
/api/consulta-tecnica/{marca}/{modelo}/{versao}
```

## Exemplo

```http
/api/consulta-tecnica/ford/ranger/raptor
```

## Exemplo Response

```json
{
  "marca": "ford",
  "modelo": "ranger",
  "versao": "raptor",
  "especificacoes": [
    {
      "atributo": "Potencia",
      "valor": "397 cv"
    },
    {
      "atributo": "Motor",
      "valor": "3.0 V6 Bi-Turbo"
    },
    {
      "atributo": "Torque",
      "valor": "59 kgfm"
    }
  ]
}
```

---

# 📖 Swagger/OpenAPI

A documentação da API pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

---

# 🗄️ Banco de Dados

Banco utilizado:

```text
PostgreSQL
```

Controle de migrations:

```text
Flyway
```

## 📌 Migrations implementadas

| Migration | Descrição |
|---|---|
| V1 | Criação da tabela veiculo |
| V2 | Criação da tabela especificacao |

---

# 🛡️ Tratamento de Erros

A aplicação possui tratamento global de exceções utilizando:

```java
@RestControllerAdvice
```

## ✅ Validações implementadas

- Campos obrigatórios
- JSON inválido
- Erros de requisição

---

# 🧠 Conceitos Aplicados

- REST
- JSON
- SOA
- Arquitetura em Camadas
- DTO Pattern
- JPA/Hibernate
- Swagger/OpenAPI
- Flyway Migrations
- Padronização Técnica
- Reutilização de Serviços

---

# ▶️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```bash
git clone [URL_DO_REPOSITORIO]
```

---

## 2️⃣ Configurar o PostgreSQL

Criar o banco:

```sql
CREATE DATABASE autospec;
```

---

## 3️⃣ Configurar o application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/autospec
spring.datasource.username=postgres
spring.datasource.password=senha
```

---

## 4️⃣ Executar o projeto

Pela IDE:

```text
AutospecApiApplication.java
```

Ou pelo terminal:

```bash
mvn spring-boot:run
```

---

