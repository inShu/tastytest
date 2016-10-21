package com.tastytest.core;

public class LimitationLength extends Limitation {
    private int min;
    private int max;

    public LimitationLength(int min, int max)
    {
        super(LimitationType.LENGTH);

        this.min = min;
        this.max = max;
    }

    public String generateValid()
    {
        return String.
    }

    public String generateInvalid()
    {
    }

    @Override
    protected String generateValid(String contentTable) {
        return null;
    }

    @Override
    protected String generateInvalid(String contentTable) {
        throw null;
    }
}
