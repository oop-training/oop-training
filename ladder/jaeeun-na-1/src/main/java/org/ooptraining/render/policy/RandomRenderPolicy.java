package org.ooptraining.render.policy;

import lombok.RequiredArgsConstructor;
import org.ooptraining.Participant;
import org.ooptraining.render.RenderContext;
import org.ooptraining.render.RenderPolicy;
import org.ooptraining.setting.SettingContext;

import java.util.List;

import static org.ooptraining.util.StringUtils.*;

@RequiredArgsConstructor(staticName = "of")
public class RandomRenderPolicy implements RenderPolicy {
    private final RandomBoolean random;

    private SettingContext lastSettingContext;

    @Override
    public String render(final SettingContext settingContext, final RenderContext renderContext) {
        return render(new StringBuilder(), settingContext, renderContext);
    }

    private String render(final StringBuilder builder, final SettingContext settingContext, final RenderContext renderContext) {
        lastSettingContext = settingContext;

        builder.append(renderParticipants(settingContext, renderContext));
        builder.append(blankLine());
        builder.append(renderLadders(settingContext, renderContext));
        builder.append(blankLine());
        builder.append(renderResult(lastSettingContext, renderContext));

        return builder.toString().trim();
    }

    private static String blankLine() {
        return "\n";
    }

    private String renderParticipants(final SettingContext settingContext, final RenderContext renderContext) {
        final List<Participant> participants = settingContext.getParticipants();
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

    private String renderLadders(final SettingContext settingContext, final RenderContext renderContext) {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < settingContext.getMaxHeight(); i++) {
            builder.append(renderLadderRow(settingContext, renderContext));
            builder.append("\n");
        }
        return builder.toString().trim();
    }

    private String renderLadderRow(final SettingContext settingContext, final RenderContext renderContext) {
        final StringBuilder builder = new StringBuilder();
        final int numberOfParticipants = settingContext.getParticipants().size();

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
            lastSettingContext = lastSettingContext.toSwap(index, index + 1);
            return line(renderContext.getIntervalWidth());
        }
        return padding(renderContext.getIntervalWidth());
    }

    private String renderResult(final SettingContext settingContext, final RenderContext renderContext) {
        final List<Participant> participants = settingContext.getParticipants();
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
