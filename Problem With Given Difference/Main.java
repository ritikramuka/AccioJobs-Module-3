import java.util.HashSet;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static boolean findDiff(int n, int[] arr, int diff) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (mySet.contains(num - diff) == true || mySet.contains(num + diff) == true) {
                return true;
            }
            mySet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int diff = scn.nextInt();

        boolean ans = findDiff(n, arr, diff);

        if (ans == true)
            System.out.println(1);
        else
            System.out.println(0);

        scn.close();
    }
}