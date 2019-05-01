package org.ooptraining.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.game.Participant;
import org.ooptraining.io.StandardInputOutput;
import org.ooptraining.game.GameContext;
import org.ooptraining.util.IOUtils;

import java.io.OutputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("QueryProcessor")
class QueryProcessorTest {
    @Test
    void run_test_1() {
        final String input =
                "name1\n" +
                        "name2\n" +
                        "name4\n" +
                        "name3\n" +
                        "name2\n" +
                        "name6\n" +
                        "@bye\n";
        final OutputStream output = IOUtils.simulateStandardInputOutput(input);

        final GameContext gameContext = GameContext.builder()
                .participants(Arrays.asList(
                        Participant.of("name1", "result1"),
                        Participant.of("name2", "result2"),
                        Participant.of("name3", "result3"),
                        Participant.of("name4", "result4"),
                        Participant.of("name5", "result5"),
                        Participant.of("name6", "result6")
                        )
                )
                .maxHeight(5).build();

        final QueryProcessor queryProcessor = QueryProcessor.of(new StandardInputOutput());

        queryProcessor.run(gameContext);

        final String expected =
                "결과를 보고 싶은 사람은?\n" +
                        "실행 결과\n" +
                        "result1\n\n" +
                        "결과를 보고 싶은 사람은?\n" +
                        "실행 결과\n" +
                        "result2\n\n" +
                        "결과를 보고 싶은 사람은?\n" +
                        "실행 결과\n" +
                        "result4\n\n" +
                        "결과를 보고 싶은 사람은?\n" +
                        "실행 결과\n" +
                        "result3\n\n" +
                        "결과를 보고 싶은 사람은?\n" +
                        "실행 결과\n" +
                        "result2\n\n" +
                        "결과를 보고 싶은 사람은?\n" +
                        "실행 결과\n" +
                        "result6\n\n" +
                        "결과를 보고 싶은 사람은?\n" +
                        "bye!\n";

        assertThat(output.toString()).isEqualTo(expected);
    }
}