package serializingAndDeserializingAnObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public final class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: Main [file path]");
            return;
        }

        UdacisearchClient client =
                new UdacisearchClient(
                        "CatFacts LLC",
                        17,
                        8000,
                        5,
                        Instant.now(),
                        Duration.ofDays(180),
                        ZoneId.of("America/Los_Angeles"),
                        "555 Meowmers Ln, Riverside, CA 92501");

        Path outputPath = Path.of(args[0]);

        // TODO: Write the "client" variable to the "outputPath", using a ObjectOutputStream. Then,
        //  read it back and deserialize it using a ObjectInputStream.

        // Serialize the object to a file
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(outputPath));
            oos.writeObject(client);
        }catch (IOException e){
            e.printStackTrace();
        }

        // Deserialize the object from the file
        try {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(outputPath));
            UdacisearchClient deserializedObj = (UdacisearchClient) ois.readObject();
            System.out.println("Deserialized Object: " + deserializedObj);
        }catch (IOException e){
            e.printStackTrace();
        }

        UdacisearchClient deserialized = client;
        System.out.println(deserialized);
    }
}
// javac Main.java && java Main client.bin
