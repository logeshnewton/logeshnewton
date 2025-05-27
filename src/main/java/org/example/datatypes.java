package org.example;

public class datatypes {


    public void main(){
        String ss="123";
        int sss=Integer.parseInt(ss);
        double d=Double.parseDouble(ss);
        long l=Long.parseLong(ss);

        System.out.println(sss);
        System.out.println(d);
        System.out.println(l);
        boolean bool = Boolean.parseBoolean("true");
        System.out.println(bool);


        int k=100;
        String kk=String.valueOf(k);
        System.out.println(kk);

        double gd=99.99;
        int num=(int)gd;
        System.out.println(num);


        char n='A';
        int ch=(int)n;
        System.out.println(ch);

        Integer intObj = 50;
        Double doubleObj = intObj.doubleValue(); // Integer to Double
        Float floatObj = intObj.floatValue();    // Integer to Float

        System.out.println(doubleObj + ", " + floatObj);

        int nums = 42;
        String strNum = Integer.toString(nums);
        int parsedNum = Integer.parseInt(strNum);

        System.out.println(strNum + ", " + parsedNum);

        char chs = 'A';

// char to String
        System.out.println(Character.toString(chs));
        String str = Character.toString(chs);

// String to char
        char newChar = str.charAt(0);

        System.out.println(str + ", " + newChar);








    }
}
