package org.ooptraining.render.policy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.Participant;
import org.ooptraining.render.Renderer;
import org.ooptraining.setting.SettingContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RandomRenderPolicy")
class RandomRenderPolicyTest {
    @Test
    @DisplayName("can render all horizontally line")
    void random_test1() {
        final SettingContext settingContext = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("abc", "X"),
                        Participant.of("123", "O"),
                        Participant.of("efg", "X"),
                        Participant.of("456", "X")
                ))
                .maxHeight(5)
                .build();

        final List<Boolean> mockRandomInts = Stream.iterate(true, i -> i).limit(1000).collect(toList());
        final RandomRenderPolicy randomRenderPolicy = RandomRenderPolicy.of(PredefinedRandom.of(mockRandomInts));
        final Renderer renderer = Renderer.of(randomRenderPolicy);


        final String ladder = renderer.render(settingContext);


        final String expected =
                        "abc      123      efg      456\n" +
                        "|--------|--------|--------|\n" +
                        "|--------|--------|--------|\n" +
                        "|--------|--------|--------|\n" +
                        "|--------|--------|--------|\n" +
                        "|--------|--------|--------|\n" +
                        "O        X        X        X";
        assertThat(ladder).isEqualTo(expected);
    }

    @Test
    @DisplayName("can render no line")
    void random_test2() {
        final SettingContext settingContext = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("abc", "X"),
                        Participant.of("123", "O"),
                        Participant.of("efg", "X"),
                        Participant.of("456", "X")
                ))
                .maxHeight(5)
                .build();

        final List<Boolean> mockRandomInts = Stream.iterate(false, i -> i).limit(1000).collect(toList());
        final RandomRenderPolicy randomRenderPolicy = RandomRenderPolicy.of(PredefinedRandom.of(mockRandomInts));
        final Renderer renderer = Renderer.of(randomRenderPolicy);


        final String ladder = renderer.render(settingContext);


        final String expected =
                        "abc      123      efg      456\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "X        O        X        X";
        assertThat(ladder).isEqualTo(expected);
    }

    @Test
    @DisplayName("can render line for one by one column")
    void random_test3() {
        final SettingContext settingContext = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("abc", "A"),
                        Participant.of("123", "B"),
                        Participant.of("efg", "C"),
                        Participant.of("456", "D")
                ))
                .maxHeight(5)
                .build();

        final List<Boolean> mockRandomInts = Stream.iterate(false, i -> !i).limit(1000).collect(toList());
        final RandomRenderPolicy randomRenderPolicy = RandomRenderPolicy.of(PredefinedRandom.of(mockRandomInts));
        final Renderer renderer = Renderer.of(randomRenderPolicy);


        final String ladder = renderer.render(settingContext);


        final String expected =
                        "abc      123      efg      456\n" +
                        "|        |--------|        |\n" +
                        "|--------|        |--------|\n" +
                        "|        |--------|        |\n" +
                        "|--------|        |--------|\n" +
                        "|        |--------|        |\n" +
                        "D        B        C        A";
        assertThat(ladder).isEqualTo(expected);
    }

    @Test
    @DisplayName("should match correct name-result pair")
    void random_test4() {
        final SettingContext settingContext = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("abc", "abc"),
                        Participant.of("123", "123"),
                        Participant.of("456", "456"),
                        Participant.of("789", "789")
                ))
                .maxHeight(5)
                .build();

        final List<Boolean> mockRandomInts = Arrays.asList(
                true, false, false,
                false, false, false,
                false, false, false,
                false, false, false,
                false, false, false,
                false, false, false
        );
        final RandomRenderPolicy randomRenderPolicy = RandomRenderPolicy.of(PredefinedRandom.of(mockRandomInts));
        final Renderer renderer = Renderer.of(randomRenderPolicy);


        final String ladder = renderer.render(settingContext);


        final String expected =
                        "abc      123      456      789\n" +
                        "|--------|        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "123      abc      456      789";
        assertThat(ladder).isEqualTo(expected);
    }

    @Test
    @DisplayName("should match correct name-result pair in more complicate (2 lines)")
    void random_test5() {
        final SettingContext settingContext = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("abc", "abc"),
                        Participant.of("123", "123"),
                        Participant.of("456", "456"),
                        Participant.of("789", "789")
                ))
                .maxHeight(5)
                .build();

        final List<Boolean> mockRandomInts = Arrays.asList(
                true, false, false,
                false, false, false,
                false, false, false,
                false, false, false,
                false, false, true,
                false, false, false
        );
        final RandomRenderPolicy randomRenderPolicy = RandomRenderPolicy.of(PredefinedRandom.of(mockRandomInts));
        final Renderer renderer = Renderer.of(randomRenderPolicy);


        final String ladder = renderer.render(settingContext);


        final String expected =
                        "abc      123      456      789\n" +
                        "|--------|        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |--------|\n" +
                        "123      abc      789      456";
        assertThat(ladder).isEqualTo(expected);
    }

    @Test
    @DisplayName("should match correct name-result pair in more complicate (3 lines)")
    void random_test6() {
        final SettingContext settingContext = SettingContext.builder()
                .participants(Arrays.asList(
                        Participant.of("abc", "abc"),
                        Participant.of("123", "123"),
                        Participant.of("456", "456"),
                        Participant.of("789", "789")
                ))
                .maxHeight(5)
                .build();

        final List<Boolean> mockRandomInts = Arrays.asList(
                true, false, false,
                false, false, false,
                false, true, false,
                false, false, false,
                false, false, true,
                false, false, false
        );
        final RandomRenderPolicy randomRenderPolicy = RandomRenderPolicy.of(PredefinedRandom.of(mockRandomInts));
        final Renderer renderer = Renderer.of(randomRenderPolicy);


        final String ladder = renderer.render(settingContext);


        final String expected =
                        "abc      123      456      789\n" +
                        "|--------|        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |--------|        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |--------|\n" +
                        "123      456      789      abc";
        assertThat(ladder).isEqualTo(expected);
    }
}
