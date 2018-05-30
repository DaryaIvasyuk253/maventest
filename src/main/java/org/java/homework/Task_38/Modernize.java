package org.java.homework.Task_38;
import org.java.homework.Task_34.Employee;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Modernize {

    public static String getPathToResourse(String path)throws URISyntaxException{
        URI uri = ClassLoader.getSystemResource(path).toURI();
        return Paths.get(uri).toString();
    }

    private static List<Employee> filterFrom25to30(List<Employee> employees){
      return employees.stream().filter(employee -> 25 < employee.getAge() && employee.getAge() < 30)
               .peek(employee -> employee.setSalary(employee.getSalary() + 250)).collect(Collectors.toList());
    }

    private static List<Employee> filterFrom30(List<Employee> employees){
        return employees.stream().filter(employee -> employee.getAge() > 30)
                .peek(employee -> employee.setSalary(employee.getSalary() + 500)).collect(Collectors.toList());
    }

    private static List<Employee> filterTo25(List<Employee> employees){
        return employees.stream().filter(employee -> 25 > employee.getAge()).collect(Collectors.toList());
    }

    public  static List<Employee> createFilteredList(List<Employee> employees){
        List<Employee> firstFilter = filterFrom25to30(employees);
        List<Employee> secondFilter = filterFrom30(employees);
        List<Employee> thirdFilter  = filterTo25(employees);
        firstFilter.addAll(secondFilter);
        firstFilter.addAll(thirdFilter);
        return firstFilter;
    }


}
