package org.ooptraining;

import lombok.extern.java.Log;
import org.ooptraining.query.QueryProcessor;
import org.ooptraining.render.RenderContext;
import org.ooptraining.render.RenderPolicy;
import org.ooptraining.render.Renderer;
import org.ooptraining.render.policy.DefaultRandom;
import org.ooptraining.render.policy.RandomRenderPolicy;
import org.ooptraining.setting.GameContext;
import org.ooptraining.setting.GameContextProcessor;
import org.ooptraining.setting.Setting;

import java.util.Arrays;
import java.util.Scanner;

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
        final Scanner sc = new Scanner(System.in);

        final GameContextProcessor gameContextProcessor = GameContextProcessor.of(sc);
        final GameContext gameContext = gameContextProcessor.run(Arrays.asList(
                Setting.NAME,
                Setting.RESULT,
                Setting.MAX_HEIGHT
        ));

        final Renderer renderer = Renderer.of(renderPolicy);
        final String renderResult = renderer.render(gameContext);
        printFormattedRenderResult(renderResult);

        final QueryProcessor queryProcessor = QueryProcessor.of(sc);
        queryProcessor.run(gameContext);
    }

    private static void printFormattedRenderResult(final String renderResult) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println(renderResult);
        System.out.println();
    }
}
