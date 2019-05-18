package org.ooptraining.render;

import lombok.RequiredArgsConstructor;
import org.ooptraining.game.GameContext;

@RequiredArgsConstructor(staticName = "of")
public class Renderer {
    private final RenderPolicy renderPolicy;
    private RenderContext renderContext = RenderContext.DEFAULT;

    public String render(final GameContext gameContext) {
        return render(gameContext, renderContext);
    }

    public String render(final GameContext gameContext, final RenderContext renderContext) {
        return renderPolicy.render(gameContext, renderContext);
    }

    public Renderer with(final RenderContext renderContext) {
        this.renderContext = renderContext;
        return this;
    }
}