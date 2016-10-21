package com.tastytest.core;

public abstract class Limitation {
    private LimitationType limitType;

    protected Limitation(LimitationType limitType)
    {
        this.limitType = limitType;
    }

    public LimitationType getLimitType()
    {
        return this.limitType;
    }

    protected abstract String generateValid();
    protected abstract String generateInvalid();
    protected abstract String generateValid(String contentTable);
    protected abstract String generateInvalid(String contentTable);
}
