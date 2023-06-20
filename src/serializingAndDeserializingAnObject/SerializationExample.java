package serializingAndDeserializingAnObject;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        // Create an object to serialize
        MyClass obj = new MyClass("John", 25);

        // Serialize the object to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.ser"))) {
            oos.writeObject(obj);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.ser"))) {
            MyClass deserializedObj = (MyClass) ois.readObject();
            System.out.println("Deserialized Object: " + deserializedObj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class MyClass implements Serializable {
    private String name;
    private int age;

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "serializingAndDeserializingAnObject.MyClass{name='" + name + "', age=" + age + "}";
    }
}

//In this example, the serializingAndDeserializingAnObject.MyClass implements Serializable, allowing instances of serializingAndDeserializingAnObject.MyClass to be serialized and deserialized. The object is serialized using ObjectOutputStream and written to a file called "object.ser". Later, it is deserialized using ObjectInputStream and printed to the console.


