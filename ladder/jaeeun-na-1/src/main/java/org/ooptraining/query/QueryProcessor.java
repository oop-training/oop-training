package org.ooptraining.query;

import lombok.RequiredArgsConstructor;
import org.ooptraining.query.argument.ShowQueryCommandArgument;
import org.ooptraining.setting.SettingContext;

import java.util.Scanner;

@RequiredArgsConstructor(staticName = "of")
public class QueryProcessor {
    private final Scanner sc;

    public void run(final SettingContext settingContext) {
        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            final String input = sc.nextLine();

            QueryResult queryResult;
            if (input.equalsIgnoreCase("@all")) {
                queryResult = QueryCommand.SHOW_ALL.execute(settingContext);
            } else if (settingContext.toParticipantMap().containsKey(input)) {
                final QueryArgument queryArgument = ShowQueryCommandArgument.of(input.trim());
                queryResult = QueryCommand.SHOW.execute(settingContext, queryArgument);
            } else if (input.equalsIgnoreCase("@bye")) {
                System.out.println("bye!");
                return;
            } else {
                queryResult = new QueryResult("invalid");
            }

            System.out.println("실행 결과");
            System.out.println(queryResult.asString());
            System.out.println();
        }
    }
}
