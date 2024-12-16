# SDAT_Sprint1_Sprint2_Server

This project is a Spring Boot application that provides a RESTful service for creating and retrieving binary search trees (BST) from a list of integers.

React UI available here : `https://github.com/MazRadwan/DSA_bstFrontEnd.git`

## Getting Started

### Prerequisites

- Java 22
- Maven
- MySQL

### Setup MySQL Database

1. Create a database named `bst_db`.
2. Update the database credentials in `src/main/resources/application.properties`.

### Build and Run the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`.

## API Endpoints

### Create a Binary Search Tree

- **URL:** `/process-numbers`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "numbers": [1, 2, 3, 4, 5]
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "inputNumbers": "[1, 2, 3, 4, 5]",
    "treeStructure": "{...}",
    "createdAt": "2023-10-01T12:00:00"
  }
  ```

### Retrieve All Binary Search Trees

- **URL:** `/previous-trees`
- **Method:** `GET`
- **Response:**
  ```json
  [
      {
          "id": 1,
          "inputNumbers": "[1, 2, 3, 4, 5]",
          "treeStructure": "{...}",
          "createdAt": "2023-10-01T12:00:00"
      },
      ...
  ]
  ```

## Project Details

### Main Classes

- [`RestServiceApplication`](src/main/java/com/keyin/RestServiceApplication.java): The main class to run the Spring Boot application.
- [`BinarySearchTreeService`](src/main/java/com/keyin/bst/BinarySearchTreeService.java): Service class to handle BST creation and retrieval.
- [`BinarySearchTreeController`](src/main/java/com/keyin/bst/BinarySearchTreeController.java): REST controller to expose endpoints.
- [`BinarySearchTreeRepository`](src/main/java/com/keyin/bst/BinarySearchTreeRepository.java): Repository interface for BST entity.
- [`BinarySearchTree`](src/main/java/com/keyin/bst/BinarySearchTree.java): Entity class representing the BST.
- [`Node`](src/main/java/com/keyin/bst/Node.java): Class representing a node in the BST.
- [`WebConfig`](src/main/java/com/keyin/config/WebConfig.java): Configuration class for CORS settings.

### Configuration

- [`application.properties`](src/main/resources/application.properties): Contains database and other configuration settings.

## Dependencies

- Spring Boot
- Spring Data JPA
- MySQL
- H2 Database (for testing)
- Jackson (for JSON processing)

## License

This project is licensed under the MIT License.
