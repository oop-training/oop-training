package util;

import lombok.Getter;
import util.io.StandardInputUtil;
import util.io.StandardOutputUtil;
import vo.Person;
import vo.Reward;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Ladder {
    private static final String ORDER_EXIT = "exit";

    private StandardInputUtil standardInputUtil;
    private StandardOutputUtil standardOutputUtil;

    private List<Person> people;
    private List<Reward> rewards;
    private int intervalWidth;
    private int height;
    private boolean[][] isConnectedMatrix;

    public Ladder() {
        this.standardInputUtil = new StandardInputUtil();
        this.standardOutputUtil = new StandardOutputUtil();
    }

    public void play() {
        inputsForStart();

        draw();

        inputForResult();
    }

    // 추상화레벨을 맞춰야할 듯 싶어서 메서드를 생성했는데, 굳이 필요할까?
    private void draw() {
        RenderUtil.drawGame(this);
    }

    private void inputsForStart() {
        this.people = standardInputUtil.inputPeople();
        this.rewards = standardInputUtil.inputRewards();
        this.height = standardInputUtil.inputHeight();

        this.isConnectedMatrix = RandomLadderUtil.getRandomLadderHorizontalBar(people.size(), this.height);

        setResults();
    }

    private void inputForResult() {
        String target = standardInputUtil.inputTarget();

        while (!target.equals(ORDER_EXIT)) {
            standardOutputUtil.printResult(people, target);

            target = standardInputUtil.inputTarget();
        }
    }

    private void setResults() {
        for (int i = 0; i < people.size(); i++) {
            Person tempPerson = people.get(i);
            Reward tempReward = rewards.get(i);
            tempPerson.setReward(tempReward);
        }

        for (boolean[] isConnectedArray : isConnectedMatrix) {
            for (int j = 0; j < isConnectedArray.length; j++) {
                Person person1 = people.get(j);
                Person person2 = people.get(j + 1);
                if (isConnectedArray[j]) {
                    person1.swapWith(person2);
                }
            }
        }
    }
}
