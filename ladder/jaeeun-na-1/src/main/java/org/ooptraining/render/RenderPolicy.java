package org.ooptraining.render;

import org.ooptraining.render.policy.OneLineRenderPolicy;
import org.ooptraining.game.GameContext;

public interface RenderPolicy {
    RenderPolicy DEFAULT = new OneLineRenderPolicy();

    String render(final GameContext gameContext, final RenderContext renderContext);
}
