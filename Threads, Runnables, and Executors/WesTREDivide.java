package TRE;

public class WesTREDivide implements Runnable {

    private int wait;
    private int divisor;
    private int min;
    private int max;

    public WesTREDivide(int divisor, int wait, int min, int max){
        this.divisor = divisor;
        this.wait = wait;
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for (int count = min; count <= max; count++) {
            if (count % divisor == 0) {
                System.out.print(count + " is divisible by " + divisor +"\n");
                try {
                    Thread.sleep(wait);
                } catch (InterruptedException e) {
                    System.err.println(e.toString());
                }
            }
        }
}
}
