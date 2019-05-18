package org.ooptraining;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.render.policy.OneLineRenderPolicy;

import java.io.OutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ooptraining.util.IOUtils.simulateStandardInputOutput;

@DisplayName("Ladder Program")
class MainTest {
    @Test
    @DisplayName("should satisfy requirements")
    void total_test_1() {
        //given
        final String input = "pobi,honux,crong,jk\n" +
                "X,5000,X,3000\n" +
                "5\n" +
                "pobi\n" +
                "jk\n" +
                "@all\n" +
                "@bye";
        final OutputStream out = simulateStandardInputOutput(input);

        //when
        Main.run(new OneLineRenderPolicy());

        //then
        final String expected = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n" +
                "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n" +
                "최대 사다리 높이는 몇 개인가요?\n" +
                "\n" +
                "사다리 결과\n" +
                "pobi    honux   crong   jk\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "X       5000    X       3000\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "X\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "3000\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "pobi : X\n" +
                "honux : 5000\n" +
                "crong : X\n" +
                "jk : 3000\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "bye!\n";


        assertThat(out.toString()).isEqualTo(expected);
    }

    @Test
    @DisplayName("should satisfy requirements 2")
    void total_test_2() {
        //given
        final String input = "a,b,c,d,e\n" +
                "1,2,3,4,5\n" +
                "3\n" +
                "b\n" +
                "e\n" +
                "@ALL\n" +
                "a\n" +
                "@bye";
        final OutputStream out = simulateStandardInputOutput(input);

        //when
        Main.run(new OneLineRenderPolicy());

        //then
        final String expected = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n" +
                "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n" +
                "최대 사다리 높이는 몇 개인가요?\n" +
                "\n" +
                "사다리 결과\n" +
                "a       b       c       d       e\n" +
                "|       |       |       |       |\n" +
                "|       |       |       |       |\n" +
                "|       |       |       |       |\n" +
                "1       2       3       4       5\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "2\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "5\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "a : 1\n" +
                "b : 2\n" +
                "c : 3\n" +
                "d : 4\n" +
                "e : 5\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "실행 결과\n" +
                "1\n" +
                "\n" +
                "결과를 보고 싶은 사람은?\n" +
                "bye!\n";


        assertThat(out.toString()).isEqualTo(expected);
    }

}