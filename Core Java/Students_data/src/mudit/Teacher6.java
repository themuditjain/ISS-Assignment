package mudit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teacher6 {
    // Method that throws an exception
    public static int divideNumbers(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            // Throwing an ArithmeticException if the denominator is zero
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return numerator / denominator;
    }

    // Method that handles exceptions using try-catch
    public static void readAndDivide() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = divideNumbers(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            // Handling InputMismatchException
            System.out.println("Please enter valid integers.");
        } catch (ArithmeticException e) {
            // Handling ArithmeticException
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Finally block always executes, whether an exception is caught or not
            scanner.close();
        }
    }

    public static void main(String[] args) {
        // Example of using the readAndDivide method
        readAndDivide();

        // Example of throwing an exception
        try {
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


/*
In this example:

The divideNumbers method demonstrates the use of the throw keyword to explicitly throw an ArithmeticException if the denominator is zero.
The readAndDivide method demonstrates the use of a try-catch block to handle exceptions. It catches both InputMismatchException (when non-integer input is provided) and ArithmeticException.
The main method shows an example of using the readAndDivide method and also demonstrates the explicit throwing of an exception in another context.
This example also includes the use of the throws clause in the method signature, which indicates that a method may throw a particular type of exception. In this case, the divideNumbers method includes throws ArithmeticException.
*/