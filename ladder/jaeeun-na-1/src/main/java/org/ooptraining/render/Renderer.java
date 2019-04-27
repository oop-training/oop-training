package org.ooptraining.render;

import lombok.extern.java.Log;
import org.ooptraining.setting.SettingContext;

@Log
public class Renderer {
    private RenderPolicy renderPolicy = RenderPolicy.DEFAULT;

    public Renderer with(final RenderPolicy renderPolicy) {
        this.renderPolicy = renderPolicy;
        return this;
    }

    public String render(final SettingContext settingContext, final RenderContext renderContext ) {
        return renderPolicy.render(settingContext, renderContext);
    }
}
