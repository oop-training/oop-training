package org.ooptraining.game.parser;

import org.ooptraining.game.GameContext;
import org.ooptraining.game.Parser;

public class NameParser implements Parser {
    @Override
    public void parse(final String line, final GameContext.Builder builder) {
        final String[] split = line.split("[,]");

        for (final String name : split) {
            builder.addName(name);
        }
    }
}
