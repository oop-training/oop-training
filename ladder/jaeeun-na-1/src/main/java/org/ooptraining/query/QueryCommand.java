package org.ooptraining.query;

import org.ooptraining.Participant;
import org.ooptraining.exception.IllegalQueryCommandException;
import org.ooptraining.setting.SettingContext;

import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.ooptraining.util.StringUtils.makeFullResultWithNameAndResult;

public enum QueryCommand {
    SHOW_ALL("SHOW_ALL") {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            final String result = makeFullResultWithNameAndResult(settingContext);

            return new QueryResult(result);
        }

        @Override
        public QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument) {
            // ignore arguments
            return execute(settingContext);
        }
    },

    SHOW("SHOW") {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            throw new IllegalArgumentException("cannot execute SHOW command without QueryArgument");
        }

        @Override
        public QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument) {
            final Map<String, String> nameAndResultMap = settingContext.getParticipants().stream()
                    .collect(toMap(Participant::getName, Participant::getResult));

            return new QueryResult(nameAndResultMap.get(queryArgument.first()));
        }
    },

    UNKNOWN("UNKNOWN") {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            throw new IllegalQueryCommandException(UNKNOWN);
        }

        @Override
        public QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument) {
            throw new IllegalQueryCommandException(UNKNOWN);
        }
    };

    private final String value;

    QueryCommand(final String value) {
        this.value = value;
    }

    public abstract QueryResult execute(final SettingContext settingContext);

    public abstract QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument);

    @Override
    public String toString() {
        return value;
    }
}
