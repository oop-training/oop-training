package org.ooptraining.query;

import org.ooptraining.exception.IllegalQueryCommandException;
import org.ooptraining.exception.QueryProcessorExitException;
import org.ooptraining.query.argument.DefaultQueryCommandArgument;
import org.ooptraining.query.argument.ShowQueryCommandArgument;
import org.ooptraining.setting.SettingContext;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.ooptraining.util.StringUtils.makeFullResultWithNameAndResult;

public enum QueryCommand {
    SHOW_ALL {
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

    SHOW {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            throw new IllegalArgumentException("cannot execute SHOW command without QueryArgument");
        }

        @Override
        public QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument) {
            final Map<String, String> participantMap = settingContext.toParticipantMap();
            final String result = participantMap.get(queryArgument.first());

            return new QueryResult(result);
        }

        @Override
        public QueryArgument parseQueryArgument(final String input) {
            return ShowQueryCommandArgument.of(input);
        }
    },

    EXIT {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            throw new QueryProcessorExitException("bye!");
        }

        @Override
        public QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument) {
            throw new QueryProcessorExitException("bye!");
        }
    },

    UNKNOWN {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            throw new IllegalQueryCommandException(UNKNOWN);
        }

        @Override
        public QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument) {
            throw new IllegalQueryCommandException(UNKNOWN);
        }
    };

    private static Map<String, QueryCommand> queryCommandMap;

    static {
        queryCommandMap = Arrays.stream(values()).collect(toMap(Enum::name, o -> o));
    }

    public static QueryCommand of(String value) {
        return queryCommandMap.getOrDefault(value.toUpperCase(), UNKNOWN);
    }

    public abstract QueryResult execute(final SettingContext settingContext);

    public abstract QueryResult execute(final SettingContext settingContext, final QueryArgument queryArgument);

    public QueryArgument parseQueryArgument(final String input) {
        return new DefaultQueryCommandArgument();
    }

    @Override
    public String toString() {
        return name();
    }
}
