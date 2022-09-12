import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static String getSmallestWindow(String s, String p) {
        int n = s.length();
        int m = p.length();

        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = p.charAt(i);
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        String ans = "";
        int rel = -1;
        int acq = -1;
        HashMap<Character, Integer> sMap = new HashMap<>();
        int mcnt = 0;
        int dmcnt = m;

        while (true) {
            boolean isAcquired = false;
            // acquire new char
            while (acq < n - 1 && mcnt < dmcnt) {
                isAcquired = true;

                acq++;
                char acqChar = s.charAt(acq);
                sMap.put(acqChar, sMap.getOrDefault(acqChar, 0) + 1);

                if (sMap.get(acqChar) <= pMap.getOrDefault(acqChar, 0)) {
                    mcnt++;
                }
            }

            boolean isReleased = false;
            // update Answer, and release unwanted stuff from beg
            while (rel < acq && mcnt == dmcnt) {
                isReleased = true;

                String currAns = s.substring(rel + 1, acq + 1);
                if (ans.length() == 0 || ans.length() > currAns.length()) {
                    ans = currAns;
                }

                rel++;
                char relChar = s.charAt(rel);
                if (sMap.get(relChar) == 1) {
                    sMap.remove(relChar);
                } else {
                    sMap.put(relChar, sMap.get(relChar) - 1);
                }

                if(pMap.containsKey(relChar) == true) {
                    if(sMap.containsKey(relChar) == false) {
                        mcnt--;
                    } else if(sMap.get(relChar) < pMap.get(relChar)) {
                        mcnt--;
                    }
                }
            }

            if (isAcquired == false && isReleased == false) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        String p = scn.nextLine();
        String ans = getSmallestWindow(s, p);
        System.out.println(ans);
        scn.close();
    }
}
