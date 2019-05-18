package org.ooptraining.render;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ooptraining.model.Participant;
import org.ooptraining.game.GameContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Renderer")
class RendererTest {
    @Test
    @DisplayName("render")
    void renderer_test() {
        final List<Participant> participants = Arrays.asList(
                Participant.of("a", "X"),
                Participant.of("bhello", "O"),
                Participant.of("c", "X"),
                Participant.of("d", "X")
        );
        final GameContext gameContext = GameContext.builder()
                .participants(participants)
                .maxHeight(5).build();
        final Renderer renderer = Renderer.of(RenderPolicy.DEFAULT);
        final RenderContext renderContext = RenderContext.builder()
                .intervalWidth(8)
                .maxNameLength(7).build();

        final String ladderResult = renderer.render(gameContext, renderContext);

        final String expectedLadder =
                "a        bhello   c        d\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "|        |        |        |\n" +
                        "X        O        X        X";
        assertThat(ladderResult).isEqualTo(expectedLadder);
    }

    @Test
    @DisplayName("render long words")
    void renderer_test_2() {
        final List<Participant> participants = Arrays.asList(
                Participant.of("a", "X"),
                Participant.of("soloooooongword", "O"),
                Participant.of("c", "X"),
                Participant.of("d", "X")
        );
        final GameContext gameContext = GameContext.builder()
                .participants(participants)
                .maxHeight(5).build();
        final RenderContext renderContext = RenderContext.builder()
                .intervalWidth(7)
                .maxNameLength(5).build();
        final Renderer renderer = Renderer.of(RenderPolicy.DEFAULT);


        final String ladderResult = renderer.render(gameContext, renderContext);


        final String expectedLadder =
                "a       sol..   c       d\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "|       |       |       |\n" +
                        "X       O       X       X";
        assertThat(ladderResult).isEqualTo(expectedLadder);
    }

    @Test
    @DisplayName("render more lines")
    void renderer_wide() {
        final List<Participant> participants = Arrays.asList(
                Participant.of("a", "X"),
                Participant.of("soloooooongword", "O"),
                Participant.of("c", "X"),
                Participant.of("d", "X"),
                Participant.of("e", "X"),
                Participant.of("f", "X")
        );
        final GameContext gameContext = GameContext.builder()
                .participants(participants)
                .maxHeight(7).build();
        final RenderContext renderContext = RenderContext.builder()
                .intervalWidth(4)
                .maxNameLength(4).build();
        final Renderer renderer = Renderer.of(RenderPolicy.DEFAULT)
                .with(renderContext);

        final String ladderResult = renderer.render(gameContext);

        final String expectedLadder =
                "a    so.. c    d    e    f\n" +
                        "|    |    |    |    |    |\n" +
                        "|    |    |    |    |    |\n" +
                        "|    |    |    |    |    |\n" +
                        "|    |    |    |    |    |\n" +
                        "|    |    |    |    |    |\n" +
                        "|    |    |    |    |    |\n" +
                        "|    |    |    |    |    |\n" +
                        "X    O    X    X    X    X";
        assertThat(ladderResult).isEqualTo(expectedLadder);
    }
}