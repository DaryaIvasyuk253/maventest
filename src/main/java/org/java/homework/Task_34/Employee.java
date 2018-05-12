package org.java.homework.Task_34;

public class Employee {
    private String name;
    private Long salary;
    private int age;
    private Gender gender;
    private boolean married;

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMarried() {
        return married;
    }

    public Employee(String name, Long salary, int age, Gender gender, boolean married) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.married = married;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender=" + gender +
                ", married=" + married +
                '}';
    }
}
