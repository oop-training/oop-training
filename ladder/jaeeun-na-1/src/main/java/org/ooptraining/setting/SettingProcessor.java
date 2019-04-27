package org.ooptraining.setting;

import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor(staticName = "of")
public class SettingProcessor {
    private final InputStream inputStream;

    public SettingContext run(final List<Setting> settings) {
        final SettingContext.Builder builder = SettingContext.builder();
        final Scanner sc = new Scanner(inputStream);

        settings.forEach(s -> {
            System.out.println(s.getInputMessages());
            s.handle(sc.nextLine(), builder);
        });

        return builder.build();
    }
}
