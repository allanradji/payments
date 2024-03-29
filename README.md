# payments
Simple API to payments with few endpoints to payments

## How to Run

clone the project ```https://github.com/allanradji/payments.git``` then in the folder of project execute ```cd payments``` then run the command ```mvn install``` and after that run ```mvn spring-boot:run```.

if someone of these commands ```mvn install``` and ```mvn spring-boot:run``` doesn't work don't be scared just run again. And even so doesn't work these links may help you:

```
-http://www.appsdeveloperblog.com/run-spring-boot-app-from-a-command-line
-https://www.mkyong.com/maven/how-to-install-maven-in-windows
-https://www.javahelps.com/2017/10/install-apache-maven-on-linux.html
```

In case of all options to run failure import as maven project using the STS4 IDE ```https://spring.io/tools``` so run the project as ```spring boot aplication```.

**p.s. the database created by springboot is testdb in h2 console ```http://localhost:8080/h2-console``` change JDBC URL to ```jdbc:h2:mem:testdb``` **
  
## Operations

### Creating new card payment
```
POST localhost:8080/payments
```
```
{
	"amount" : 100,
	"type" : "CREDIT_CARD",
	"card" : {
		"holderName": "ALLAN RADJI",
		"cvv":	"123",
		"number": "5390101856623171",
		"expirationDate" : "2019-12-01"
	},
	"buyer" : {
		"name" : "ALLAN",
		"email" : "allanradji@gmail.com",
		"cpf" : "74936143006"
	}
	
}
```
### Answer:
```
  APPROVED
```
### Creating new boleto payment:
```
POST localhost:8080/payments
{
	"amount" : 100,
	"type" : "BOLETO",
	"buyer" : {
		"name" : "ALLAN",
		"email" : "allanradji@gmail.com",
		"cpf" : "74936143006"
	}
	
}
```
### Answer:
```
23790.50400 41991.022231 38008.109209 5 80530000019900
```
### Checking payment:
```
GET localhost:8080/payments/{payment_id}
```
### Answer:
```
{
    "id": 1,
    "amount": 100.0,
    "type": "CREDIT_CARD",
    "card": {
        "id": 3,
        "holderName": "ALLAN RADJI",
        "number": "5390101856623171",
        "expirationDate": "2019-12-01",
        "cvv": "123"
    },
    "boleto": null,
    "status": "APPROVED",
    "client": {
        "id": 4
    },
    "buyer": {
        "id": 2,
        "name": "ALLAN",
        "email": "allanradji@gmail.com",
        "cpf": "74936143006"
    }
}
```
## Postman Collection
The collection with some examples to import into your Postman can be downloaded using the following link.
```https://www.getpostman.com/collections/3239bcdf06dea0f00ec3```

## Design Adopted

### Factory
The payment transaction is a factory pattern to instanciate a method of payment and return a payment checked through validators.

### Validator
The validators check if some attributes are valids to do a payment. There are 3 validators:
```
- PaymentValidator
- CardValidator
- BuyerValidator
```

### Dependency Injection
In some parts of the project you will find dependencies injections as well as into PaymentController that is using a PaymentService.

### DTO's
```
- BoletoDTO
- BuyerDTO
- CardDTO
- ClientDTO
- PaymentDTO
```

### Mapper's
Used to parse the DTO classes to classes of domain and vice versa. the ModelMapper is used to make perses in a simple and safety way.  

### Exceptions
2 Exceptions were created to this project
```
- PaymentNotFoundException
- ResourceException
```

## Dependencies
```
* Java 8
* Maven 3
* JUnit4
* h2 database
* Spring Boot 2.2
* Project Lombok 1.18.10
* Mockito 3
* ModelMapper 2.3.5
```
