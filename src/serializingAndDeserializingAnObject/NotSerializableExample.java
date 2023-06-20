package serializingAndDeserializingAnObject;

import java.io.*;

public class NotSerializableExample {
    public static void main(String[] args) {
        NonSerializableClass obj = new NonSerializableClass("Example");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.ser"))) {
            oos.writeObject(obj); // Throws NotSerializableException
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class NonSerializableClass {
    private String data;

    public NonSerializableClass(String data) {
        this.data = data;
    }
}
