import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input in the format: <char> <int> <int> <int> <int>");
        // Example input: a 7 9 6 5
        // Read entire line and split by whitespace:
        String[] tokens = scanner.nextLine().split("\\s+");
        scanner.close();

        // Basic validation: we expect exactly 5 tokens.
        if (tokens.length != 5) {
            System.out.println("ERROR: Please provide exactly 5 inputs.");
            return;
        }

        // Parse the first token as a character
        char operation = tokens[0].charAt(0);

        // Parse the four integers
        int n1, n2, n3, n4;
        try {
            n1 = Integer.parseInt(tokens[1]);
            n2 = Integer.parseInt(tokens[2]);
            n3 = Integer.parseInt(tokens[3]);
            n4 = Integer.parseInt(tokens[4]);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid integer in input.");
            return;
        }

        switch (operation) {
            case 'a':
                // Compute average of the four integers
                double average = (n1 + n2 + n3 + n4) / 4.0;
                System.out.println("Average of numbers: " + average);
                break;

            case 'S':
                // Compute sum of the four integers
                int sum = (n1 + n2 + n3 + n4);
                System.out.println("Sum of numbers: " + sum);
                break;

            case 'M':  // or 'm' if you prefer lowercase
                // Check if the SECOND integer (n2) is even
                if (n2 % 2 == 0) {
                    // If even, compute the product of the four numbers
                    long product = (long) n1 * n2 * n3 * n4;
                    System.out.println("Product of numbers: " + product);
                } else {
                    // If odd, divide the THIRD by the FOURTH number
                    // (watch out for division by zero in a real program)
                    if (n4 == 0) {
                        System.out.println("ERROR: Division by zero!");
                    } else {
                        double division = (double) n3 / n4;
                        System.out.println("Result of dividing the 3rd by the 4th: " + division);
                    }
                }
                break;

            case 'P':
                // Print the program authors
                System.out.println("Written by: Denis Yampolsky");
                break;

            default:
                // Not one of the specified characters
                System.out.println("ERROR");
                break;
        }
    }
}