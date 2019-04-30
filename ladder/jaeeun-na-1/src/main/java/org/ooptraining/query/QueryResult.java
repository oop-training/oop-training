package org.ooptraining.query;

import org.ooptraining.io.Stringifiable;

public class QueryResult implements Stringifiable {
    private final String result;

    public QueryResult(final String result) {
        this.result = result;
    }

    @Override
    public String asString() {
        return result;
    }
}
