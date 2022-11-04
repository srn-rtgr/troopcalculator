# Army Calculator
This service provides an endpoint to create armies of swordsman, spearman and archer.

## System-Requirements
- Java 18

## Start-up
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




