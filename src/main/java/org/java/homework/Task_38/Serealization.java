package org.java.homework.Task_38;
import org.java.homework.Task_34.Employee;
import org.java.homework.Task_37.Deserialization;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class Serealization implements Serializable {
    private List<Employee> employees;
    {
        try {
            employees = Deserialization.createEmployees(getPathToResourse());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getPathToResourse()throws URISyntaxException{
        URI uri = ClassLoader.getSystemResource("input.csv").toURI();
        return Paths.get(uri).toString();
    }

    private List<Employee> filterFrom25to30(){
      return employees.stream().filter(employee -> 25 < employee.getAge() && employee.getAge() < 30)
               .peek(employee -> employee.setSalary(employee.getSalary() + 250)).collect(Collectors.toList());
    }

    private List<Employee> filterFrom30(){
        return employees.stream().filter(employee -> employee.getAge() > 30)
                .peek(employee -> employee.setSalary(employee.getSalary() + 500)).collect(Collectors.toList());
    }

    private List<Employee> filterTo25(){
        return employees.stream().filter(employee -> 25 > employee.getAge()).collect(Collectors.toList());
    }

    public List<Employee> createFilteredList(){
        List<Employee> firstFilter = filterFrom25to30();
        List<Employee> secondFilter = filterFrom30();
        List<Employee> thirdFilter  = filterTo25();
        firstFilter.addAll(secondFilter);
        firstFilter.addAll(thirdFilter);
        return firstFilter;
    }

    public void print(){
        employees.stream().forEach(System.out::println);
    }






}
