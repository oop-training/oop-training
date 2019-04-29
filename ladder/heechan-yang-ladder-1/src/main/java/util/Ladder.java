package util;

import java.util.HashMap;
import java.util.Map;

public class Ladder {
    private InputUtil inputUtil;
    private OutputUtil outputUtil;
    private RenderUtil renderUtil;

    private String[] people;
    private String[] rewards;
    private int height;
    private boolean[][] isConnectedMatrix;

    private Map<String, String> resultMap;

    public Ladder() {
        this.inputUtil = new InputUtil();
        this.outputUtil = new OutputUtil();
        this.renderUtil = new RenderUtil();
    }

    public void play() {
        inputsForGame();

        renderUtil.drawGame(people, rewards, isConnectedMatrix);

        inputForResult();
    }

    private void inputsForGame() {
        this.people = inputUtil.inputPeople();
        this.rewards = inputUtil.inputResults();
        this.height = inputUtil.inputHeight();

        this.isConnectedMatrix = Random.getRandomLadder(people.length, this.height);

        this.resultMap = getResultMap(people, rewards, isConnectedMatrix);
    }

    private void inputForResult() {
        String target = inputUtil.inputTarget();

        while (!target.equals(Constants.TEXT_EXIT)) {
            outputUtil.printResult(people, resultMap, target);

            target = inputUtil.inputTarget();
        }
    }

    private Map<String, String> getResultMap(String[] people, String[] rewards, boolean[][] isConnectedMatrix) {
        int[] results = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            results[i] = i;
        }

        for (boolean[] isConnectedArray : isConnectedMatrix) {
            for (int j = 0; j < isConnectedArray.length; j++) {
                if (isConnectedArray[j]) {
                    swap(results, j, j + 1);
                }
            }
        }

        Map<String, String> resultMap = new HashMap<>();

        for (int i = 0; i < people.length; i++) {
            resultMap.put(people[results[i]], rewards[i]);
        }

        return resultMap;
    }

    private void swap(int[] results, int index1, int index2) {
        int temp = results[index1];
        results[index1] = results[index2];
        results[index2] = temp;
    }
}
