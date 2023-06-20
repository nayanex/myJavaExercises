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
* 
That's why if you intend for an interface to be functional, you should always add the `@FunctionalInterface` annotation.

When you're designing a Java interface, you should consider making it a functional interface if it describes a single operation.



