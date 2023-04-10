# Stock Management API
An RESTful API made in Java, for stock management.

This is an API made in Java for stock control and company inventory. 
It has an authentication method used with Spring Security, where the user needs to 
register and then login to generate a JWT code that will track all user requests in the API. All functions use DTO on data input and output.
<br><br>
**All passwords are encrypted when they are registered in the database.** <br><br>
This API has a transaction history, where it saves each transaction made with the user, the day and time, and the type of transaction
(register product, update product, update product quantity or delete product).
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


