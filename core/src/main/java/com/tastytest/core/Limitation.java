package com.tastytest.core;

public abstract class Limitation {
    private final LimitationType limitType;

    protected Limitation(LimitationType limitType)
    {
        this.limitType = limitType;
    }

    public LimitationType getLimitType()
    {
        return this.limitType;
    }
}
