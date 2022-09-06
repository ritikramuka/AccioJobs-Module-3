import java.util.HashSet;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static boolean containsDuplicate(int[]  arr, int n) {
        HashSet<Integer> mySet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int num = arr[i];
            // number already there in our set
            if(mySet.contains(num) == true) {
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

        boolean ans = containsDuplicate(arr, n);
        System.out.println(ans);

        scn.close();
    }
}