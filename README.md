# Atipera-Recruitment-Task

This project uses a GET request to the GitHub API to fetches non-forked GitHub repositories of a given username, followed by a second request per repository to retrieve branch information.

## Tech Stack
-  Java 21
-  Spring Boot 3.5.x
-  Spring Web
-  Maven
-  Lombok
-  JUnit 5 
-  GitHub REST API v3

## Setup

1. Clone the repository:
```
git clone https://github.com/MichaelWoj/Atipera-Recruitment-Task.git
cd Atipera-Recruitment-Task
```

2. Build the project:
```
mvn clean install
```

3. Run the application:
```
mvn spring-boot:run
```

## How to Use 

The app uses the following path in the GET request:
```
GET /{username}/repos
```

Example:
```
GET http://localhost:8080/michaelwoj/repos
```

The response will be returned to the user in a JSON format:
```
[
  {
  name: "DietTrackingApp"
  login: "MichaelWoj"
  branch:	
    0:	
      name: "main"
      sha: "2e5a27bff173540680eb2e32e32c4fa073fab641"
  }
]
```

## Testing 

This project contains one integration test which:
    -  Verifies HTTP status code 200
    -  Validates response structure

Run the test:
```
mvn test
```
