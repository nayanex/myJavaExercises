I am back bitches, in Java mode. LOL :scream:

### Functional Interfaces

Only _certain kinds_ of interfaces can be implemented by lambdas. Those interfaces are called **functional interfaces**.

A **functional interface** is a Java interface with exactly one abstract method, called the **functional method**.

Example:

```java
@FunctionalInterface
public interface Predicate<T> {
boolean test(T t);
default Predicate<T> negate() { return (t) -> !test(t); }

// Other methods left out of this example
}
```
The `Predicate` interface is a functional interface.

Notice that functional interfaces are Java interfaces, and just like a non-functional Java interface, they are allowed to have type parameters. Here, `Predicate` has one type parameter `T`, which is the type being tested.

_Predicate_'s one abstract method is `test()`. `test()` is known as the **functional method**. "Abstract" means the method is not implemented, so in order to be a functional method, it cannot have a default implementation. However, functional interfaces can have other default methods. In this case, the `Predicate` interface has a default method called `negate()` that returns another `Predicate`.

The `@FunctionalInterface` annotation at the top serves two important purposes:

* If that annotation is added to any interface that is not a valid functional interface, the Java compiler will report a compilation error.
* It tells whoever is reading the code that this is interface is designed to be used with lambdas.

That's why if you intend for an interface to be functional, you should always add the `@FunctionalInterface` annotation.

When you're designing a Java interface, you should consider making it a functional interface if it describes a single operation.


### Package Structure of a Java Project

Verify that you are running the Java class from the correct directory. When executing the Java program, you need to be in the directory that contains the root package folder. For instance, if your class is in the **lambdaExpressions** package, navigate to the parent directory containing the **lambdaExpressions** folder and run the program from there.

```
cd ..myJavaExercises/out/production/myJavaExercises
javac *.java
java lambdaExpressions/Calculate 5 + 4 
```

## Edge Case: Capturing Variables

Lambdas can **capture** variables from the surrounding code. If a lambda uses any variables from the surrounding code, those variables become **captured variables**. Variables can only be captured if they are **effectively final**.

An **effectively final** variable is a variable whose value does not change after it is initialized.

Example:

```java
Map<Year, Integer> getClassSizes(List<Student> students) {
    final Map<Year, Integer> classSizes = new HashMap<>();
    students.stream().forEach(s ->
        classSizes.compute(
            s.getGraduationYear(),
            (k, v) -> (v == null) ? 1 : 1 + v));
    return classSizes;
}
```

