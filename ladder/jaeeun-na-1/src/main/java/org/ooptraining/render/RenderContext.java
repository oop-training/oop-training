package org.ooptraining.render;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RenderContext {
    private int maxNameLength;
    private int intervalWidth;
}
