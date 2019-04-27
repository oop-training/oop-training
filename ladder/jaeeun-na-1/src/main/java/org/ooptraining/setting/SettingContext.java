package org.ooptraining.setting;

import lombok.*;
import org.ooptraining.Participant;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SettingContext {
    private List<Participant> participants;
    private int maxHeight;

    private SettingContext() {
        participants = new ArrayList<>();
    }

    public static SettingContext.Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SettingContext instance = new SettingContext();
        private List<String> names = new ArrayList<>();
        private List<String> results = new ArrayList<>();

        public SettingContext build() {
            if (names.size() != results.size()) {
                throw new IllegalStateException();
            }

            for (int i = 0; i < names.size(); i++) {
                final Participant participant = Participant.of(names.get(i), results.get(i));
                instance.participants.add(participant);
            }

            return instance;
        }

        public Builder addName(String name) {
            names.add(name);
            return this;
        }

        public Builder addResult(String result) {
            results.add(result);
            return this;
        }

        public Builder maxHeight(final int maxHeight) {
            instance.maxHeight = maxHeight;
            return this;
        }

        public Builder participants(final List<Participant> participants) {
            instance.participants = participants;
            return this;
        }
    }
}
