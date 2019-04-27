package org.ooptraining.util;

public class StringUtils {
    public static String padding(final int paddingSize) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paddingSize; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static int getRemainPadding(final String name, final int paddingLength) {
        return paddingLength - name.length();
    }

    public static String normalize(final String name, final int maxNameLength) {
        if (name.length() <= maxNameLength) {
            return name;
        }
        return name.substring(0, maxNameLength - 3) + "..";
    }
}
