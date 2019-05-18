package util;

import java.util.Scanner;
import java.util.StringTokenizer;

public class InputUtil {
    public static final String DELIM = ",";

    private final Scanner sc;

    public InputUtil() {
        sc = new Scanner(System.in);
    }

    public String[] inputPeople() {
        System.out.println(Constants.TEXT_INPUT_PEOPLE);

        return split(sc.nextLine(), DELIM);
    }

    public String[] inputResults() {
        System.out.println(Constants.TEXT_INPUT_RESULTS);

        return split(sc.nextLine(), DELIM);
    }

    public int inputHeight() {
        System.out.println(Constants.TEXT_INPUT_HEIGHT);

        return Integer.parseInt(sc.nextLine());
    }

    public String inputTarget() {
        System.out.println(Constants.TEXT_INPUT_TARGET);

        return sc.nextLine();
    }

    private String[] split(String str, String delim) {
        StringTokenizer st = new StringTokenizer(str, delim);

        String[] tokens = new String[st.countTokens()];

        for (int i = 0; i < tokens.length; ++i) {
            tokens[i] = st.nextToken();
        }

        return tokens;
    }
}
