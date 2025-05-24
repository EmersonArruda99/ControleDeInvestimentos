# 📊 Controle de Investimentos

Sistema web para controle de ativos, operações de compra e proventos (como dividendos e JCP), com documentação integrada via Swagger.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (para testes locais)
- Swagger (OpenAPI 3) via Springdoc
- Lombok

---

## 📚 Funcionalidades

- 📌 Cadastro de Ativos (ações, FIIs, etc.)
- 🛒 Registro de Operações (compras de ativos)
- 💸 Lançamento de Proventos (dividendos, JCP)
- 📖 Documentação automática via Swagger

---

## 📦 Como rodar o projeto localmente

1. Clone o repositório:
git clone https://github.com/seu-usuario/controle-de-investimentos.git
cd controle-de-investimentos

2. Importe no IntelliJ (ou sua IDE) como projeto Maven

3. Execute a aplicação com:
./mvnw spring-boot:run

4. Acesse a documentação:
http://localhost:8080/swagger-ui.html


## 🛠 Exemplo de uso via Swagger
- POST /ativos – Cadastrar novo ativo

- POST /operacoes – Registrar operação de compra

- POST /proventos – Lançar provento recebido

- GET /proventos – Listar todos os proventos

## ✅ Próximos passos
- 📈 Implementar cálculo de posição por ativo

- 📅 Apuração mensal de IR

- 📊 Dashboard de rentabilidade

- 🔒 Segurança com autenticação (JWT ou OAuth2)
