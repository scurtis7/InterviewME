![Build & Test](https://github.com/scurtis7/recruits/workflows/Build%20&%20Test/badge.svg)

# InterviewME Server

The InterviewME Server will handle all backend processing for the InterviewME front end UI. This
is a spring boot application using a postgresql database using R2DBC and reactive io.

### Stack

The InterviewME Service is built on top of a few core technologies:

* Java 17
* [Maven](https://maven.apache.org) (3.0.0+)
* [Spring Boot](https://spring.io/projects/spring-boot) (3.2.1)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web.reactive)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.r2dbc)

### Build

To build the Service without running tests:

`mvn clean compile`

To build the Service and run tests:

`mvn clean test`

To build the Service and generate code coverage:

`mvn clean verify`

To run all the commands at once:

`mvn clean compile test verify`

### Environment

In order to run the Service the following environment variables must be set:

| VARIABLE                   | Description                                                                               |
|:---------------------------|:------------------------------------------------------------------------------------------|
| SPRING_DATASOURCE_URL      | URL of the jdbc database including the databaseName.  This connection is used for Flyway. |
| SPRING_DATASOURCE_USERNAME | Jdbc Database username                                                                    |
| SPRING_DATASOURCE_PASSWORD | Jdbc database password                                                                    |
| SPRING_R2DBC_URL           | URL of the r2dbc database including the databaseName                                      |
| SPRING_R2DBC_USERNAME      | R2dbc database username                                                                   |
| SPRING_R2DBC_PASSWORD      | R2dbc database password                                                                   |

## How to run locally

I use a Mac and IntelliJ IDEA so these instructions are for that setup.
After you clone the repository then follow the steps below.

### Start Postgresql DB locally or in a docker container

First step is to start the Postgresql database locally or in a docker container. To start in a docker container run
the following command and of course replace the `<password>` with your own:

`docker run --name imeDb -e POSTGRES_PASSWORD=<password> -d -p 5432:5432 postgres`

### Build the spring boot application

Next build the Spring Boot application with these steps:

- open a terminal
- navigate to `.../ime-server`
- run the following command `mvn clean package`

### Start the application

First you will need to create a file called `application-local.yml` in the `src/main/resources`
folder. It needs to contain something like the following. The important parts are the spring
configuration properties. Replace `<password>` with your password. This file is ignored in
the `.gitignore` so we can keep our passwords secure.

```
# Application local properties

logging:
  level:
    com:
      scurtis: DEBUG
    org:
      springframework:
        data:
          r2dbc: DEBUG

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/imeDb
    username: postgres
    password: <password>
  r2dbc:
    url: r2dbc:postgresql://localhost:5432/imeDb
    username: postgres
    password: <password>
```

- In the terminal from the root folder (.../ime-server) you run the following command:

`java -jar -Dspring.profiles.active=local target/ime-server-0.0.1.jar`

- navigate to [http://localhost:8080](http://localhost:8080)

**NOTE:** You can also build and run the application from IntelliJ

