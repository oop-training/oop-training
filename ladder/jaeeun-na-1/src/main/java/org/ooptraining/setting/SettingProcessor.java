package org.ooptraining.setting;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

@Log
@RequiredArgsConstructor(staticName = "of")
public class SettingProcessor {
    private final Scanner sc;

    public SettingContext run(final List<Setting> settings) {
        final SettingContext.Builder builder = SettingContext.builder();

        settings.forEach(setting -> {
            final String line = sc.nextLine();
            log.info(line);
            System.out.println(setting.getInputMessages());
            setting.parse(line, builder);
        });

        return builder.build();
    }
}
