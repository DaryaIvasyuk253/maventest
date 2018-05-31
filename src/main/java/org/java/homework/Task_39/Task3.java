package org.java.homework.Task_39;

import java.util.Scanner;

public class Task3 implements Runnable {
    private String myName;

    public String getMyName() {
        return myName;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        myName = scanner.next();
    }
}