A good test to figure out if a variable is effectively final is to add the `final keyword to it. If the code still compiles, that variable is effectively final!

In the example, the `classSizes` variable is effectively final because the value of the variable itself does not change after it's initialized. Remember that in Java, objects are passed by reference. Even though the `HashMap` changes, the variable's value is the `HashMap`'s location in memory, and that location never changes.

In the example below, the lambda captures the variable `i`, but it is not effectivelly final.

```java
List<Runnable> runnables = new ArrayList<>(10);
for (int i = 0; i < 10; i++) {
  runnables.add(() -> System.out.println(i));
}
```

Even though the value of `i` does not change _inside_ the lambda, the value changes (`i++`) each time the loop iterates.

One way to get around this would be to use an **IntStream**:

```java
List<Runnable> runnables = IntStream.range(1, 10).map(i -> () -> System.out.println(i)).collect(Collectors.toList());
```

## The Stream API

### What is a Stream?

A **stream** is a sequence of elements.

Streams are useful because they allow us to process collection, one element at a time. They can process elements in many ways, such as (but not limited to) filtering or transforming elements, sorting elements, or computing statistics such as the sum or average.

### Stream Pipelines

A stream pipeline consists of creating a stream, calling intermediate operations on the stream, and then terminating the stream using a terminal operation.

* Streams are _single-use_. Once you do an operation on a `Stream`, you cannot to any more operations on that same stream. This means intermediate operations always return a brand new `Stream`, never the original.

* Streams are _lazily evaluated_. No computation happens until the very end, when the terminal operation is called.

Example:

```java
int getTopScore(List<Student> students) {
 return students.stream()
     .filter(Objects::nonNull)
     .mapToInt(Student::getScore)
     .max()
     .orElse(0);
}
```

## Stream API: Collectors

The `collect()` method is a terminal operation that aggregates streams of elements. Collectors can be passed to `collect()` to determine what kind of collection is created.

```java
Set<String> s = stringList.stream().collect(Collectors.toSet());
```

Here, the collector aggregates the elements into a Set. There are collectors for all the common data structures such as lists, sets, and maps.

Collectors can be used to perform reduction operations such as adding or counting.

```java
Map<Year, Long> graduatingClassSizes = studentList.stream()
.collect(Collectors.groupingBy(
Student::getGraduationYear, Collectors.counting());
```

Here, `groupingBy()` is used to collect elements into a `Map`. `Collectors.counting()` counts the number of values for each key, so, in this example, it will count how many students there are for each graduation year.

## Optional Type

* `java.util.Optional` is a container object that may or may not contain a single, non-null value.
* Optional is an **alternative to using `null`** to represent the absence of a value.

### Optional Type Example

Optional Types are often returned by **terminal operations** on streams.

```java
int getTopScore(List<Student> students) {
return students.stream()
.filter(Objects::nonNull)
.mapToInt(Student::getScore)
.max()
.orElse(0);
}
```

Here, the `max()` method actually returns an `OptionalInt`, not an `int`. If the `students` list is empty, the `max()` method will return an empty optional.

If `max()` returns an `OptionalInt` with a value, that value will be used. However, if `max()` returns `OptionalInt.empty()`, the call to `orElse()` makes sure that a default value of `0` will be returned.

This example also shows you how, in addition to `Optional<T>`, Java also has optional types that are specialized for `int`, `long`, and `double` primitives. These classes avoid the need for auto-boxing and auto-unboxing of their values.

### When to Use Optional Types

When you're designing Java APIs, you should consider using `Optional` instead of `null` to represent the absence of values.

`Optional` can have methods invoked on it without throwing `NullPointerException`. The Stream API uses optional types for many of its terminal operations.

However, optionals can sometimes lead to more verbose code by forcing you to call `.get()` whenever you want the value.

## Input & Output Streams

### InputStream Example

```java
InputStream in =
   Files.newInputStream(Path.of("test"), StandardOpenOption.READ);
byte[] data = new byte[10];
while (in.read(data) != -1) {  // Returns the number of bytes read
  useData(data);
}
in.close();  // Close the "test" file
```

This code creates a file called "test" using `newInputStream()` method of the Files API. The code calls the `read()` method, which reads the data into a `byte[]` and returns the number of bytes that were read. If no bytes were read, it returns `-1`. This code will read the entire file, 10 bytes at a time, until the loop reaches the end of the file.

### OutputStream Example

```java
OutputStream out = Files.newOutputStream(Path.of("test"));
out.write("Hello, world!".getBytes());
out.close();  // Close the "test" file
```

### Readers & Writers

#### Reader Example

```java
char[] data = new char[10];
Reader reader =
Files.newBufferedReader(Path.of("test"), StandardCharsets.UTF_8);
while (reader.read(data) != -1) {
useData(data);
}
reader.close();
```

Just like input streams, `Readers` are usually created with the Files API. But instead of reading `bytes`, we are reading `chars. There's also a `StandardCharset`, which we'll cover that in more detail in the next video.

#### Writer Example

```java
Writer writer =
Files.newBufferedWriter(Path.of("test"),
StandardCharsets.UTF_8);
writer.write("hello, world");
writer.close();  // Close the "test" file
```
The `Writer` is pretty much what you would expect. This time we are writing encoded `String`s of data instead of raw `bytes`.

#### BufferedReader Example

```java
BufferedReader reader =
Files.newBufferedReader(Path.of("test"), StandardCharsets.UTF_8);
String line;
while ((line = reader.readLine()) != null) {
useString(line);
}
reader.close();
```

#### BufferedWriter Example

```java
BufferedWriter writer =
Files.newBufferedWriter(Path.of("test"),
StandardCharsets.UTF_8);
writer.write("Hello, ");
writer.write("world!");
writer.flush();  // Writes the contents of the buffer
writer.close();  // Flushes the buffer and closes "test"
```

BufferedWriter also uses an in-memory buffer to store writes, and then periodically writes contents of the buffer in batches.

In this code, the `write()` method is called twice, but there is only one actual write to the underlying output stream.


### `try-catch-finally` Example

try-catch-finally can be very useful for preventing resource leaks.

```java
Writer writer;
        try {
        writer = Files.newBufferedWriter(Path.of("test"));
        writer.write("Hello, world!");
        } catch (IOException e) {
        e.printStackTrace();
        } finally {
        if (writer != null) {
        try {
        writer.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
        }
```
The code in the `finally` block is guaranteed to execute after the code in the `try` block, even if the `try` block returns a value or throws an exception. This code also has a `catch` block, but that is optional.

## `try-with-resources` Example

```java
try (Writer writer = Files.newBufferedWriter(Path.of("test"))) {
writer.write("Hello, world!");
} catch (IOException e) {
e.printStackTrace();
}
```

Java 7 introduced the `try-with-resources` syntax. This new syntax allows you to initialize your resources in parenthesis right before the start of the `try` block. Resources initialized in this way are guaranteed to be closed after the `try` block finishes executing.

Although `try-with-resources` has removed the need for the `finally` block in a lot of modern Java code, there are still some use cases where the `finally` block is useful.

By the way, you can initialize multiple resources in the same `try` statement, like this:

```java
// Copy the contents of "foo" to "bar"
try (InputStream in   = Files.newInputStream(Path.of("foo"));
     OutputStream out = Files.newOutputStream(Path.of("bar"))) {
  out.write(in.readAllBytes());
}
```

### `Closeable` and `AutoCloseable`

Only `**Closeable**` or `**AutoCloseable**` objects can be used in the `try` statement.

Most of the I/O classes we've talked about, including `Stream`, `Reader`, `Writer`, `InputStream`, and `OuptutStream`, already implement the `Closeable` interface, whose `close()` method can throw an `IOException`.

AutoCloseable.close() does not throw IOException.

`Closeable` and `AutoCloseable` are just regular Java interfaces, which means you can write your own implmentations and then use them in a `try-with-resources` block!


