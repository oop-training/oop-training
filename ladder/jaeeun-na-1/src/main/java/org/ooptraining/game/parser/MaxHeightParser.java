package org.ooptraining.game.parser;

import org.ooptraining.game.GameContext;
import org.ooptraining.game.Parser;

public class MaxHeightParser implements Parser {
    @Override
    public void parse(final String line, final GameContext.Builder builder) {
        final int maxHeight = Integer.parseInt(line);

        builder.maxHeight(maxHeight);
    }
}
