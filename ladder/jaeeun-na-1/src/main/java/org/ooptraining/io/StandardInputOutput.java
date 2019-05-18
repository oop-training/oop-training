package org.ooptraining.io;

import java.io.PrintStream;
import java.util.Scanner;

public class StandardInputOutput implements IO {
    private final Scanner in = new Scanner(System.in);
    private final PrintStream out = System.out;

    @Override
    public String nextLine() {
        return in.nextLine();
    }

    @Override
    public void print(final String line) {
        out.print(line);
    }

    @Override
    public void println() {
        out.println();
    }

    @Override
    public void println(final String line) {
        out.println(line);
    }
}
