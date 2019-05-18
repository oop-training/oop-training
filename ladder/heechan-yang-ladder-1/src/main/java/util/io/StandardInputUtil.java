package util.io;

import vo.Node;
import vo.Person;
import vo.Reward;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StandardInputUtil implements InputUtil {
    public static final String INPUT_DELIM = ",";

    private final Scanner sc = new Scanner(System.in);

    @Override
    public List<Person> inputPeople() {
        System.out.println(InputNoticeText.TEXT_INPUT_PEOPLE);

        String[] splitted = sc.nextLine().split(INPUT_DELIM);

        return Arrays.stream(splitted)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reward> inputRewards() {
        System.out.println(InputNoticeText.TEXT_INPUT_RESULTS);

        String[] splitted = sc.nextLine().split(INPUT_DELIM);

        return Arrays.stream(splitted)
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    @Override
    public int inputHeight() {
        System.out.println(InputNoticeText.TEXT_INPUT_HEIGHT);

        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public String inputTarget() {
        System.out.println(InputNoticeText.TEXT_INPUT_TARGET);

        return sc.nextLine();
    }
}
