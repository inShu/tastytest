package com.tastytest.core;

public class LimitationLength extends Limitation {
    private long min;
    private long max;

    public LimitationLength(long min, long max)
    {
        super(LimitationType.LENGTH);

        if (min > max)
            throw new RuntimeException("Minimum limitation must be bigger than maximum one.");

        this.min = min;
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }
}
