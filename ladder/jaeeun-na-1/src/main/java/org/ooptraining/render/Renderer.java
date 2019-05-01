package org.ooptraining.render;

import lombok.RequiredArgsConstructor;
import org.ooptraining.setting.SettingContext;

@RequiredArgsConstructor(staticName = "of")
public class Renderer {
    private final RenderPolicy renderPolicy;
    private RenderContext renderContext = RenderContext.DEFAULT;

    public String render(final SettingContext settingContext) {
        return render(settingContext, renderContext);
    }

    public String render(final SettingContext settingContext, final RenderContext renderContext) {
        return renderPolicy.render(settingContext, renderContext);
    }

    public Renderer with(final RenderContext renderContext) {
        this.renderContext = renderContext;
        return this;
    }
}