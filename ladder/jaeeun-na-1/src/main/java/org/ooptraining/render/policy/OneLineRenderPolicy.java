package org.ooptraining.render.policy;

import org.ooptraining.Participant;
import org.ooptraining.render.RenderContext;
import org.ooptraining.render.RenderPolicy;
import org.ooptraining.setting.SettingContext;

import java.util.List;

import static org.ooptraining.util.StringUtils.*;

public class OneLineRenderPolicy implements RenderPolicy {
    @Override
    public String render(final SettingContext settingContext, final RenderContext renderContext) {
        return render(new StringBuilder(), settingContext, renderContext);
    }

    private String render(final StringBuilder builder, final SettingContext settingContext, final RenderContext renderContext) {
        builder.append(renderParticipants(settingContext, renderContext));
        builder.append("\n");
        builder.append(renderLadders(settingContext, renderContext));
        builder.append("\n");
        builder.append(renderResult(settingContext, renderContext));

        return builder.toString().trim();
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
            builder.append(renderLadderCol(renderContext));
        }
        builder.append("|");
        return builder.toString().trim();
    }

    private String renderLadderCol(final RenderContext renderContext) {
        return "|" + paddingOrLine(renderContext);
    }

    private String paddingOrLine(final RenderContext renderContext) {
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
