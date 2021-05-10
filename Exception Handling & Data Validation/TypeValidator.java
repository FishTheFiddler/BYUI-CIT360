package WesCIT360;

// This is a seperate class for my other script "TypeTster" to call upon.
public class TypeValidator {

    int whatType(int x) {
        System.out.println(x + " was entered as an int");
        return x;
    }
    float whatType(float x) {
        System.out.println(x + " was entered as a float");
        return x;
    }
    String whatType(String x) {
        System.out.println(x + " was entered as a string");
        return x;
    }

}
