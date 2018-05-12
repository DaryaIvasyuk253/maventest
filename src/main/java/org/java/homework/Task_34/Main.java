package org.java.homework.Task_34;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.stream.Stream;

public class Main {
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

//        firstMarriedMale(employeeStream);
//        anySingleWoman(employeeStream);
//        sortedAgePlus45Male(employeeStream);
//        sortedAgeUpTo30Female(employeeStream);
//        sortedGenderByAge(employeeStream);
//        countSingleWoman(employeeStream);
//        salaryOfManPlus30(employeeStream);
//        distinctNames(employeeStream);

    }

    private static void firstMarriedMale(Stream<Employee> stream){
        stream.filter(employee -> employee.isMarried() && employee.getGender() == Gender.Male)
                .limit(1).map(employee -> employee.getName()).forEachOrdered(System.out:: println);
    }

    private static void anySingleWoman(Stream<Employee> stream){
        stream.filter(employee -> !employee.isMarried() && employee.getGender() == Gender.Female)
                .findAny().map(employee -> employee.getName()).ifPresent(System.out::println);
    }

    private static void sortedAgePlus45Male(Stream<Employee> stream){
        stream.filter(employee -> employee.getAge() > 45 && employee.getGender() == Gender.Male)
                .map(employee -> employee.getName()).forEach(System.out :: println);
    }

    private static void sortedAgeUpTo30Female(Stream<Employee> stream){
        stream.filter(employee -> employee.getAge() < 30 && employee.getGender() == Gender.Female)
                .map(employee -> employee.getName()).forEach(System.out::println);
    }

    private static void sortedGenderByAge(Stream<Employee> stream){
        stream.filter(employee -> 33 < employee.getAge() && employee.getAge() < 37)
                .map(employee -> employee.getName()).forEach(System.out::println);
    }

    private static void countSingleWoman(Stream<Employee> stream){
        System.out.println(stream.filter(employee -> employee.getGender() == Gender.Female && !employee.isMarried()).count());
    }

    private static void salaryOfManPlus30(Stream<Employee> stream){
        stream.filter(employee -> employee.getAge() > 30 && employee.getGender() == Gender.Male).map(employee -> employee.getSalary()).forEach(System.out::println);
    }

    private static void distinctNames(Stream <Employee> stream){
        stream.map(employee -> employee.getName()).distinct().forEach(System.out::println);
    }





}
