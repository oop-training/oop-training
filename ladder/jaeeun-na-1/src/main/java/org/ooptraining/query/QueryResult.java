package org.ooptraining.query;

import org.ooptraining.io.Stringifiable;

import java.util.Objects;

public class QueryResult implements Stringifiable {
    private final String result;
    private final String invalidMessage;

    public QueryResult(final String result) {
        this.result = result;
        invalidMessage = "";
    }

    public QueryResult(final String result, final String invalidMessage) {
        this.result = result;
        this.invalidMessage = invalidMessage;
    }

    @Override
    public String asString() {
        if (Objects.isNull(result)) {
            return invalidMessage;
        }

        return result;
    }
}
