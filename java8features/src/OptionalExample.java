import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello, World!");
        
        // Using ifPresent to check and print the value
        optional.ifPresent(System.out::println);
        
        // Using orElse to provide a default value
        String value = optional.orElse("Default Value");
        System.out.println(value);
    }
}
