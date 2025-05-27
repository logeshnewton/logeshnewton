package org.example;

//import java.util.*;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class venc {

    public static void main(String args[]){
        HashMap<Integer,String> ts= new HashMap<>();
        ts.put(13,"fijay");
        ts.put(2,"bjith");
        ts.put(5,"casi");
        ts.put(3,"danjai");
        ts.put(4,"eani");
        System.out.println(ts);
        System.out.println(ts.entrySet());
        System.out.println(ts.keySet());
        System.out.println(ts.values());
        for(Object i: ts.values()){
            System.out.println(i);
        }
        for(Map.Entry<Integer,String> sss: ts.entrySet()){
            System.out.println(sss.getKey()+" : "+sss.getValue());

        }







    }
}
