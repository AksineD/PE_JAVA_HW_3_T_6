import java.util.Scanner;

public class SwitchExample {

    public static void main(String[] args) {
        // Read and validate input from the user
        String[] inputTokens = getInput();
        if (inputTokens == null) return; // If input is invalid, terminate the program

        // First token is the operation character
        char operation = inputTokens[0].charAt(0);

        // Parse the remaining tokens as integers
        int[] numbers = parseNumbers(inputTokens);
        if (numbers == null) return; // If parsing fails, terminate the program

        // Perform the operation based on the provided character
        handleOperation(operation, numbers);
    }

    /**
     * Reads input from the user and validates that it's in the correct format:
     * A character followed by four integers separated by spaces.
     *
     * @return A string array containing the input tokens, or null if validation fails.
     */
    private static String[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input in the format: <char> <int> <int> <int> <int>");
        // Example input: a 7 9 6 5
        String[] tokens = scanner.nextLine().split("\\s+");
        scanner.close();

        // Check if the input contains exactly 5 tokens (1 character and 4 integers)
        if (tokens.length != 5) {
            System.out.println("ERROR: Please provide exactly 5 inputs.");
            return null;
        }
        return tokens;
    }

    /**
     * Parses the second to fifth tokens as integers.
     *
     * @param tokens The input tokens from the user.
     * @return An array of four integers, or null if parsing fails.
     */
    private static int[] parseNumbers(String[] tokens) {
        try {
            return new int[] {
                    Integer.parseInt(tokens[1]), // First integer (n1)
                    Integer.parseInt(tokens[2]), // Second integer (n2)
                    Integer.parseInt(tokens[3]), // Third integer (n3)
                    Integer.parseInt(tokens[4])  // Fourth integer (n4)
            };
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid integer in input.");
            return null;
        }
    }

    /**
     * Handles the operation logic based on the provided operation character.
     * Delegates each operation to a corresponding method.
     *
     * @param operation The operation character ('a', 'S', 'M', 'P').
     * @param numbers   The array of four integers provided in the input.
     */
    private static void handleOperation(char operation, int[] numbers) {
        switch (operation) {
            case 'a':
                handleAverage(numbers);
                break;
            case 'S':
                handleSum(numbers);
                break;
            case 'M':
                handleMultiplicationOrDivision(numbers);
                break;
            case 'P':
                printAuthors();
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

    /**
     * Computes the average of four integers and prints the result.
     *
     * @param numbers The array of four integers.
     */
    private static void handleAverage(int[] numbers) {
        double average = (numbers[0] + numbers[1] + numbers[2] + numbers[3]) / 4.0;
        System.out.println("Average of numbers: " + average);
    }

    /**
     * Computes the sum of four integers and prints the result.
     *
     * @param numbers The array of four integers.
     */
    private static void handleSum(int[] numbers) {
        int sum = (numbers[0] + numbers[1] + numbers[2] + numbers[3]);
        System.out.println("Sum of numbers: " + sum);
    }

    /**
     * Handles the 'M' operation. If the second number is even, it computes the product
     * of the four integers. If the second number is odd, it divides the third number
     * by the fourth (with division by zero handling).
     *
     * @param numbers The array of four integers.
     */
    private static void handleMultiplicationOrDivision(int[] numbers) {
        // Check if the second number is even
        if (numbers[1] % 2 == 0) {
            // Compute and print the product of all four numbers
            long product = (long) numbers[0] * numbers[1] * numbers[2] * numbers[3];
            System.out.println("Product of numbers: " + product);
        } else {
            // Perform division of the third number by the fourth
            if (numbers[3] == 0) {
                System.out.println("ERROR: Division by zero!");
            } else {
                double division = (double) numbers[2] / numbers[3];
                System.out.println("Result of dividing the 3rd by the 4th: " + division);
            }
        }
    }

    /**
     * Prints the program authors.
     *
     * This is executed when the operation character is 'P'.
     */
    private static void printAuthors() {
        System.out.println("Written by: Denis Yampolsky");
    }
}