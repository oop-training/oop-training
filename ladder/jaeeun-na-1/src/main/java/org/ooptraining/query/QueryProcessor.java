package org.ooptraining.query;

import lombok.RequiredArgsConstructor;
import org.ooptraining.exception.QueryProcessorExitException;
import org.ooptraining.setting.SettingContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.ooptraining.query.QueryCommand.*;

@RequiredArgsConstructor(staticName = "of")
public class QueryProcessor {
    private final Scanner sc;
    private static Map<String, QueryCommand> queryCommandMap;

    static {
        queryCommandMap = new HashMap<>();
        queryCommandMap.put("@ALL", SHOW_ALL);
        queryCommandMap.put("@BYE", EXIT);
    }

    public void run(final SettingContext settingContext) {
        try {
            while (true) {
                System.out.println("결과를 보고 싶은 사람은?");
                final String input = sc.nextLine();

                final QueryCommand queryCommand = parseQueryCommand(input);
                final QueryCommandArgument queryCommandArgument = queryCommand.parseQueryArgument(input);

                final QueryResult queryResult = queryCommand.execute(settingContext, queryCommandArgument);

                System.out.println("실행 결과");
                System.out.println(queryResult.asString());
                System.out.println();
            }
        } catch (QueryProcessorExitException exitException) {
            System.out.println(exitException.getMessage());
        }
    }

    private QueryCommand parseQueryCommand(final String input) {
        final String normalizedInput = input.toUpperCase();

        return queryCommandMap.getOrDefault(normalizedInput, SHOW);
    }
}
