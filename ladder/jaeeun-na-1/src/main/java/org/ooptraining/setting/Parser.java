package org.ooptraining.setting;

public interface Parser {
    void parse(final String line, final SettingContext.Builder builder);
}
