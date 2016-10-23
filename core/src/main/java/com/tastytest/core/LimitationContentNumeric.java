package com.tastytest.core;

public class LimitationContentNumeric extends Limitation implements LimitationContentInterface {
    public LimitationContentNumeric(LimitationType limitType) {
        super(LimitationType.CONTENT_TYPE);
    }

    public String getContent() {
        return null;
    }
}
