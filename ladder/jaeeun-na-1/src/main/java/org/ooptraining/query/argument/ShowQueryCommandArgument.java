package org.ooptraining.query.argument;

import lombok.RequiredArgsConstructor;
import org.ooptraining.query.QueryCommandArgument;

@RequiredArgsConstructor(staticName = "of")
public class ShowQueryCommandArgument implements QueryCommandArgument {
    private final String first;

    @Override
    public String first() {
        return first;
    }
}
