import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Using Stream API to filter even numbers, square them, and collect the result
        List<Integer> processedNumbers = numbers.stream()
            .filter(n -> n % 2 == 0) // Filter even numbers
            .map(n -> n * n) // Square each number
            .collect(Collectors.toList()); // Collect the result into a list

        System.out.println(processedNumbers); // Output: [4, 16, 36, 64, 100]
        
        // Sum of squares of even numbers using Stream API
        int sumOfSquares = numbers.stream()
            .filter(n -> n % 2 == 0) // Filter even numbers
            .mapToInt(n -> n * n) // Square each number
            .sum(); // Sum the results

        System.out.println(sumOfSquares); // Output: 220
    }
}
