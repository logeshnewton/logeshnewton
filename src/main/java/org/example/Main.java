package org.example;
import java.util.*;

class Main {
    public static void main(String[] args) {
        String ss = "pwwkew";
        int k = 0;
        int Max = 0;
        String longest = "";
        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < ss.length(); i++) {
            while (hs.contains(ss.charAt(i))) {
                hs.remove(ss.charAt(k));
                k++;
            }
            hs.add(ss.charAt(i));
            Max = Math.max(Max, i - k + 1);

            // Update longest substring when the length increases
            if (Max == i - k + 1) {
                longest = ss.substring(k, i + 1);
            }
        }

        System.out.println(Max);          // Output: 3
        System.out.println(longest);      // Output: "wke"
    }
}
