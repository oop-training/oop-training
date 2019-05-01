package org.ooptraining.util;

import org.ooptraining.Participant;
import org.ooptraining.game.GameContext;

import static java.text.MessageFormat.format;

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

    public static String makeFullResultWithNameAndResult(final GameContext gameContext) {
        final StringBuilder sb = new StringBuilder();

        gameContext.getParticipants().forEach(p -> {
            sb.append(makeResultWithNameAndResult(p));
            sb.append("\n");
        });

        return sb.toString().trim();
    }

    public static String makeResultWithNameAndResult(final Participant participant) {
        return format("{0} : {1}", participant.getName(), participant.getResult());
    }

    private static String generate(final int size, final char ch) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
