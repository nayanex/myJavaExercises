package lambdaExpressions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class ReadFilesMain2 {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = Arrays.asList("file-a.txt", "file-b.txt", "file-c.txt");

        for (String fileName : fileNames) {
            for (String line : Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8)) {
                System.out.println(line);
            }
        }
    }
}
