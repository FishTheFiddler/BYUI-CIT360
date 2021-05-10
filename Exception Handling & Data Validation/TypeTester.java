package WesCIT360;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TypeTester {


    public static void main(String[] args) {

        TypeValidator v = new TypeValidator();
        String x = "";
        int y = 0;
        float z = 0;

        Scanner userInput = new Scanner(System.in);
        Scanner userInput2 = new Scanner(System.in);
        Scanner userInput3 = new Scanner(System.in);

        System.out.println("This is a type tester program.");

        try {
            System.out.println("Please enter in a string: ");
            x = userInput.nextLine();
        } catch(InputMismatchException A){
            System.out.println("-User entered incorrect format. Continuing on-");
            userInput.next();
        }

        try {
            System.out.println("Please enter in a integer: ");
            y = userInput2.nextInt();
        } catch (InputMismatchException A){
            System.out.println("-User entered incorrect format. Continuing on-");
            userInput2.next();
        }

        try {
            System.out.println("Please enter in a float value: ");
            z = userInput3.nextFloat();
        } catch (InputMismatchException A){
            System.out.println("-User entered incorrect format. Continuing on-");
            userInput3.next();
        }

        v.whatType(x);
        v.whatType(y);
        v.whatType(z);



    }
}
