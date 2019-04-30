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

@DisplayName("QueryProcessor")
class QueryProcessorTest {
    @Nested
    @DisplayName("can handle")
    class Handle {

        @DisplayName("SHOW_ALL command")
        @ParameterizedTest(name = "[{index}]-{arguments}")
        @MethodSource("org.ooptraining.util.dummy.data.SettingContextDummys#data1")
        void query_test_show_all_command(final SettingContext settingContext) {
            final QueryProcessor queryProcessor = QueryProcessor.of(settingContext);

            final QueryResult queryResult = queryProcessor.execute(QueryCommand.SHOW_ALL);

            final String expected = makeFullResultWithNameAndResult(settingContext);
            assertThat(queryResult.asString()).isEqualTo(expected);
        }

        @DisplayName("SHOW command (specific name-result)")
        @ParameterizedTest(name = "[{index}]-{arguments}")
        @MethodSource("org.ooptraining.util.dummy.data.SettingContextDummys#participantList_queryName_expectedResult")
        void query_test_show_command(final SettingContext settingContext, final String queryName, final String expectedResult) {
            final QueryProcessor queryProcessor = QueryProcessor.of(settingContext);
            final QueryArgument queryArgument = ShowQueryCommandArgument.of(queryName);

            final QueryResult queryResult = queryProcessor.execute(QueryCommand.SHOW, queryArgument);

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
            final QueryProcessor queryProcessor = QueryProcessor.of(settingContext);

            assertThrows(IllegalQueryCommandException.class, () -> {
                queryProcessor.execute(QueryCommand.UNKNOWN);
            });
        }

//        @Test
//        @DisplayName("when execute valid command with wrong query arguments")
//        void valid_command_with_wrong_query_arguments() {
//            final SettingContext settingContext = SettingContextDummys.simpleOne();
//            final QueryProcessor queryProcessor = QueryProcessor.of(settingContext);
//
//            assertThrows(IllegalArgumentException.class, () -> {
//                queryProcessor.execute(QueryCommand.SHOW, null);
//            });
//        }
    }
}