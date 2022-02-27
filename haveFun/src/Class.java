import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Class {
    //1000 random numbers between (1 - 500) * 2 msg
    //2000 msg

    public static int randInt() {
        int min = 1;
        int max = 500;
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum * 2;
    }

    public static void main(String[] args) {
        int count = 1000;
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            System.out.println(randInt());
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double elapsedTimeInSecond = (double) totalTime / 1_000_000_000;

        long startTime2 = System.nanoTime();
        int tCounter = 0;
        for (int i = 0; i < 10000000; i++) {
            int x = randInt();
            if (x == 1000) {
                tCounter++;
            }
            count++;
        }
        System.out.println("thousands: " + tCounter);
        System.out.println("all: " + count);
        long endTime2 = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;
        double elapsedTimeInSecond2 = (double) totalTime2 / 1_000_000_000;
        System.out.println("1st: " + elapsedTimeInSecond + " seconds");
        System.out.println("2nd: " + elapsedTimeInSecond2 + " seconds");

    }

}
