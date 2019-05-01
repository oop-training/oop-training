package org.ooptraining.query;

import lombok.RequiredArgsConstructor;
import org.ooptraining.exception.QueryProcessorExitException;
import org.ooptraining.io.IO;
import org.ooptraining.game.GameContext;

import java.util.HashMap;
import java.util.Map;

import static org.ooptraining.query.QueryCommand.*;

@RequiredArgsConstructor(staticName = "of")
public class QueryProcessor {
    private static Map<String, QueryCommand> queryCommandMap;

    static {
        queryCommandMap = new HashMap<>();
        queryCommandMap.put("@ALL", SHOW_ALL);
        queryCommandMap.put("@BYE", EXIT);
    }

    private final IO io;

    public void run(final GameContext gameContext) {
        try {
            while (true) {
                io.println("결과를 보고 싶은 사람은?");
                final String input = io.nextLine();

                final QueryCommand queryCommand = parseQueryCommand(input);
                final QueryCommandArgument queryCommandArgument = queryCommand.parseQueryArgument(input);

                final QueryResult queryResult = queryCommand.execute(gameContext, queryCommandArgument);

                io.println("실행 결과");
                io.println(queryResult.asString());
                io.println();
            }
        } catch (QueryProcessorExitException exitException) {
            io.println(exitException.getMessage());
        }
    }

    private QueryCommand parseQueryCommand(final String input) {
        final String normalizedInput = input.toUpperCase();

        // need to edit when command inputs are formatted
        return queryCommandMap.getOrDefault(normalizedInput, SHOW);
    }
}
