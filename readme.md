# A multiples counter that is using JDBC

[![Build Status](https://travis-ci.org/codex-academy/multiples-counter-with-jdbc.svg?branch=master)](https://travis-ci.org/codex-academy/multiples-counter-with-jdbc)

A multiples counter that stores it results in an [H2 SQL](http://www.h2database.com/html/main.html) database using JDBC.

The `CounterRunner` class support the `up`, `value` and `exit` commands from the command line.

How can we:

* change make this count in different multiple?
* how can we make the counters count up and down?
* how can you make the `CounterRunner` to use the `JDBCMultiplesCounter`

## Setup

To run this locally run:

```
mvn flyway:migrate
mvn package
java -cp target/counter-with-jdbc-1.0-SNAPSHOT.jar co.projectcodex.counter.CounterRunner
```

