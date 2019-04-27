package org.ooptraining.render;

import org.ooptraining.render.policy.OneLineRenderPolicy;
import org.ooptraining.setting.SettingContext;

public interface RenderPolicy {
    RenderPolicy DEFAULT = new OneLineRenderPolicy();

    String render(final SettingContext settingContext, final RenderContext renderContext);
}
