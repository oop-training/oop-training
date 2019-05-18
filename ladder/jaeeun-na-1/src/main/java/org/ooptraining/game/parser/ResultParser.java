package org.ooptraining.game.parser;

import org.ooptraining.game.GameContext;
import org.ooptraining.game.Parser;

public class ResultParser implements Parser {
    @Override
    public void parse(final String line, final GameContext.Builder builder) {
        final String[] split = line.split("[,]");

        for (final String result : split) {
            builder.addResult(result);
        }
    }
}
