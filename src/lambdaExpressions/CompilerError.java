//package lambdaExpressions;
//
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Collection;
//import java.util.stream.Stream;
//
//public final class CompilerError {
//    public static void main(String[] args) {
//        // This code DOES NOT COMPILE because Files.readAllFiles can throw an IOException,
//        // and lambdas are not allowed to throw checked exceptions!
//        Stream.of("file-a.txt", "file-b.txt", "file-c.txt")
//                .map(fileName -> Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8))
//                .flatMap(Collection::stream)
//                .forEach(System.out::println);
//    }
//}
