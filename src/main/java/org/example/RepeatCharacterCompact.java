package org.example;
public class RepeatCharacterCompact {
    public static void main(String[] args) {
        String input = "a3b12";
        char letter = '\0';
        int num = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (letter != '\0') {
                    System.out.print(String.valueOf(letter).repeat(num));
                }
                letter = ch;
                num = 0;
            } else {
                num = num * 10 + (ch - '0'); // Handles multi-digit numbers
            }
        }
        System.out.print(String.valueOf(letter).repeat(num)); // Print last letter
    }
}
