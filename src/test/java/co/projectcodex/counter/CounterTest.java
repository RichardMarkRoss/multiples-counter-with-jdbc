package co.projectcodex.counter;

import co.projectcodex.counter.multiples.TheMultiplesCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest {

    @BeforeEach
    public void populateDatabase() {

    }

    @Test
    public void shouldBeAbleToCountInThrees(){

        MultiplesCounter multiplesCounter = new TheMultiplesCounter(3);

        multiplesCounter.count();
        multiplesCounter.count();
        multiplesCounter.count();

        assertEquals(9, multiplesCounter.value());

    }

    @Test
    public void shouldBeAbleToCountInSevens(){

        MultiplesCounter multiplesCounter = new TheMultiplesCounter(7);

        multiplesCounter.count();
        multiplesCounter.count();
        multiplesCounter.count();

        assertEquals(21, multiplesCounter.value());

    }



    @Test
    public void shouldBeAbleToGetCounterFromDatabase(){

        MultiplesCounter multiplesCounter = new TheMultiplesCounter(3);

        multiplesCounter.count();
        multiplesCounter.count();
        multiplesCounter.count();

        assertEquals(9, multiplesCounter.value());

    }
}
