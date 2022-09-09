import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static int findDistictPairsWithDiffK(int n, int[] arr, int k) {
        // case 1
        if(k == 0) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for(int i = 0; i < n; i++) {
                int num = arr[i];
                freqMap.put(num, freqMap.getOrDefault((num), 0) + 1);
            }
            int ans = 0;
            for(int i  = 0; i < n; i++) {
                if(freqMap.get(arr[i]) > 1) {
                    ans += 1;
                    freqMap.put(arr[i], 0);
                }
            }
            return ans;
        }
        // case 2
        else {
            HashSet<Integer> comp = new HashSet<>();
            for(int i = 0; i < n; i++) {
                comp.add(arr[i]);
            }
            int ans = 0;
            for(int i = 0; i < n; i++) {
                int num = arr[i];
                int compNum = num + k;
                if(comp.contains(compNum) == true) {
                    ans++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findDistictPairsWithDiffK(n, arr, k);
        System.out.println(ans);

        scn.close();
    }
}
