package lambdaExpressions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public final class ReadFilesMain {
    public static void main(String[] args) throws IOException {
        Stream.of("file-a.txt", "file-b.txt", "file-c.txt")
                .map(Path::of)
                .map(p -> {
                    try {
                        return Files.readAllLines(p, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        return List.of();
                    }
                })
                .flatMap(List::stream)
                .forEach(System.out::println);
    }
}

