package org.ooptraining.setting;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Scanner;

@Log
@RequiredArgsConstructor(staticName = "of")
public class SettingProcessor {
    private final Scanner sc;

    public GameContext run(final List<Setting> settings) {
        final GameContext.Builder builder = GameContext.builder();

        settings.forEach(setting -> {
            System.out.println(setting.getInputMessages());
            final String line = sc.nextLine();
            setting.parse(line, builder);
        });

        return builder.build();
    }
}
