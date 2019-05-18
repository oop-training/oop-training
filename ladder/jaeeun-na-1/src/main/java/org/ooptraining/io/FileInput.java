package org.ooptraining.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;

public class FileInput implements Input, Closable {
    private BufferedReader inputStream;

    private FileInput() {
    }

    public static FileInput of(final String pathName) {
        final FileInput instance = new FileInput();
        final File file = new File(pathName);
        open(instance, file);

        return instance;
    }

    public static FileInput of(final Path path) {
        final FileInput instance = new FileInput();
        open(instance, path.toFile());

        return instance;
    }

    private static void open(final FileInput instance, final File file) {
        try {
            final InputStream inputStream = new FileInputStream(file);
            instance.inputStream = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Invalid file");
        }
    }

    @Override
    public String nextLine() {
        try {
            return inputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {
        try {
            if (Objects.nonNull(inputStream)) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("close fail");
        }
    }
}
