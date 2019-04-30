package org.ooptraining.util.dummy.data;

import org.ooptraining.Participant;
import org.ooptraining.setting.SettingContext;

import java.util.Arrays;
import java.util.stream.Stream;

public class SettingContextDummys {
    public static Stream<SettingContext> data1() {
        return Stream.of(
                SettingContext.builder()
                        .participants(Arrays.asList(
                                Participant.of("abcd", "O"),
                                Participant.of("000", "X"),
                                Participant.of("123", "X"),
                                Participant.of("456", "X"),
                                Participant.of("789", "X")
                                )
                        ).maxHeight(8).build(),

                SettingContext.builder()
                        .participants(Arrays.asList(
                                Participant.of("hello", "world"),
                                Participant.of("im", "groot"),
                                Participant.of("1234", "X")
                                )
                        ).maxHeight(4).build(),

                SettingContext.builder()
                        .participants(Arrays.asList(
                                Participant.of("pobi", "X"),
                                Participant.of("Jaeeun", "Na"),
                                Participant.of("what", "what"),
                                Participant.of("1", "1")
                                )
                        ).maxHeight(10).build(),

                SettingContext.builder()
                        .participants(Arrays.asList(
                                Participant.of("123", "456")
                                )
                        ).maxHeight(10).build()
        );
    }
}
