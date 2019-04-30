package org.ooptraining.query;

import org.junit.jupiter.api.Test;
import org.ooptraining.Participant;
import org.ooptraining.setting.SettingContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class QueryProcessorTest {
    @Test
    void query_test_1() {
        final SettingContext context = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("abcd", "1234"),
                        Participant.of("efgh", "5678"),
                        Participant.of("hello", "world")
                        )
                )
                .maxHeight(5).build();
        final QueryProcessor queryProcessor = QueryProcessor.of(context);


        final QueryResult queryResult = queryProcessor.execute(QueryCommand.SHOW_ALL);


        final String expected = "abcd : 1234\n" +
                "efgh : 5678\n" +
                "hello : world";
        assertThat(queryResult.asString()).isEqualTo(expected);
    }
}