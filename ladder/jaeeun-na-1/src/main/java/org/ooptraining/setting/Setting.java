package org.ooptraining.setting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ooptraining.setting.parser.MaxHeightParser;
import org.ooptraining.setting.parser.NameParser;
import org.ooptraining.setting.parser.ResultParser;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Setting implements Parser {
    private final Type type;
    private final String inputMessages;

    public void parse(final String line, final SettingContext.Builder builder) {
        type.parser.parse(line, builder);
    }

    @RequiredArgsConstructor
    public enum Type {
        NAME(new NameParser()),
        RESULT(new ResultParser()),
        MAX_HEIGHT(new MaxHeightParser());

        private final Parser parser;
    }
}
