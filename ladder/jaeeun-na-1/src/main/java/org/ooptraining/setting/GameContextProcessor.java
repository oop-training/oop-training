package org.ooptraining.setting;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.ooptraining.io.IO;

import java.util.List;

@Log
@RequiredArgsConstructor(staticName = "of")
public class GameContextProcessor {
    private final IO io;

    public GameContext run(final List<Setting> settings) {
        final GameContext.Builder builder = GameContext.builder();

        settings.forEach(setting -> {
            final String message = setting.getInputMessages();
            io.println(message);

            final String userInput = io.nextLine();
            setting.parse(userInput, builder);
        });

        return builder.build();
    }
}
