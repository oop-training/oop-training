package util;

import vo.Node;

import java.util.*;

public class RenderUtil {
    private static final int PADDING = 3;
    private static final String VERTICAL_BAR = "|";
    private static final String HORIZONTAL_BAR = "-";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void drawGame(Ladder ladder) {

        int maxIntervalWidth = Math.max(getIntervalWidth(ladder.getPeople()), getIntervalWidth(ladder.getRewards()));

        drawNodes(ladder.getPeople(), maxIntervalWidth);

        drawLadders(ladder.getIsConnectedMatrix(), maxIntervalWidth);

        drawNodes(ladder.getRewards(), maxIntervalWidth);
    }

    private static <T extends Node> int getIntervalWidth(List<T> nodeList) {
        T node = Collections.max(nodeList, Comparator.comparingInt(o -> o.getName().length()));

        return node.getName().length() + PADDING;
    }

    private static void drawLadders(boolean[][] isConnectedMatrix, int intervalWidth) {
        StringBuilder sb = new StringBuilder();

        for (boolean[] isConnectedArray : isConnectedMatrix) {
            sb.append(getLadderLine(isConnectedArray, intervalWidth));
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    private static String getLadderLine(boolean[] isConnectedArray, int intervalWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL_BAR);

        for (boolean isConnected : isConnectedArray) {
            if (isConnected) {
                sb.append(StringUtil.getSequencedString(HORIZONTAL_BAR, intervalWidth));
            } else {
                sb.append(StringUtil.getSequencedString(SPACE, intervalWidth));
            }
            sb.append(VERTICAL_BAR);
        }

        sb.append(NEW_LINE);

        return sb.toString();
    }

    private static <T extends Node> void drawNodes(List<T> nodes, int intervalWidth) {
        nodes.forEach(o -> System.out.printf("%-" + intervalWidth + "s", o.getName()));
        System.out.println();
    }
}
