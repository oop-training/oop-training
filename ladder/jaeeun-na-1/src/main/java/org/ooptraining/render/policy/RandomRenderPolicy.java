package org.ooptraining.render.policy;

import lombok.RequiredArgsConstructor;
import org.ooptraining.render.RenderContext;
import org.ooptraining.render.RenderPolicy;
import org.ooptraining.game.GameContext;

import static org.ooptraining.util.CommonUtils.not;
import static org.ooptraining.util.RenderUtils.renderParticipants;
import static org.ooptraining.util.RenderUtils.renderResult;
import static org.ooptraining.util.StringUtils.*;

@RequiredArgsConstructor(staticName = "of")
public class RandomRenderPolicy implements RenderPolicy {
    private final RandomBoolean random;
    private boolean isPreviousHorizontalLineRendered = false;

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
        if (random.nextBoolean() && not(isPreviousHorizontalLineRendered)) {
            isPreviousHorizontalLineRendered = true;
            lastGameContext = lastGameContext.toSwap(index, index + 1);
            return line(renderContext.getIntervalWidth());
        }
        isPreviousHorizontalLineRendered = false;
        return padding(renderContext.getIntervalWidth());
    }
}
