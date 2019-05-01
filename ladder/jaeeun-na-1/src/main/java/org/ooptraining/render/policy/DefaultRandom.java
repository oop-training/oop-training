package org.ooptraining.render.policy;

import java.util.Random;

public class DefaultRandom implements RandomBoolean {
    private final Random random = new Random();

    @Override
    public boolean nextBoolean() {
        return random.nextBoolean();
    }
}
