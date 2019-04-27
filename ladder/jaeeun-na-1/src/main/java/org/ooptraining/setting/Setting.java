package org.ooptraining.setting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ooptraining.Parser;
import org.ooptraining.setting.parser.MaxHeightParser;
import org.ooptraining.setting.parser.NameParser;
import org.ooptraining.setting.parser.ResultParser;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Setting {
    private final Type type;
    private final String inputMessages;

    public void handle(final String line, final SettingContext.Builder builder) {
        type.parser.handle(line, builder);
    }

    @RequiredArgsConstructor
    public enum Type {
        NAME(new NameParser()),
        RESULT(new ResultParser()),
        MAX_HEIGHT(new MaxHeightParser());

        private final Parser parser;
    }
}
