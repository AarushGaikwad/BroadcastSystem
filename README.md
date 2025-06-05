# Broadcast System

## Overview

This project, **Broadcast System**, is a backend application built using **Java** and **Spring Boot** for managing broadcast messages. It allows CRUD (Create, Read, Update, Delete) operations on broadcast messages and integrates with **H2** as the in-memory database.

---

## Features

* Perform CRUD operations on broadcast messages.
* RESTful API endpoints.
* Configurable database properties via `application.properties`.
* Centralized exception handling.

---

## Requirements

To run this project, ensure you have the following installed:

* **Java Development Kit (JDK)** 17 or later
* **Maven** 3.8+ (for dependency management and build)
* A development environment like IntelliJ IDEA or Eclipse (optional but recommended)

---

## Setup Instructions

### Step 1: Clone the Repository

```bash
# Clone the repository using Git
$ git clone <repository-url>

# Navigate into the project directory
$ cd BroadcastSystem
```

### Step 2: Configure the Database

1. The application is pre-configured to use H2 as the database.
2. The H2 console can be accessed at `http://localhost:8080/h2-console` when the application is running.
3. Ensure the following settings in `application.properties` (located in `src/main/resources/`):

   ```properties
   spring.datasource.url=jdbc:h2:mem:broadcast_system
   spring.datasource.driver-class-name=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.h2.console.enabled=true
   ```

### Step 3: Build and Run the Application

```bash
# Build the application using Maven
$ mvn clean install

# Run the application
$ mvn spring-boot:run
```

---

## Usage

### Accessing the APIs

Once the application is running, you can access the API endpoints via:

* Base URL: `http://localhost:8080`

Use tools like **Postman** or **cURL** to interact with the APIs.

### Example Endpoints

* **GET** `/api/broadcasts` - Fetch all broadcast messages.
* **POST** `/api/broadcasts` - Create a new broadcast message.
* **PUT** `/api/broadcasts/{id}` - Update an existing broadcast message by ID.
* **DELETE** `/api/broadcasts/{id}` - Delete a broadcast message by ID.

### Accessing the H2 Console

* URL: `http://localhost:8080/h2-console`
* JDBC URL: `jdbc:h2:mem:broadcast_system`
* Username: `sa`
* Password: (leave blank)

---

## Folder Structure

* `src/main/java` - Contains the Java source code.

  * `controller` - Contains the REST controller for handling API requests.
  * `model` - Contains the data model class.
  * `repo` - Contains the repository interface for database interactions.
* `src/main/resources` - Includes configuration files like `application.properties`.
* `pom.xml` - Project Object Model file for Maven dependencies.

---

## Contributing

Feel free to fork this repository and submit pull requests for improvements or bug fixes.

---

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

---

## Support

For any issues or queries, please contact:

* Phone: +91 9156832992
* Email: [aarushgaikwad789@gmail.com](mailto:aarushgaikwad789@gmail.com)
