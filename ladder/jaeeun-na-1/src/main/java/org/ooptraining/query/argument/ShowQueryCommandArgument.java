package org.ooptraining.query.argument;

import lombok.RequiredArgsConstructor;
import org.ooptraining.query.QueryArgument;

@RequiredArgsConstructor(staticName = "of")
public class ShowQueryCommandArgument implements QueryArgument {
    private final String first;

    @Override
    public String first() {
        return first;
    }
}
