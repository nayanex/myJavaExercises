package filesAndIOExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class CopyFile1 {
    public static void main(String[] args) throws IOException {
        Files.copy(Path.of(args[0]), Path.of(args[1]));
    }
}
