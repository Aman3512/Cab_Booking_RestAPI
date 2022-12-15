# REST API for a Cab Booking Application

* I have developed this REST API for a Cab Booking Application. This API performs all the fundamental CRUD operations of a Cab Booking platform with user validation at every step.

<br>

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Swagger

<br>

## Features

* The application allows users to book rides on a route.
* Users can register themself.
* Driving partner can onboard on the system with the vehicle details
* Users can search and select one from multiple available rides on a route with the same source and destination based on the nearest to the user.
* Drivers who are within 5 Kms from the users source will be available for booking.

<br>

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/Aman3512/Cab_Booking_RestAPI/blob/main/CabBookingApplication/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/cabDb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`



