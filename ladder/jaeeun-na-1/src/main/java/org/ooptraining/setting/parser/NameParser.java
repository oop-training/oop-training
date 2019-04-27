package org.ooptraining.setting.parser;

import org.ooptraining.setting.SettingContext;
import org.ooptraining.Parser;

public class NameParser implements Parser {
    @Override
    public void handle(final String line, final SettingContext.Builder builder) {
        final String[] split = line.split("[,]");

        for (final String name : split) {
            builder.addName(name);
        }
    }
}
