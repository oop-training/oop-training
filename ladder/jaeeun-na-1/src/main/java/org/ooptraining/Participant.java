package org.ooptraining;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Participant implements Cloneable {
    private final String name;
    private final String result;

    public Participant clone() {
        return Participant.of(name, result);
    }
}
