package org.ooptraining.setting.parser;

import org.ooptraining.setting.GameContext;
import org.ooptraining.setting.Parser;

public class ResultParser implements Parser {
    @Override
    public void parse(final String line, final GameContext.Builder builder) {
        final String[] split = line.split("[,]");

        for (final String result : split) {
            builder.addResult(result);
        }
    }
}
