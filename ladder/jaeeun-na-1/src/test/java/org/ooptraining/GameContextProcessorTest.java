package org.ooptraining;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.model.Participant;
import org.ooptraining.io.StandardInputOutput;
import org.ooptraining.game.GameContext;
import org.ooptraining.game.GameContextProcessor;
import org.ooptraining.game.Setting;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.ooptraining.util.IOUtils.simulateStandardInputOutput;

@DisplayName("GameContextProcessor")
class GameContextProcessorTest {
    @Test
    @DisplayName("should parse to parse name, result, and max-height for ladder")
    void should_generate_participants() {
        //given
        final String input = "a,b,c,d\n" +
                "꽝,성공,꽝,꽝\n" +
                "10\n";
        final List<Setting> settings = Arrays.asList(
                Setting.NAME,
                Setting.RESULT,
                Setting.MAX_HEIGHT
        );

        //when
        final OutputStream out = simulateStandardInputOutput(input);
        final GameContextProcessor processor = GameContextProcessor.of(new StandardInputOutput());
        final GameContext context = processor.run(settings);

        //then
        final String expectedOut =
                "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n" +
                        "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n" +
                        "최대 사다리 높이는 몇 개인가요?\n";
        final GameContext expectedContext = GameContext.builder()
                .participants(Arrays.asList(
                        Participant.of("a", "꽝"),
                        Participant.of("b", "성공"),
                        Participant.of("c", "꽝"),
                        Participant.of("d", "꽝")
                ))
                .maxHeight(10).build();

        assertThat(context).isEqualToComparingFieldByFieldRecursively(expectedContext);
        assertThat(out.toString()).isEqualTo(expectedOut);

    }

    @Test
    @DisplayName("should throw exception when name-result is not paired")
    void exception_when_not_paired() {
        //given
        final String input = "a,b,c,d\n" +
                "꽝,성공,꽝,꽝,뭐야이건\n" +
                "10\n";
        final List<Setting> settings = Arrays.asList(
                Setting.NAME,
                Setting.RESULT,
                Setting.MAX_HEIGHT
        );

        //when
        simulateStandardInputOutput(input);
        final GameContextProcessor processor = GameContextProcessor.of(new StandardInputOutput());

        //then
        assertThrows(IllegalStateException.class, () -> {
            processor.run(settings);
        });
    }
}