# AfterShip Integration Demo

Aftership Integration Demo is a spring boot based web service which provides the REST APIs for integration with the Aftership REST APIs. This helps to create the shipments and track them.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java(1.8+) and Maven 3.6.1

### Building the Control Panel

Clone the repository and run the below command from the project home directory. This will generate the runnable jar in the target directory.

```
mvn clean install
```

## Deployment

Use the below command to run the application

```
java -jar demo.0.0.1-SNAPSHOT.jar
```

### Swagger Documentation
Swagger Documentation is available at the below link

```
http://localhost:8080/afterShip/api/swagger-ui.html
```

### Postman collection 
The postman collection is available the root directory with the name shipment.postman_collection.json, Which consists of all the positive & negative scenarios for testing the create shipment & get shipment APIs.


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Abhilash Galipally**
