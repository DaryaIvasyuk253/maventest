package org.java.homework.Task_33;

public class StringAlg {
    public static int getNumberParts(String s) {
        int count = 0;
        String [] arr;
        arr = s.split(",");
        for (String string: arr
             ) {count++;

        }
        System.out.println(count);
        return count;
    }
}
