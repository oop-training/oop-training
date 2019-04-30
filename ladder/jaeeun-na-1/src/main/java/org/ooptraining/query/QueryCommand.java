package org.ooptraining.query;

import org.ooptraining.setting.SettingContext;

import static org.ooptraining.util.StringUtils.makeFullResultWithNameAndResult;

public enum QueryCommand {
    SHOW_ALL {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            final String result = makeFullResultWithNameAndResult(settingContext);

            return new QueryResult(result);
        }
    },

    SHOW {
        @Override
        public QueryResult execute(final SettingContext settingContext) {
            return null;
        }
    };

    public abstract QueryResult execute(final SettingContext settingContext);
}
