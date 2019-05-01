package org.ooptraining.util;

import org.ooptraining.game.GameContext;
import org.ooptraining.model.Participant;
import org.ooptraining.render.RenderContext;

import java.util.List;

import static org.ooptraining.util.StringUtils.*;

public class RenderUtils {
    public static String renderParticipants(final GameContext gameContext, final RenderContext renderContext) {
        final List<Participant> participants = gameContext.getParticipants();
        final StringBuilder builder = new StringBuilder();

        participants.forEach(participant -> {
            final String name = normalize(participant.getName(), renderContext.getMaxNameLength());
            final int remainPaddingSize = getRemainPadding(name, renderContext.getIntervalWidth() + 1);

            builder.append(name);
            builder.append(padding(remainPaddingSize));
        });
        builder.append("\n");

        return builder.toString().trim();
    }

    public static String renderResult(final GameContext gameContext, final RenderContext renderContext) {
        final List<Participant> participants = gameContext.getParticipants();
        final StringBuilder builder = new StringBuilder();

        participants.forEach(participant -> {
            final String result = normalize(participant.getResult(), renderContext.getMaxNameLength());
            final int remainPaddingSize = getRemainPadding(result, renderContext.getIntervalWidth() + 1);

            builder.append(result);
            builder.append(padding(remainPaddingSize));
        });

        return builder.toString().trim();
    }
}
