package org.ooptraining;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Participant {
    private final String name;
    private final String result;
}
