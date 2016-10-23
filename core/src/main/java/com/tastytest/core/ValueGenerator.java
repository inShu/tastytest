package com.tastytest.core;

import static com.tastytest.core.LimitationType.CONTENT_TYPE;

public class ValueGenerator {
    private LimitationContentInterface contentLimit;
    private LimitationLength lengthLimit;

    public ValueGenerator(LimitationContentInterface contentLimit, LimitationLength lengthLimit)
    {
        if (contentLimit == null)
            throw new RuntimeException("You can't add nulled content limit");
        if (!(contentLimit instanceof Limitation))
            throw new RuntimeException("Content is not a limitation");
        if (((Limitation) contentLimit).getLimitType() != CONTENT_TYPE)
            throw new RuntimeException("Content limit is not actual CONTENT type.");

        if (lengthLimit == null)
            throw new RuntimeException("You can't add nulled length limit");

        this.contentLimit = contentLimit;
        this.lengthLimit = lengthLimit;
    }

    public String getValue()
    {
        return null;
    }
}
