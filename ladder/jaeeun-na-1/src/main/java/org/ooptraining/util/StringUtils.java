package org.ooptraining.util;

public class StringUtils {
    public static String padding(final int paddingSize) {
        return generate(paddingSize, ' ');
    }

    public static String line(final int paddingSize) {
        return generate(paddingSize, '-');
    }

    public static int getRemainPadding(final String name, final int paddingLength) {
        return paddingLength - name.length();
    }

    public static String normalize(final String name, final int maxNameLength) {
        if (name.length() <= maxNameLength) {
            return name;
        }
        return name.substring(0, maxNameLength - 2) + "..";
    }

    private static String generate(final int size, final char ch) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
