package TRE;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteWesTRE {

    public static void main(String[] args) {

    boolean validD = false;
    boolean validT = false;

    int divisor = 1;
    int userNumber = 1;
    int threadPool;

        // Prompt the user for the maximum number between 1 and 250.  If they input text or negative number, reprompts the user.
        while(validD == false) {
            System.out.println("Please enter a number between 1 and 250: ");
            try {
                Scanner userThreadPool = new Scanner(System.in);
                userNumber = userThreadPool.nextInt();
                if (userNumber < 0 || userNumber > 250) {
                    System.out.println("Invalid Input. The number needs to be between 1 and 250.");
                    validD = false;
                }
                else {
                    validD = true;
                }
            } catch (InputMismatchException a) {
                System.out.println("Invalid Input. The number range cannot contain text.");
            }
        }

        // Prompt the user to give us a number for the divisor If they input text, reprompts the user.
        while(validT == false) {
            System.out.println("Please enter a whole number for the divisor: ");
            try {
                Scanner userDivisor = new Scanner(System.in);
                divisor = userDivisor.nextInt();
                validT = true;
            } catch (InputMismatchException a) {
                System.out.println("Invalid Input. The divisor cannot contain text.");
            }
        }

        //Determine how many threads we will need to efficiently calculate the values.
        threadPool = calculateThreads(userNumber);

        // Call our function that will Execute the threads
        executeThreads(threadPool, divisor, userNumber);
    }

    public static int calculateThreads(int input) {
        if (input > 0 && input <= 50) {
            return 1;
        }
        else if (input > 50 && input <= 100) {
            return 2;
        }
        else if (input > 100 && input <= 150) {
            return 3;
        }
        else if (input > 150 && input <= 200) {
            return 4;
        }
        else {
            return 5;
        }
    }

    public static void executeThreads(int threads, int divisor, int userNumber) {

        // Create and Executor to run our thread(s)
        ExecutorService myService = Executors.newFixedThreadPool(threads);

        // This will execute the number of threads based on our threadpool size.  Which was calculated in a previous function.
        switch (threads) {
            case (1):
                System.out.println("-Spooling up 1 thread-");
                //Create instances of the Objects
                WesTREDivide p11 = new WesTREDivide(divisor, 750, 1, userNumber);
                myService.execute(p11);
                break;

            case (2):
                System.out.println("-Spooling up 2 threads-");
                //Create instances of the Objects
                WesTREDivide p21 = new WesTREDivide(divisor, 750, 1, 50);
                WesTREDivide p22 = new WesTREDivide(divisor, 750, 50, userNumber);
                myService.execute(p21);
                myService.execute(p22);
                break;

            case (3):
                System.out.println("-Spooling up 3 threads-");
                //Create instances of the Objects
                WesTREDivide p31 = new WesTREDivide(divisor, 750, 1, 50);
                WesTREDivide p32 = new WesTREDivide(divisor, 750, 50, 100);
                WesTREDivide p33 = new WesTREDivide(divisor, 750, 100, userNumber);
                myService.execute(p31);
                myService.execute(p32);
                myService.execute(p33);
                break;

            case (4):
                System.out.println("-Spooling up 4 threads-");
                //Create instances of the Objects
                WesTREDivide p41 = new WesTREDivide(divisor, 750, 1, 50);
                WesTREDivide p42 = new WesTREDivide(divisor, 750, 50, 100);
                WesTREDivide p43 = new WesTREDivide(divisor, 750, 100, 150);
                WesTREDivide p44 = new WesTREDivide(divisor, 750, 150, userNumber);
                myService.execute(p41);
                myService.execute(p42);
                myService.execute(p43);
                myService.execute(p44);
                break;

            case (5):
                System.out.println("-Spooling up 5 threads-");
                //Create instances of the Objects
                WesTREDivide p51 = new WesTREDivide(divisor, 750, 1, 50);
                WesTREDivide p52 = new WesTREDivide(divisor, 750, 50, 100);
                WesTREDivide p53 = new WesTREDivide(divisor, 750, 100, 150);
                WesTREDivide p54 = new WesTREDivide(divisor, 750, 150, 200);
                WesTREDivide p55 = new WesTREDivide(divisor, 750, 200, userNumber);
                myService.execute(p51);
                myService.execute(p52);
                myService.execute(p53);
                myService.execute(p54);
                myService.execute(p55);
                break;
        }

        // Shutdown the Executor
        myService.shutdown();
    }
}
