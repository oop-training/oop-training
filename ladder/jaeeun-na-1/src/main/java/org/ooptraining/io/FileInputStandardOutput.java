package org.ooptraining.io;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileInputStandardOutput implements ClosableIO {
    private final FileInput input;

    @Override
    public String nextLine() {
        return input.nextLine();
    }

    @Override
    public void print(final String line) {
        System.out.print(line);
    }

    @Override
    public void println() {
        System.out.println();
    }

    @Override
    public void println(final String line) {
        System.out.println(line);
    }

    @Override
    public void close() {
        input.close();
    }
}
