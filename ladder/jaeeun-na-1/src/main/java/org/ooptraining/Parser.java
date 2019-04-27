package org.ooptraining;

import org.ooptraining.setting.SettingContext;

public interface Parser {
    void handle(final String line, final SettingContext.Builder builder);
}
