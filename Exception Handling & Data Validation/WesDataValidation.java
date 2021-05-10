package WesCIT360;

import java.util.Scanner;

public class WesDataValidation {
    // THIS IS THE MAIN DRIVER OF THE PROGRAM. CALLS OTHER FUNCTIONS.
    public static void main(String[] args) {

        float dividend;
        float divisor;
        float answer;
        boolean isRunning = true;

        // INTRO LINES TO PROGRAM
        System.out.println("\n*----Welcome to CIT360 Week 3 Assignment----*");
        System.out.println("\n-LONG DIVISION-");

        // RUN THIS PROGRAM AS LONG AS THE USER WISHES TO
        while (isRunning) {

            // OBTAIN TWO NUMBERS FROM THE USER
            dividend = getNumber("Dividend", false);
            divisor = getNumber("Divisor", true);

            // CALCULATE ANSWER AND DISPLAY IT
            answer = doDivision(dividend, divisor);
            System.out.println("The answer is " + answer);

            // PROMPT USER TO TRY AGAIN
            isRunning = tryAgain();
        }
    }

    // ATTEMPT TO OBTAIN A NUMBER FROM THE USER. If fails, throw error and try again.
    public static float getNumber(String text, boolean checkZero) {
        float number = 0;
        boolean isValid = false;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Please enter a number for the " + text + ": ");
            if (input.hasNextFloat()) {
                number = input.nextFloat();
                if (checkZero && number == 0){
                    isValid = false;
                    System.out.println("Incorrect input. The number cannot be 0. Try again.");
                }
                else {
                    isValid = true;
                }
            }
             else {
                System.out.println("Incorrect input. The number cannot contain text. Try again.");
                isValid = false;
                input.next();
            }
        } while (!(isValid));
        return number;
    }

    // TAKE BOTH NUMBERS AND CONDUCT THE MATH
    public static float doDivision(float dividend, float divisor) {
        return dividend / divisor;
    }

    // PROMPT THE USER IF THEY WANT TO TRY AGAIN
    public static boolean tryAgain() {
        System.out.println("Would you like to try again? y/n : ");
        Scanner input = new Scanner(System.in);
        String tryAgain = input.nextLine();
        switch (tryAgain.toLowerCase()) {
            case ("y"):
                System.out.println("Very well.");
                return true;
            case ("n"):
                System.out.println("Thank you for trying my Division program. Goodbye!");
                return false;
            default:
                System.out.println("I'm afraid I didn't understand your input. Closing program.");
                return false;
        }
    }
}