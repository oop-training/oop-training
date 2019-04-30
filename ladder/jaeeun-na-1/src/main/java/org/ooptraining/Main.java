package org.ooptraining;

import lombok.extern.java.Log;
import org.ooptraining.render.RenderContext;
import org.ooptraining.render.RenderPolicy;
import org.ooptraining.render.Renderer;
import org.ooptraining.setting.Setting;
import org.ooptraining.setting.SettingContext;
import org.ooptraining.setting.SettingProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Log
public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        // TODO: input, output을 injection
        //  반드시 stdin,out말고 file이나 http call 일 수도 있음.
        //  인터페이스 정의한 뒤 삽입
        final SettingProcessor settingProcessor = SettingProcessor.of(sc);
        final SettingContext settingContext = settingProcessor.run(Arrays.asList(
                Setting.NAME,
                Setting.RESULT,
                Setting.MAX_HEIGHT
        ));

        System.out.println();
        System.out.println("사다리 결과");
        final RenderContext renderContext = RenderContext.builder()
                .intervalWidth(7)
                .maxNameLength(7)
                .build();
        final Renderer renderer = Renderer.of(RenderPolicy.DEFAULT);
        final String renderResult = renderer.render(settingContext, renderContext);
        System.out.println(renderResult);
        System.out.println();

        final List<String> queryMessages = Arrays.asList(
                "결과를 보고 싶은 사람은?"
        );
        final List<String> queryResponse = Arrays.asList(
                "꽝\n",
                "pobi : 꽝\n" +
                        "honux : 3000\n" +
                        "crong : 꽝\n" +
                        "jk : 5000\n"
        );
        // TODO: 마지막 사용자 query받는 부분 설계 및 구현
        int i = 0;
        while (true) {
            for (String m : queryMessages) {
                System.out.println(m);
                final String input = sc.nextLine();
                if (input.equalsIgnoreCase("!bye")) {
                    System.out.println("bye!");
                    return;
                }
                System.out.println("실행 결과");
                System.out.println(queryResponse.get(i++));
            }
        }

        // TODO: 마무리 정리 작업 (메시징, 코드 이름, ...)
    }
}
