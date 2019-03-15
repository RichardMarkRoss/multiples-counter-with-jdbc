# A multiples counter that is using JDBC

A multiples counter that stores it results in an [H2 SQL](http://www.h2database.com/html/main.html) database using JDBC.

The `CounterRunner` class support the `up`, `value` and `exit` commands from the command line.

How can we:

* change make this count in different multiple?
* how can we make the counters count up and down?
* how can you make the `CounterRunner` to use the `JDBCMultiplesCounter`

## Setup

To setup a local database run:

```
mvn flyway:migrate
```

