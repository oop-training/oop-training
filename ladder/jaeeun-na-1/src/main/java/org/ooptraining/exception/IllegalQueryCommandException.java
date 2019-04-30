package org.ooptraining.exception;

import org.ooptraining.query.QueryCommand;

import static java.text.MessageFormat.format;

public class IllegalQueryCommandException extends RuntimeException {
    private static final String message = "Illegal Query Command";

    public IllegalQueryCommandException(final QueryCommand queryCommand) {
        super(format("{0} > {1}", message, queryCommand));
    }

    public IllegalQueryCommandException() {
        super(message);
    }
}
