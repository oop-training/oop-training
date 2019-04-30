package org.ooptraining.query;

import lombok.RequiredArgsConstructor;
import org.ooptraining.setting.SettingContext;

@RequiredArgsConstructor(staticName = "of")
public class QueryProcessor {
    private final SettingContext settingContext;

    public QueryResult execute(final QueryCommand queryCommand) {
        return new QueryResult();
    }
}
