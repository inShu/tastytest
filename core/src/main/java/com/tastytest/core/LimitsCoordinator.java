package com.tastytest.core;

public class LimitsCoordinator {
    private Limitation contentLimit;
    private Limitation lengthLimit;

    public LimitsCoordinator(Limitation contentLimit, Limitation lengthLimit)
    {
        if (contentLimit == null)
            throw new RuntimeException("You can't add nulled content limit");
        if (lengthLimit == null)
            throw new RuntimeException("You can't add nulled length limit");

        this.contentLimit = contentLimit;
        this.lengthLimit = lengthLimit;
    }

    public String generateValidContent()
    {
        if (this.contentLimit == null)
            throw new RuntimeException("You didn't specified content limit");
        if (this.lengthLimit == null)
            throw new RuntimeException("You didn't specified length limit");

        return this.lengthLimit.generateValid(this.contentLimit.generateValid());
    }
}
