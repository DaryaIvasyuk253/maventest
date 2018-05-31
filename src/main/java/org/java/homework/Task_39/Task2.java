package org.java.homework.Task_39;

public class Task2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.printf("[%d] \t", i);
        }
        System.out.println("start:");
    }
}
