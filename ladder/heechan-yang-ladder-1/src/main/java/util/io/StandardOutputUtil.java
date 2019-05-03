package util.io;

import vo.Person;

import java.util.List;
import java.util.Optional;

public class StandardOutputUtil implements OutputUtil {

    @Override
    public void printResult(List<Person> people, String target) {
        System.out.println("실행결과");

        if (target.equals("all")) {
            printAllResult(people);
        } else {
            Optional<Person> personOptional
                    = people.stream().filter(p -> p.getName().equals(target)).findAny();

            if(personOptional.isPresent()) {
                printEachResult(personOptional.get());
            }else{
                printNoManExist();
            }
        }
    }

    @Override
    public void printAllResult(List<Person> people) {
        for (Person person : people) {
            printEachResult(person);
        }
    }

    @Override
    public void printEachResult(Person person) {

        System.out.println(String.format("%s : %s", person.getName(), person.getReward().getName()));
    }

    @Override
    public void printNoManExist() {
        System.out.println(OutputNoticeText.TEXT_OUTPUT_NOT_EXIST_PEOPLE);
    }

}
