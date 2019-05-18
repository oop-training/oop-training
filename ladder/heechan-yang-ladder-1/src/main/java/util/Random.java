package util;

public class Random {
    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static boolean[][] getRandomLadder(int count, int height) {
        boolean[][] isHorizontalBars = new boolean[height][count - 1];

        for (int i = 0; i < isHorizontalBars.length; i++) {
            for (int j = 0; j < isHorizontalBars[0].length; j++) {
                isHorizontalBars[i][j] = Random.getRandomBoolean();

                // 가로줄이 연속으로 있으면 안됨
                if (isHorizontalBars[i][j]) {
                    j++;
                }
            }
        }

        return isHorizontalBars;
    }
}
