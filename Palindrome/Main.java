import java.util.Scanner;

public class Main {

    public static boolean isPalindrome(String str) {
        int n = str.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            char iChar = str.charAt(i);
            char jChar = str.charAt(j);

            if (Character.isLetterOrDigit(iChar) == false) {
                i++;
            } else if (Character.isLetterOrDigit(jChar) == false) {
                j--;
            } else {
                if (Character.toLowerCase(iChar) != Character.toLowerCase(jChar)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean ans = isPalindrome(str);
        if (ans == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        // System.out.println(ans == true ? 1 : 0);
        scn.close();
    }
}
