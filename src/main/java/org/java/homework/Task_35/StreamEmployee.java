package org.java.homework.Task_35;

import org.java.homework.Task_34.Employee;
import org.java.homework.Task_34.Gender;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEmployee {
    public static void main(String[] args) {
        Stream<Employee> employeeStream = Stream.<Employee>builder()
                .add(new Employee("John",3500L , 24, Gender.Male, true))
                .add(new Employee("Ben", 2400L, 25, Gender.Male, false))
                .add(new Employee("Lara", 4500L, 22, Gender.Female,false))
                .add(new Employee("Emily", 8000L, 31, Gender.Female, true))
                .add(new Employee("Liam", 9500L, 46, Gender.Male, true))
                .add(new Employee("Mark", 10000L, 50, Gender.Male, false))
                .add(new Employee("Emily", 3500L, 23, Gender.Female, false))
                .add(new Employee("Rachel", 15500L, 32, Gender.Female, true))
                .add(new Employee("Frederik", 20000L, 36, Gender.Male, true))
                .add(new Employee("John", 8000L, 33, Gender.Male, false))
                .add(new Employee("Joanne", 6500L, 35, Gender.Female, true)).build();

        System.out.println(createListEmployee(employeeStream));
    }
    public static List<Employee> createListEmployee(Stream<Employee> employeeStream){
        return employeeStream.collect(Collectors.toList());
    }
}
