import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static String findMaxFreqOfWord(int n, String[] arr) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        String ans = "";
        int maxFreq = 0;
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            if (freqMap.get(word) >= maxFreq) {
                ans = word;
                maxFreq = freqMap.get(word);
                freqMap.put(word, 0);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.next();
        }

        String ans = findMaxFreqOfWord(n, arr);
        System.out.println(ans);

        scn.close();
    }
}