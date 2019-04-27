package org.ooptraining.render;

import lombok.RequiredArgsConstructor;
import org.ooptraining.setting.SettingContext;

@RequiredArgsConstructor(staticName = "of")
public class Renderer {
    public String render(final SettingContext settingContext) {
        return "a       bhello  c       d\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "|       |       |       |\n" +
                "꽝       당첨     꽝      꽝\n";

    }
}
