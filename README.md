# Izay REST API

Welcome to the Website REST API, a Spring Boot-based side project that provides RESTful APIs for managing website-related functionalities. The project uses PostgreSQL as the relational database.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Configuration](#configuration)
  - [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Technologies](#technologies)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Website REST API is designed to handle various website-related functionalities through a RESTful architecture. It includes endpoints for user management, content creation, and other aspects crucial to the website's operation.


## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK) 8 or later
- Maven
- PostgreSQL

### Configuration

Configure the database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/website_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```
Installation
Clone the repository:

```bash
Copy code
git clone https://github.com/your-username/website-rest-api.git
Build and run the application:
```
```bash
Copy code
cd website-rest-api
mvn clean install
java -jar target/website-rest-api.jar
The API should be accessible at http://localhost:8080.
```


Technologies
Spring Boot: Backend framework for building Java-based applications.
Spring Security: Provides authentication and authorization support.
PostgreSQL: Relational database for storing user and content data.
Maven: Build and dependency management tool.
