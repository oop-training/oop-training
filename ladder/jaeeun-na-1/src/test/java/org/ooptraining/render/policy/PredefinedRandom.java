package org.ooptraining.render.policy;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(staticName = "of")
public class PredefinedRandom implements RandomBoolean {
    private final List<Boolean> predefined;
    private int predefinedIndex = 0;

    @Override
    public boolean nextBoolean() {
        return predefined.get(predefinedIndex++);
    }
}
