package org.ooptraining.render;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RenderContext {
    public static RenderContext DEFAULT = RenderContext.builder()
            .intervalWidth(7)
            .maxNameLength(7)
            .build();

    private int maxNameLength;
    private int intervalWidth;
}
