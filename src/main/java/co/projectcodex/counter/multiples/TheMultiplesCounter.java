package co.projectcodex.counter.multiples;

import co.projectcodex.counter.MultiplesCounter;

public class TheMultiplesCounter implements MultiplesCounter {

    private int multiple;
    private int value;

    public TheMultiplesCounter(int multiple) {
        this.multiple = multiple;
    }

    public void count() {
        value += multiple;
    }

    public int value() {
        return value;
    }

    public int getMultiple() {
        return multiple;
    }
}
