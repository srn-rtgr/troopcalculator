# Army Calculator
This service provides an endpoint to create armies of swordsman, spearman and archer.

## System-Requirements
- Java 18
- Maven 3.8.6

## Build, test and run the application
build and test the application:

    mvn clean install

just build the application:

    mvn clean install -DskipTests

start the application:

    java -jar ./target/calculator-0.0.1-SNAPSHOT.jar

## Example Request
http://localhost:8080/randomArmy?amountOfTroops=100

## Extension

- create more kind of troops and let them extend from Troop.java
- add more attributes to troops
- depending on the use case it may be useful to have an entity for a single soldier
like swordsman, archer and spearman

## Tests

run tests:

    mvn test




