package util;

public class RenderUtil {
    private static final int PADDING = 3;
    private static final char VERTICAL_BAR = '|';
    private static final char HORIZONTAL_BAR = '-';
    private static final char SPACE = ' ';
    private static final char NEW_LINE = '\n';

    public void drawGame(String[] people, String[] rewards, boolean[][] isConnected) {
        int eachWidth = getEachWidth(people, rewards);

        drawPeople(people, eachWidth);

        drawLadders(isConnected, eachWidth);

        drawRewards(rewards, eachWidth);
    }

    private int getEachWidth(String[] people, String[] rewards) {
        int maxWidth = 0;
        for (int i = 0; i < people.length; i++) {
            maxWidth = Math.max(maxWidth, people[i].length());
            maxWidth = Math.max(maxWidth, rewards[i].length());
        }
        return maxWidth + PADDING;
    }

    private void drawPeople(String[] people, int eachWidth) {
        drawEach(people, eachWidth);
    }

    private void drawLadders(boolean[][] isConnectedMatrix, int eachWidth) {
        StringBuilder sb = new StringBuilder();

        String horizontalBar = getHorizontalPrint(HORIZONTAL_BAR, eachWidth);
        String space = getHorizontalPrint(SPACE, eachWidth);

        for (boolean[] isConnectedArray : isConnectedMatrix) {
            sb.append(VERTICAL_BAR);

            for (boolean isConnected : isConnectedArray) {
                if (isConnected) {
                    sb.append(horizontalBar);
                } else {
                    sb.append(space);
                }
                sb.append(VERTICAL_BAR);
            }

            sb.append(NEW_LINE);
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private String getHorizontalPrint(char c, int eachWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < eachWidth; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void drawRewards(String[] rewards, int eachWidth) {
        drawEach(rewards, eachWidth);
    }

    private void drawEach(String[] strings, int eachWidth) {
        for (String str : strings) {
            System.out.printf("%-" + eachWidth + "s", str);
        }
        System.out.println();
    }
}
