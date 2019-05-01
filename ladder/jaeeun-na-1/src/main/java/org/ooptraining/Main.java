package org.ooptraining;

import lombok.extern.java.Log;
import org.ooptraining.io.IO;
import org.ooptraining.io.StandardInputOutput;
import org.ooptraining.query.QueryProcessor;
import org.ooptraining.render.RenderPolicy;
import org.ooptraining.render.Renderer;
import org.ooptraining.render.policy.DefaultRandom;
import org.ooptraining.render.policy.RandomRenderPolicy;
import org.ooptraining.game.GameContext;
import org.ooptraining.game.GameContextProcessor;
import org.ooptraining.game.Setting;

import java.util.Arrays;

@Log
public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        final RenderPolicy policy = RandomRenderPolicy.of(new DefaultRandom());
        run(policy);
    }

    public static void run(final RenderPolicy renderPolicy) {
        final IO io = new StandardInputOutput();

        final GameContextProcessor gameContextProcessor = GameContextProcessor.of(io);
        final GameContext gameContext = gameContextProcessor.run(Arrays.asList(
                Setting.NAME,
                Setting.RESULT,
                Setting.MAX_HEIGHT
        ));

        final Renderer renderer = Renderer.of(renderPolicy);
        final String renderResult = renderer.render(gameContext);
        printFormattedRenderResult(io, renderResult);

        final QueryProcessor queryProcessor = QueryProcessor.of(io);
        queryProcessor.run(gameContext);
    }

    private static void printFormattedRenderResult(final IO io, final String renderResult) {
        io.println();
        io.println("사다리 결과");
        io.println(renderResult);
        io.println();
    }
}
