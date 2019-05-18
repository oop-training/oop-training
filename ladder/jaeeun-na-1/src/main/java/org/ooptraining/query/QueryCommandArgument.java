package org.ooptraining.query;

import org.ooptraining.exception.IllegalQueryCommandArgumentException;

public interface QueryCommandArgument {
    default String first() {
        throw new IllegalQueryCommandArgumentException();
    }

    default String second() {
        throw new IllegalQueryCommandArgumentException();
    }

    default String third() {
        throw new IllegalQueryCommandArgumentException();
    }
}
