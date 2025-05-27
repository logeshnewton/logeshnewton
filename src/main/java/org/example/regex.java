package org.example;

import java.util.regex.*;

public class regex {
    public static void main(String[] args) {
        String text = "My phone123 number is 9876543210 abc@gmail.com";
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}";
        String number="\\d{2,6}";
        String numbewr="[a-zA-Z]+";

        Pattern pattern =Pattern.compile(numbewr);
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            System.out.print("Found :" +matcher.group() + " "); // 9876543210
        }
    }
}

