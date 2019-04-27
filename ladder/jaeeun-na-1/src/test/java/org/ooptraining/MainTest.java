package org.ooptraining;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {
    @Test
    void std_input_test1() {
        //given
        final String input = "pobi,honux,crong,jk";
        final OutputStream out = simulateStandardInputOutput(input);

        //when
        Main.main(null);

        //then
        final String expected = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n" +
                "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n" +
                "최대 사다리 높이는 몇 개인가요?\n";
        assertThat(out.toString()).isEqualTo(expected);
    }

    private OutputStream simulateStandardInputOutput(final String input) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(out));

        return out;
    }
}