package org.ooptraining.query;

public interface QueryArgument {
    default String first() {
        throw new RuntimeException();
    }

    default String second() {
        throw new RuntimeException();
    }

    default String third() {
        throw new RuntimeException();
    }
}
