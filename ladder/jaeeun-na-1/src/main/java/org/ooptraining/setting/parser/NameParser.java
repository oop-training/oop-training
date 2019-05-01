package org.ooptraining.setting.parser;

import org.ooptraining.setting.GameContext;
import org.ooptraining.setting.Parser;

public class NameParser implements Parser {
    @Override
    public void parse(final String line, final GameContext.Builder builder) {
        final String[] split = line.split("[,]");

        for (final String name : split) {
            builder.addName(name);
        }
    }
}
