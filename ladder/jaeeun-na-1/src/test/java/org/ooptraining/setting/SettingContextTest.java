package org.ooptraining.setting;

import org.junit.jupiter.api.Test;
import org.ooptraining.Participant;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SettingContextTest {
    @Test
    void cloneTest1() {
        final SettingContext context = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("name1", "A"),
                        Participant.of("honghong", "B"),
                        Participant.of("nanana", "C"),
                        Participant.of("NONONO", "D"),
                        Participant.of("hello", "E"),
                        Participant.of("world", "F")
                )).build();
        final SettingContext swappedContext = context.toSwap(0, 1);

        final SettingContext expected = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("honghong", "B"),
                        Participant.of("name1", "A"),
                        Participant.of("nanana", "C"),
                        Participant.of("NONONO", "D"),
                        Participant.of("hello", "E"),
                        Participant.of("world", "F")
                )).build();

        assertThat(swappedContext).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    void cloneTest2() {
        final SettingContext context = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("name1", "A"),
                        Participant.of("honghong", "B"),
                        Participant.of("nanana", "C"),
                        Participant.of("NONONO", "D"),
                        Participant.of("hello", "E"),
                        Participant.of("world", "F")
                )).build();
        final SettingContext swappedContext = context.toSwap(1, 5);

        final SettingContext expected = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("name1", "A"),
                        Participant.of("world", "F"),
                        Participant.of("nanana", "C"),
                        Participant.of("NONONO", "D"),
                        Participant.of("hello", "E"),
                        Participant.of("honghong", "B")
                )).build();

        assertThat(swappedContext).isEqualToComparingFieldByFieldRecursively(expected);
    }


    @Test
    void exception_when_index_is_exceed_range() {
        assertThrows(IllegalArgumentException.class, () -> {
            final SettingContext context = SettingContext.builder()
                    .participants(Arrays.asList(
                            Participant.of("name1", "0"),
                            Participant.of("honghong", "1"),
                            Participant.of("nanana", "2"),
                            Participant.of("NONONO", "3"),
                            Participant.of("hello", "4"),
                            Participant.of("world", "5")
                    )).build();
            final SettingContext swappedContext = context.toSwap(0, 6);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final SettingContext context = SettingContext.builder()
                    .participants(Arrays.asList(
                            Participant.of("name1", "0"),
                            Participant.of("honghong", "1"),
                            Participant.of("nanana", "2"),
                            Participant.of("NONONO", "3"),
                            Participant.of("hello", "4"),
                            Participant.of("world", "5")
                    )).build();
            final SettingContext swappedContext = context.toSwap(-1, 6);
        });
    }
}