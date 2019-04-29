package org.ooptraining.render;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RenderContext {
    public static RenderContext DEFAULT = RenderContext.builder()
            .intervalWidth(8)
            .maxNameLength(8)
            .build();

    private int maxNameLength;
    private int intervalWidth;
}
