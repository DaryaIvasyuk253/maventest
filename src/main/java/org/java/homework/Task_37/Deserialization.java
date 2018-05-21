package org.java.homework.Task_37;

import org.java.homework.Task_34.Employee;
import org.java.homework.Task_34.Gender;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Deserialization {
    public static void main(String[] args) {
        String path = "C:\\Users\\Asus\\IdeaProjects\\maventest\\src\\main\\resources\\input.csv";
        createEmployees(path).stream().forEach(System.out::println);
    }
    public static List<Employee> createEmployees(String path) {
        List<String> readText = new ArrayList<>();
        List<Employee> employees = new LinkedList<>();
        String[] line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null){
                line = currentLine.split(",");
                readText.addAll(Arrays.asList(line));
                Employee newEmployee = new Employee(readText.get(0), Long.parseLong(readText.get(1)),
                        Integer.parseInt(readText.get(2)), Gender.valueOf(readText.get(3)), Boolean.parseBoolean(readText.get(4)));
                employees.add(newEmployee);
                readText.clear();

            }
        }  catch (IOException e) {
            e.printStackTrace();
            employees = Collections.emptyList();
        }
        return employees;
    }
}
