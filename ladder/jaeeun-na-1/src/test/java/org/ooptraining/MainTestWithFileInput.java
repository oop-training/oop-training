package org.ooptraining;

import org.junit.jupiter.api.Test;
import org.ooptraining.io.FileInput;
import org.ooptraining.io.FileInputStandardOutput;
import org.ooptraining.io.IO;
import org.ooptraining.render.policy.OneLineRenderPolicy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTestWithFileInput {
    @Test
    void file_test() {
        //given
        final OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        final FileInput input = FileInput.of("src/test/resources/test.txt");
        final IO io = new FileInputStandardOutput(input);

        //when
        Main.run(new OneLineRenderPolicy(), io);

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
        io.close();
    }
}
