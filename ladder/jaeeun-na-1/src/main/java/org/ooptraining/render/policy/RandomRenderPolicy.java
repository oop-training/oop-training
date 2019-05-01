package org.ooptraining.render.policy;

import lombok.RequiredArgsConstructor;
import org.ooptraining.model.Participant;
import org.ooptraining.render.RenderContext;
import org.ooptraining.render.RenderPolicy;
import org.ooptraining.game.GameContext;

import java.util.List;

import static org.ooptraining.util.StringUtils.*;

@RequiredArgsConstructor(staticName = "of")
public class RandomRenderPolicy implements RenderPolicy {
    private final RandomBoolean random;

    private GameContext lastGameContext;

    @Override
    public String render(final GameContext gameContext, final RenderContext renderContext) {
        return render(new StringBuilder(), gameContext, renderContext);
    }

    private String render(final StringBuilder builder, final GameContext gameContext, final RenderContext renderContext) {
        lastGameContext = gameContext;

        builder.append(renderParticipants(gameContext, renderContext));
        builder.append(blankLine());
        builder.append(renderLadders(gameContext, renderContext));
        builder.append(blankLine());
        builder.append(renderResult(lastGameContext, renderContext));

        return builder.toString().trim();
    }

    private static String blankLine() {
        return "\n";
    }

    private String renderParticipants(final GameContext gameContext, final RenderContext renderContext) {
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

    private String renderLadders(final GameContext gameContext, final RenderContext renderContext) {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < gameContext.getMaxHeight(); i++) {
            builder.append(renderLadderRow(gameContext, renderContext));
            builder.append("\n");
        }
        return builder.toString().trim();
    }

    private String renderLadderRow(final GameContext gameContext, final RenderContext renderContext) {
        final StringBuilder builder = new StringBuilder();
        final int numberOfParticipants = gameContext.getParticipants().size();

        for (int i = 0; i < numberOfParticipants - 1; i++) {
            builder.append(renderLadderCol(i, renderContext));
        }
        builder.append("|");
        return builder.toString().trim();
    }

    private String renderLadderCol(final int index, final RenderContext renderContext) {
        return "|" + paddingOrLine(index, renderContext);
    }

    private String paddingOrLine(final int index, final RenderContext renderContext) {
        if (random.nextBoolean()) {
            lastGameContext = lastGameContext.toSwap(index, index + 1);
            return line(renderContext.getIntervalWidth());
        }
        return padding(renderContext.getIntervalWidth());
    }

    private String renderResult(final GameContext gameContext, final RenderContext renderContext) {
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
