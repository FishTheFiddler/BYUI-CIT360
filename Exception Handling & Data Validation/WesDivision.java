package WesCIT360;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WesDivision {
    // THIS IS THE MAIN DRIVER OF THE PROGRAM. CALLS OTHER FUNCTIONS.
    public static void main(String[] args) {

        float dividend = 0;
        float divisor = 0;
        float answer = 0;
        boolean isRunning = true;


        // INTRO LINES TO PROGRAM
        System.out.println("\n*----Welcome to CIT360 Week 3 Assignment----*");
        System.out.println("-LONG DIVISION-\n");

        // OBTAIN TWO NUMBERS FROM THE USER
        // First, attempt to Obtain the Dividend. If the user enters a string, and error will be found.
        while (isRunning) {
            System.out.println("Please enter a number for the Dividend: ");
            try {
                Scanner input1 = new Scanner(System.in);
                dividend = input1.nextFloat();
                isRunning = false;
            } catch (InputMismatchException a) {
                System.out.println("Invalid Input. The Dividend cannot contain text.");
            }
        }
        isRunning = true;
        while (isRunning) {
            // Second, attempt to Obtain the Divisor. If the user enters a string, and error will be found.
            System.out.println("Please enter a number for the Divisor: ");
            try {
                Scanner input2 = new Scanner(System.in);
                divisor = input2.nextFloat();
                isRunning = false;
            } catch (InputMismatchException b) {
                System.out.println("Invalid Input. The Divisor cannot contain text.");
            }

        }

        // CALCULATE ANSWER AND DISPLAY IT
        try {
            answer = doDivision(dividend, divisor);
        } catch (ArithmeticException c) {
            System.out.println("Error - The Divisor cannot be 0.");
            System.out.println("Please enter a number for the Divisor: ");
            Scanner input2 = new Scanner(System.in);
            divisor = input2.nextFloat();
            answer = doDivision(dividend, divisor);
        } finally {
            System.out.println("The answer is " + answer);
        }
    }


    // TAKE BOTH NUMBERS AND CONDUCT THE MATH
    public static float doDivision(float dividend, float divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("(Divide by Zero)");
        }
        return dividend / divisor;
    }
}