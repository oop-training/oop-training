package org.ooptraining.render;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.Participant;
import org.ooptraining.setting.SettingContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Renderer")
class RendererTest {
    @Test
    @DisplayName("should render ladder in english")
    void renderer_test() {
        final List<Participant> participants = Arrays.asList(
                Participant.of("a", "X"),
                Participant.of("bhello", "O"),
                Participant.of("c", "X"),
                Participant.of("d", "X")
        );
        final SettingContext settingContext = SettingContext.builder()
                .participants(participants)
                .maxHeight(5).build();
        final Renderer renderer = Renderer.of();


        final String ladderResult = renderer.render(settingContext);


        final String expectedLadder =
                "a       bhello  c       d\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "X       O       X       X";

        assertThat(ladderResult).isEqualTo(expectedLadder);
    }

    @Test
    @DisplayName("should render ladder in korean")
    void renderer_test_2() {
        final List<Participant> participants = Arrays.asList(
                Participant.of("a", "X"),
                Participant.of("soloooooongword", "O"),
                Participant.of("c", "X"),
                Participant.of("d", "X")
        );
        final SettingContext settingContext = SettingContext.builder()
                .participants(participants)
                .maxHeight(5).build();
        final Renderer renderer = Renderer.of();


        final String ladderResult = renderer.render(settingContext);


        final String expectedLadder =
                        "a       soloo.. c       d\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "X       O       X       X";
        assertThat(ladderResult).isEqualTo(expectedLadder);
    }
}