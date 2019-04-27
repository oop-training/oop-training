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
    @DisplayName("should")
    void renderer_test() {
        final List<Participant> participants = Arrays.asList(
                Participant.of("a", "꽝"),
                Participant.of("bhello", "당첨"),
                Participant.of("c", "꽝"),
                Participant.of("d", "꽝")
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
                "꽝       당첨     꽝      꽝\n";
        assertThat(ladderResult).isEqualTo(expectedLadder);
    }

}