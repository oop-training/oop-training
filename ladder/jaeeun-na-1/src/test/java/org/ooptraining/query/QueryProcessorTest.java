package org.ooptraining.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.ooptraining.setting.SettingContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ooptraining.util.StringUtils.makeFullResultWithNameAndResult;

@DisplayName("QueryProcessor")
class QueryProcessorTest {
    private static final String source1 = "org.ooptraining.util.dummy.data.SettingContextDummys#data1";

    @Nested
    @DisplayName("can handle")
    class Handle {

        @DisplayName("SHOW_ALL command")
        @ParameterizedTest(name = "{arguments}-{index}")
        @MethodSource(source1)
        void query_test_1(final SettingContext settingContext) {
            final QueryProcessor queryProcessor = QueryProcessor.of(settingContext);

            final QueryResult queryResult = queryProcessor.execute(QueryCommand.SHOW_ALL);

            final String expected = makeFullResultWithNameAndResult(settingContext);
            assertThat(queryResult.asString()).isEqualTo(expected);
        }
    }
}