package org.ooptraining.render;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.ooptraining.setting.SettingContext;

@Log
@RequiredArgsConstructor(staticName = "of")
public class Renderer {
    private final RenderPolicy renderPolicy;

    private RenderContext renderContext = RenderContext.DEFAULT;

    public String render(final SettingContext settingContext) {
        return renderPolicy.render(settingContext, renderContext);
    }

    public String render(final SettingContext settingContext, final RenderContext renderContext) {
        return renderPolicy.render(settingContext, renderContext);
    }

    public Renderer with(final RenderContext renderContext) {
        this.renderContext = renderContext;
        return this;
    }
}

// TODO: RenderContext가 하는 일을 Renderer가 받도록 하자.
//  클라이언트는 Renderer에 설정을 넣는 방식으로 사용할 수 있도록 하자. (RenderContext는 감추고, 내부에서 생성)
