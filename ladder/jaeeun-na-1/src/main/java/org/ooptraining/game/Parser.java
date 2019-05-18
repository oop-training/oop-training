package org.ooptraining.game;

public interface Parser {
    void parse(final String line, final GameContext.Builder builder);
}
