package org.ooptraining.render;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.ooptraining.Participant;
import org.ooptraining.setting.SettingContext;

import static org.ooptraining.util.StringUtils.*;

import java.util.List;

@Log
@RequiredArgsConstructor(staticName = "of")
public class Renderer {

    public static final int MAX_NAME_LENGTH = 8;
    public static final int PADDING_LENGTH = 8;

    public String render(final SettingContext settingContext) {
        return render(new StringBuilder(), settingContext);
    }

    private String render(final StringBuilder builder, final SettingContext settingContext) {
        builder.append(renderParticipants(settingContext));
        builder.append("\n");
        builder.append(renderLadders(settingContext));
        builder.append("\n");
        builder.append(renderResult(settingContext));

        return builder.toString();
    }

    private String renderParticipants(final SettingContext settingContext) {
        final List<Participant> participants = settingContext.getParticipants();
        final StringBuilder builder = new StringBuilder();

        participants.forEach(participant -> {
            final String name = normalize(participant.getName(), MAX_NAME_LENGTH);
            final int remainPaddingSize = getRemainPadding(name, PADDING_LENGTH);

            builder.append(name);
            builder.append(padding(remainPaddingSize));
        });
        builder.append("\n");

        return builder.toString().trim();
    }

    private String renderLadders(final SettingContext settingContext) {
        return "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |";
    }

    private String renderResult(final SettingContext settingContext) {
        final List<Participant> participants = settingContext.getParticipants();
        final StringBuilder builder = new StringBuilder();

        participants.forEach(participant -> {
            final String result = normalize(participant.getResult(), MAX_NAME_LENGTH);
            final int remainPaddingSize = getRemainPadding(result, PADDING_LENGTH);

            builder.append(result);
            builder.append(padding(remainPaddingSize));
        });

        return builder.toString().trim();
    }

}
