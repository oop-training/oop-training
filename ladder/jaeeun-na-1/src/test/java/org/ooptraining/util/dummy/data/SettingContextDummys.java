package org.ooptraining.util.dummy.data;

import org.junit.jupiter.params.provider.Arguments;
import org.ooptraining.Participant;
import org.ooptraining.game.GameContext;

import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class SettingContextDummys {
    public static GameContext simpleOne() {
        return GameContext.builder()
                .participants(asList(
                        Participant.of("abcd", "O"),
                        Participant.of("000", "X"),
                        Participant.of("123", "X"),
                        Participant.of("456", "X"),
                        Participant.of("789", "X")
                        )
                ).maxHeight(8).build();
    }

    public static Stream<GameContext> data1() {
        return Stream.of(
                GameContext.builder()
                        .participants(asList(
                                Participant.of("abcd", "O"),
                                Participant.of("000", "X"),
                                Participant.of("123", "X"),
                                Participant.of("456", "X"),
                                Participant.of("789", "X")
                                )
                        ).maxHeight(8).build(),

                GameContext.builder()
                        .participants(asList(
                                Participant.of("hello", "world"),
                                Participant.of("im", "groot"),
                                Participant.of("1234", "X")
                                )
                        ).maxHeight(4).build(),

                GameContext.builder()
                        .participants(asList(
                                Participant.of("pobi", "X"),
                                Participant.of("Jaeeun", "Na"),
                                Participant.of("what", "what"),
                                Participant.of("1", "1")
                                )
                        ).maxHeight(10).build(),

                GameContext.builder()
                        .participants(asList(
                                Participant.of("123", "456")
                                )
                        ).maxHeight(10).build()
        );
    }

    public static Stream<Arguments> participantList_queryName_expectedResult() {
        return Stream.of(
                Arguments.of(
                        GameContext.builder()
                                .participants(asList(
                                        Participant.of("abcd", "O"),        // target
                                        Participant.of("000", "X"),
                                        Participant.of("123", "X"),
                                        Participant.of("456", "X"),
                                        Participant.of("789", "X")
                                        )
                                ).maxHeight(8).build(),
                        "abcd",
                        "O"
                ),

                Arguments.of(
                        GameContext.builder()
                                .participants(asList(
                                        Participant.of("hello", "world"),
                                        Participant.of("im", "groot"),      // target
                                        Participant.of("1234", "X")
                                        )
                                ).maxHeight(4).build(),
                        "im",
                        "groot"

                ),
                Arguments.of(

                        GameContext.builder()
                                .participants(asList(
                                        Participant.of("pobi", "X"),
                                        Participant.of("Jaeeun", "Na"),
                                        Participant.of("what", "what"),     // target
                                        Participant.of("1", "1")
                                        )
                                ).maxHeight(10).build(),
                        "what",
                        "what"
                ),
                Arguments.of(
                        GameContext.builder()
                                .participants(asList(
                                        Participant.of("123", "456")        // target
                                        )
                                ).maxHeight(10).build(),
                        "123",
                        "456"
                )
        );
    }
}
