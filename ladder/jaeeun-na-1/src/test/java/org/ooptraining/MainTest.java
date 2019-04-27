package org.ooptraining;

import org.junit.jupiter.api.Test;

import java.io.OutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ooptraining.util.IOUtils.simulateStandardInputOutput;

public class MainTest {
    @Test
    void std_input_test1() {
        //given
        final String input = "pobi,honux,crong,jk\n" +
                "꽝,5000,꽝,3000\n" +
                "5\n" +
                "pobi\n" +
                "all\n" +
                "!bye";
        final OutputStream out = simulateStandardInputOutput(input);

        //when
        Main.main(null);

        //then
        final String expected = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n" +
                "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n" +
                "최대 사다리 높이는 몇 개인가요?\n" +
                "\n" +
                "사다리 결과\n" +
                "pobi    honux   crong   jk\n" +
                "|-------|       |-------|\n" +
                "|       |-------|       |\n" +
                "|-------|       |       |\n" +
                "|       |-------|       |\n" +
                "|-------|       |-------|\n" +
                "꽝       5000    꽝      3000\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "꽝\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "pobi : 꽝\n" +
                "honux : 3000\n" +
                "crong : 꽝\n" +
                "jk : 5000\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "bye!\n";


        assertThat(out.toString()).isEqualTo(expected);
    }

}