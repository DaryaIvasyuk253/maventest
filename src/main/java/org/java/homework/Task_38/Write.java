package org.java.homework.Task_38;

import org.java.homework.Task_34.Employee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;


public class Write {
    private List<Employee> list;

    public Write(List<Employee> list) {
        this.list = list;
    }


    public void write(){
        try (
                FileOutputStream fos = new FileOutputStream("res/output.csv");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O error was occurred");
            e.printStackTrace();
        }
    }
}
