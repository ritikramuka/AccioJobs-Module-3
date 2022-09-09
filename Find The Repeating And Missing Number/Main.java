import java.util.Scanner;

public class Main {

    public static void printRepeatingAndMissing(int n, int[] arr) {
        // sum of numbers 1 to n, i.e. 1 + 2 + .... + n
        long s1 = (n * (n + 1)) / 2;

        // sum of squares of numbers 1 to n, i.e. 1^2 + 2^2 + .... + n^2
        long s2 = (n * (n + 1) * (2 * n + 1)) / 6;

        // x -> repeating, y -> missing

        // sum of numbers given array
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
        }

        // s - s1
        long xMinusY = s - s1;

        // sum of numbers squares of given array
        long ss = 0;
        for (int i = 0; i < n; i++) {
            ss += (arr[i] * arr[i]);
        }

        // ss - s2
        long xSqrMinusYSqr = ss - s2;

        long xPlusY = xSqrMinusYSqr / xMinusY;

        // finding x and y
        long x = (xMinusY + xPlusY) / 2;

        long y = xPlusY - x;

        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        printRepeatingAndMissing(n, arr);
        scn.close();
    }
}
