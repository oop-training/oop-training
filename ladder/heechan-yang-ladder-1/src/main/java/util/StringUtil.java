package util;

public class StringUtil {
    public static String getSequencedString(String c, int intervalWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < intervalWidth; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
