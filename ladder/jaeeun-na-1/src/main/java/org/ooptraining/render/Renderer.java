package org.ooptraining.render;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.ooptraining.setting.SettingContext;

@Log
@RequiredArgsConstructor(staticName = "of")
public class Renderer {
    private final RenderPolicy renderPolicy;

    public String render(final SettingContext settingContext, final RenderContext renderContext) {
        return renderPolicy.render(settingContext, renderContext);
    }
}
