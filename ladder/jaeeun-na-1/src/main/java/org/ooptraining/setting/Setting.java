package org.ooptraining.setting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.ooptraining.setting.parser.MaxHeightParser;
import org.ooptraining.setting.parser.NameParser;
import org.ooptraining.setting.parser.ResultParser;

@Getter
@RequiredArgsConstructor
public enum Setting implements Parser {
    NAME(new NameParser(), "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    RESULT(new ResultParser(), "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
    MAX_HEIGHT(new MaxHeightParser(), "최대 사다리 높이는 몇 개인가요?");

    private final Parser parser;
    private final String inputMessages;

    public void parse(final String line, final SettingContext.Builder builder) {
        parser.parse(line, builder);
    }
}
