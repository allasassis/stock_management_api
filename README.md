# Stock Management API
An RESTful API made in Java, for stock management.

This is an API made in Java for stock control and company inventory. 
It has an authentication method used with Spring Security, where the user needs to 
register and then login to generate a JWT code that will track all user requests in the API. All functions use DTO on data input and output.
<br><br>
**All passwords are encrypted when they are registered in the database.** <br><br>
This API has a transaction history, where it saves each transaction made with the user, the day and time, and the type of transaction
(register product, update product, update product quantity or delete product) and can be accessed by the endpoint list transactions.
## API Functions:
### Products:
- List products
- Register product
- Update product
- Update product quantity
- Delete product

### Transactions:
- List transactions

### Authentication:
- Sign up (username and password)
- Sign in

## Technologies used:

- Java
- Spring Boot
- Spring Security
- MySQL
- JPA
- Tomcat
- Maven
- Flyway (Migrations)
- Postman
- Spring Doc (Open API - Swagger)
- Auth0 (JWT Tokens generator)
- BCrypt Password Encoder
- Lombok

## Documentation
Clone or download the application and run it, after that consult the documentation with all the methods in the link bellow:
<br>http://localhost:8080/swagger-ui.html

## Author

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis

--------------------------------------------------------

### PT-BR
# API de gerenciamento de estoque
Uma API RESTful feita em Java, para gerenciamento de estoque.

Trata-se de uma API feita em Java para controle de estoque e inventário da empresa.
Possui um método de autenticação utilizado com Spring Security, onde o usuário precisa
registrar-se e fazer o login para gerar um código JWT que acompanhará todas as solicitações do usuário na API. Todas as funções usam DTO na entrada e saída de dados.
<br><br>
**Todas as senhas são criptografadas quando são cadastradas no banco de dados.** <br><br>
Esta API possui um histórico de transações, onde salva cada transação realizada com o usuário, o dia e horário, e o tipo de transação
(cadastrar produto, atualizar produto, atualizar quantidade de produto ou deletar produto) e pode ser acessada pelo endpoint listar transações.
## Funções da API:
### Produtos:
- Listar produtos
- Cadastrar produto
- Atualizar produto
- Atualizar a quantidade do produto
- Excluir produto

### Transações:
- Listar transações

### Autenticação:
- Cadastre-se (usuário e senha)
- Entrar

## Tecnologias utilizadas:

- Java
- Spring Boot
- Spring Security
- MySQL
- JPA
- Tomcat
- Maven
- Flyway (Migrations)
- Postman
- Spring Doc (Open API - Swagger)
- Auth0 (Gerador de tokens JWT)
- BCrypt Password Encoder
- Lombok

## Documentação
Clone ou baixe a aplicação e execute-a, após isso consulte a documentação com todos os métodos no link abaixo:
<br>http://localhost:8080/swagger-ui.html

## Autor

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis


