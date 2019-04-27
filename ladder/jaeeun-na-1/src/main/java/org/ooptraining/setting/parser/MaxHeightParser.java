package org.ooptraining.setting.parser;

import org.ooptraining.setting.SettingContext;
import org.ooptraining.setting.Parser;

public class MaxHeightParser implements Parser {
    @Override
    public void parse(final String line, final SettingContext.Builder builder) {
        final int maxHeight = Integer.parseInt(line);

        builder.maxHeight(maxHeight);
    }
}