package org.java.homework.Task_39;

public class Main {
    public static void main(String[] args) {
        Runnable task1 = () ->  System.out.println("Hello To My Multithreading World:");
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Task2();
        Task3 task3 = new Task3();
        Thread thread3 = new Thread(task3);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String myName = String.format("My name is %s", task3.getMyName());
        System.out.println(myName);
    }

}

