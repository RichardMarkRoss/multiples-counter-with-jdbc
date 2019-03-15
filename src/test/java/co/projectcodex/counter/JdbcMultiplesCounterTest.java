package co.projectcodex.counter;

import co.projectcodex.counter.multiples.JdbcMultiplesCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JdbcMultiplesCounterTest {

    Connection conn;

    public JdbcMultiplesCounterTest() throws Exception {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:file:./target/multiples_counter_test", "sa", "");
    }

    @BeforeEach
    public void cleanTheDatabase() throws Exception {

        try(Statement statement = conn.createStatement()) {
            statement.execute("delete from multiple");
            statement.execute("insert into multiple (multiple, counter) values (7, 14)");
        }
    }

    @Test
    public void shouldWorkForNewCounter() {

        try {

            MultiplesCounter multiplesCounter =  new JdbcMultiplesCounter(3, conn);
            assertEquals(0, multiplesCounter.value());
            multiplesCounter.count();
            assertEquals(3, multiplesCounter.value());

        } catch(Exception e) {
            fail("Should not throw an exception : " + e);
        }

    }

    @Test
    public void shouldLoadExistingValuesFromDatabase() {

        try {

            MultiplesCounter multiplesCounter =  new JdbcMultiplesCounter(7, conn);
            assertEquals(14, multiplesCounter.value());
            multiplesCounter.count();
            assertEquals(21, multiplesCounter.value());

            MultiplesCounter newMultiplesCounter =  new JdbcMultiplesCounter(7, conn);
            assertEquals(21, newMultiplesCounter.value());

        } catch(Exception e) {
            fail("Should not throw an exception : " + e);
        }

    }
}
