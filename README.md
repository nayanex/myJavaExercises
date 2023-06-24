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


