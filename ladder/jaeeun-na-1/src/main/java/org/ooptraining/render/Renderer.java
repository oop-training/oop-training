package org.ooptraining.render;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.ooptraining.Participant;
import org.ooptraining.setting.SettingContext;

import static org.ooptraining.util.StringUtils.*;

import java.util.List;
import java.util.Random;

@Log
@RequiredArgsConstructor(staticName = "of")
public class Renderer {
    public static final int MAX_NAME_LENGTH = 8;
    public static final int INTERVAL_WIDTH = 8;
    public static final int PADDING_LENGTH = INTERVAL_WIDTH - 1;

    private boolean previousIsLine = false;

    public String render(final SettingContext settingContext) {
        return render(new StringBuilder(), settingContext);
    }

    private String render(final StringBuilder builder, final SettingContext settingContext) {
        builder.append(renderParticipants(settingContext));
        builder.append("\n");
        builder.append(renderLadders(settingContext));
        builder.append("\n");
        builder.append(renderResult(settingContext));

        return builder.toString().trim();
    }

    private String renderParticipants(final SettingContext settingContext) {
        final List<Participant> participants = settingContext.getParticipants();
        final StringBuilder builder = new StringBuilder();

        participants.forEach(participant -> {
            final String name = normalize(participant.getName(), MAX_NAME_LENGTH);
            final int remainPaddingSize = getRemainPadding(name, INTERVAL_WIDTH);

            builder.append(name);
            builder.append(padding(remainPaddingSize));
        });
        builder.append("\n");

        return builder.toString().trim();
    }

    private String renderLadders(final SettingContext settingContext) {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < settingContext.getMaxHeight(); i++) {
            builder.append(renderLadderRow(settingContext));
            builder.append("\n");
        }
        return builder.toString().trim();
    }

    private String renderLadderRow(final SettingContext settingContext) {
        final StringBuilder builder = new StringBuilder();
        final int numberOfParticipants = settingContext.getParticipants().size();
        previousIsLine = new Random().nextBoolean();
        for (int i = 0; i < numberOfParticipants - 1; i++) {
            builder.append(renderLadderCol());
        }
        builder.append("|");
        return builder.toString().trim();
    }

    private String renderLadderCol() {
        return "|" + paddingOrLine();
    }

    private String paddingOrLine() {
        final int number = new Random().nextInt();
        if (!previousIsLine && number % 2 == 0) {
            previousIsLine = true;
            log.info(String.valueOf(number));
            return line(PADDING_LENGTH);
        }
        previousIsLine = false;
        return padding(PADDING_LENGTH);
    }

    private String renderResult(final SettingContext settingContext) {
        final List<Participant> participants = settingContext.getParticipants();
        final StringBuilder builder = new StringBuilder();

        participants.forEach(participant -> {
            final String result = normalize(participant.getResult(), MAX_NAME_LENGTH);
            final int remainPaddingSize = getRemainPadding(result, INTERVAL_WIDTH);

            builder.append(result);
            builder.append(padding(remainPaddingSize));
        });

        return builder.toString().trim();
    }

}
