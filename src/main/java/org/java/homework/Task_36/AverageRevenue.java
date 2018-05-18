package org.java.homework.Task_36;

import org.java.homework.Task_34.Employee;

import java.util.OptionalDouble;
import java.util.stream.Stream;

public class AverageRevenue {
    public static OptionalDouble avr(Stream<Employee> employees){
        return employees.mapToDouble(Employee::getSalary).average();
    }
}
