package org.ooptraining.setting.parser;

import org.ooptraining.setting.SettingContext;
import org.ooptraining.Parser;

public class ResultParser implements Parser {
    @Override
    public void handle(final String line, final SettingContext.Builder builder) {
        final String[] split = line.split("[,]");

        for (final String result : split) {
            builder.addResult(result);
        }
    }
}
