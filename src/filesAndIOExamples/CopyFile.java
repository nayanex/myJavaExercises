package filesAndIOExamples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        InputStream in = Files.newInputStream(Path.of(args[0]));;
        OutputStream out = Files.newOutputStream(Path.of(args[1]));;

        byte[] data = new byte[10];
        while (in.read(data) != -1) {
            out.write(data);
        }
        in.close();
        out.close();
    }
}

