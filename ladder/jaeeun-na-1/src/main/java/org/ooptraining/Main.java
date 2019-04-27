package org.ooptraining;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Log
public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final List<String> messages = Arrays.asList(
                "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
                "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)",
                "최대 사다리 높이는 몇 개인가요?\n"
        );
        final List<String> resultMessages = Arrays.asList(
                "사다리 결과",
                "pobi    honux   crong   jk\n" +
                        "|-------|       |-------|\n" +
                        "|       |-------|       |\n" +
                        "|-------|       |       |\n" +
                        "|       |-------|       |\n" +
                        "|-------|       |-------|\n" +
                        "꽝       5000    꽝      3000\n"
        );
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
        final List<String> container = new ArrayList<>();


        messages.forEach(message -> {
            System.out.println(message);

            final String input = sc.nextLine();
            container.add(input);
        });
        resultMessages.forEach(m -> {
            System.out.println(m);
        });

        int i = 0;
        while (true) {
            for (String m : queryMessages) {
                System.out.println(m);
                final String input = sc.nextLine();
                log.info(">>> " + input);
                if (input.equalsIgnoreCase("!bye")) {
                    System.out.print("bye!");
                    return;
                }
                System.out.println("실행 결과");
                System.out.println(queryResponse.get(i++));
            }
        }
    }
}
