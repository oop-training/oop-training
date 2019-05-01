package org.ooptraining.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.ooptraining.exception.IllegalQueryCommandException;
import org.ooptraining.query.argument.ShowQueryCommandArgument;
import org.ooptraining.setting.SettingContext;
import org.ooptraining.util.dummy.data.SettingContextDummys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.ooptraining.util.StringUtils.makeFullResultWithNameAndResult;

@DisplayName("QueryCommand")
class QueryCommandTest {
    @Nested
    @DisplayName("can handle")
    class Handle {

        @DisplayName("SHOW_ALL command")
        @ParameterizedTest(name = "[{index}]-{arguments}")
        @MethodSource("org.ooptraining.util.dummy.data.SettingContextDummys#data1")
        void query_test_show_all_command(final SettingContext settingContext) {
            final QueryResult queryResult = QueryCommand.SHOW_ALL.execute(settingContext);

            final String expected = makeFullResultWithNameAndResult(settingContext);
            assertThat(queryResult.asString()).isEqualTo(expected);
        }

        @DisplayName("SHOW command (specific name-result)")
        @ParameterizedTest(name = "[{index}]-{arguments}")
        @MethodSource("org.ooptraining.util.dummy.data.SettingContextDummys#participantList_queryName_expectedResult")
        void query_test_show_command(final SettingContext settingContext, final String queryName, final String expectedResult) {
            final QueryCommandArgument queryCommandArgument = ShowQueryCommandArgument.of(queryName);

            final QueryResult queryResult = QueryCommand.SHOW.execute(settingContext, queryCommandArgument);

            assertThat(queryResult.asString()).isEqualTo(expectedResult);
        }
    }

    @Nested
    @DisplayName("should throw exception")
    class ThrowException {

        @Test
        @DisplayName("when execute UNKNOWN command")
        void wrong_command() {
            final SettingContext settingContext = SettingContextDummys.simpleOne();

            assertThrows(IllegalQueryCommandException.class, () -> {
                QueryCommand.UNKNOWN.execute(settingContext);
            });
        }
    }
}