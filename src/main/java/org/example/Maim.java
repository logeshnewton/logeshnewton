package org.example;

public class Maim {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        int[][]  input = {{2}, {3,4}, {4,5,6}, {6,1,3},{9,5}};
        int s=0;
        int t=0;
        for (int i=0;i<input.length;i++)
        {
            System.out.println("i Value: "+input.length);
            s=input[i][0];
            System.out.println("j Value: "+input[i].length);
            for(int j=0;j<input[i].length;j++)
            {
              if(input[i][j]<s){
                  s=input[i][j];
              }
            }
            t+=s;


        }
        System.out.println(t);
    }
}
