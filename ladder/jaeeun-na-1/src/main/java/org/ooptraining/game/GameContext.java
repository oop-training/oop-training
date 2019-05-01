package org.ooptraining.game;

import lombok.Getter;
import lombok.ToString;
import org.ooptraining.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
public class GameContext {
    private List<Participant> participants;
    private int maxHeight;

    private GameContext() {
        participants = new ArrayList<>();
    }

    public static GameContext.Builder builder() {
        return new Builder();
    }

    public GameContext toSwap(int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex >= participants.size()) {
            throw new IllegalArgumentException("invalid index for GameContext");
        }

        final List<Participant> newParticipants = participants.stream()
                .map(Participant::clone)
                .collect(Collectors.toList());

        final Participant left = newParticipants.get(leftIndex);
        final Participant right = newParticipants.get(rightIndex);
        newParticipants.set(leftIndex, right);
        newParticipants.set(rightIndex, left);

        return GameContext.builder().participants(newParticipants).build();
    }

    public Map<String, String> toParticipantMap() {
        return participants.stream().collect(Collectors.toMap(Participant::getName, Participant::getResult));
    }

    public static class Builder {
        private GameContext instance;
        private List<String> names = new ArrayList<>();
        private List<String> results = new ArrayList<>();

        Builder() {
            instance = new GameContext();
            instance.maxHeight = 5;
        }

        public GameContext build() {
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
