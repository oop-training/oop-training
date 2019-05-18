package util;

public class RandomLadderUtil {

    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static boolean[][] getRandomLadderHorizontalBar(int count, int height) {
        boolean[][] isHorizontalBars = new boolean[height][count - 1];

        for (int i = 0; i < isHorizontalBars.length; i++) {
            for (int j = 0; j < isHorizontalBars[0].length; j++) {
                if (isConnectedJustBefore(isHorizontalBars, i, j)) {
                    continue;
                }

                isHorizontalBars[i][j] = RandomLadderUtil.getRandomBoolean();
            }
        }

        return isHorizontalBars;
    }

    private static boolean isConnectedJustBefore(boolean[][] isHorizontalBars, int i, int j) {
        if (j < 1 || j > isHorizontalBars[0].length - 1) {
            return false;
        }

        return isHorizontalBars[i][j - 1];
    }
}
