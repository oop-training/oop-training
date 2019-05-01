package org.ooptraining.query;

import org.ooptraining.exception.IllegalQueryCommandException;
import org.ooptraining.exception.QueryProcessorExitException;
import org.ooptraining.query.argument.DefaultQueryCommandArgument;
import org.ooptraining.query.argument.ShowQueryCommandArgument;
import org.ooptraining.setting.GameContext;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.ooptraining.util.StringUtils.makeFullResultWithNameAndResult;

public enum QueryCommand {
    SHOW_ALL {
        @Override
        public QueryResult execute(final GameContext gameContext) {
            final String result = makeFullResultWithNameAndResult(gameContext);

            return QueryResult.of(result);
        }

        @Override
        public QueryResult execute(final GameContext gameContext, final QueryCommandArgument queryCommandArgument) {
            // ignore arguments
            return execute(gameContext);
        }
    },

    SHOW {
        @Override
        public QueryResult execute(final GameContext gameContext) {
            throw new IllegalArgumentException("cannot execute SHOW command without QueryCommandArgument");
        }

        @Override
        public QueryResult execute(final GameContext gameContext, final QueryCommandArgument queryCommandArgument) {
            final Map<String, String> participantMap = gameContext.toParticipantMap();
            final String result = participantMap.get(queryCommandArgument.first());

            return QueryResult.of(result);
        }

        @Override
        public QueryCommandArgument parseQueryArgument(final String input) {
            return ShowQueryCommandArgument.of(input);
        }
    },

    EXIT {
        @Override
        public QueryResult execute(final GameContext gameContext) {
            throw new QueryProcessorExitException("bye!");
        }

        @Override
        public QueryResult execute(final GameContext gameContext, final QueryCommandArgument queryCommandArgument) {
            throw new QueryProcessorExitException("bye!");
        }
    },

    UNKNOWN {
        @Override
        public QueryResult execute(final GameContext gameContext) {
            throw new IllegalQueryCommandException(UNKNOWN);
        }

        @Override
        public QueryResult execute(final GameContext gameContext, final QueryCommandArgument queryCommandArgument) {
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

    public abstract QueryResult execute(final GameContext gameContext);

    public abstract QueryResult execute(final GameContext gameContext, final QueryCommandArgument queryCommandArgument);

    public QueryCommandArgument parseQueryArgument(final String input) {
        return new DefaultQueryCommandArgument();
    }

    @Override
    public String toString() {
        return name();
    }
}
