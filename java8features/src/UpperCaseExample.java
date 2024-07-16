import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Using map to convert names to uppercase
        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
        
        upperNames.forEach(System.out::println);
    }
}
