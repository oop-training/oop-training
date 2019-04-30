package org.ooptraining.query;

import org.ooptraining.io.Stringifiable;

public class QueryResult implements Stringifiable {
    @Override
    public String asString() {
        return  "abcd : 1234\n" +
                "efgh : 5678\n" +
                "hello : world";
    }
}
