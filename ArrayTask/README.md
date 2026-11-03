# ArrayTask — JAVA Core Kick. Arrays Part I (Light)

Educational console application on Java 21 (Maven): reads integers from a text file, validates lines, creates entity objects via Factory Method and Builder, computes min/max, sum and average (via Optional), and sorts arrays with two algorithms. Logging — Log4J2 (console + file). Tests — JUnit 5.

## Requirements
- JDK 21
- Maven 3.8+

## Running the application
From the project root (the data file `data/arrays.txt` is read via a relative path):

```
mvn compile exec:java
```

Results are written to the console and to `logs/arraytask.log` (the folder is created automatically on first run).

## Running the tests

```
mvn clean test
```

## Input format
A valid line contains integers (including negative ones) separated by commas; spaces around numbers are allowed. Examples of valid lines: `1, 2, 3`, `-5, 10 , -15`. Invalid: `1; 2; 3`, `3 4 7`, `1y1 21 32`, `1, 2, x3, 6..5, 77`, blank lines. Invalid lines are skipped and a warning is written to the log.

## Project structure
```
ArrayTask/
├── pom.xml
├── README.md
├── data/
│   └── arrays.txt                     input data file
└── src/
    ├── main/
    │   ├── java/com/innowise/arrayapp/
    │   │   ├── Main.java              entry point
    │   │   ├── entity/                entity classes (wrapper over int[])
    │   │   ├── exception/             custom exception
    │   │   ├── factory/               Factory Method
    │   │   ├── parser/                line-to-int[] parsing
    │   │   ├── reader/                file reading (Java NIO)
    │   │   ├── service/               service interfaces and implementations
    │   │   └── validator/             line validation
    │   └── resources/
    │       └── log4j2.xml             logging configuration
    └── test/
        └── java/com/innowise/arrayapp/    JUnit 5 tests
```

## Classes
- `entity.AbstractIntArrayEntity` — abstract entity superclass; stores a copy of the array and returns defensive copies.
- `entity.IntArrayEntity` — concrete entity class wrapping an int array.
- `entity.IntArrayEntityBuilder` — Builder for step-by-step entity creation.
- `exception.ArrayDataException` — custom exception class (extends Exception).
- `validator.ArrayLineValidator` — line validation with a regular expression (regex kept in a constant).
- `reader.LineReader` / `reader.ArrayFileLineReader` — file reading using Java 7+ APIs (`Files.readAllLines`).
- `parser.LineParser` / `parser.IntArrayLineParser` — parses a line into an int array.
- `factory.EntityFactory` / `factory.IntArrayEntityFactory` — Factory Method; uses the Builder internally.
- `service.ArraySearchService` / `IntArraySearchService` — min and max search via Optional.
- `service.ArrayMathService` / `IntArrayMathService` — sum and average via Optional.
- `service.ArraySortService` / `IntArraySortService` — bubble and insertion sort (implemented manually, without Arrays.sort).
