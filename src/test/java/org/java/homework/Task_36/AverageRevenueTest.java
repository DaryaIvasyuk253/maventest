package org.java.homework.Task_36;

import org.java.homework.Task_34.Employee;
import org.java.homework.Task_34.Gender;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.OptionalDouble;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AverageRevenueTest {
    private static Stream<Employee> employeeStream;

    @BeforeClass
    public static void beforeClass() {
        employeeStream = Stream.<Employee>builder()
                .add(new Employee("John", 3500L, 24, Gender.Male, true))
                .add(new Employee("Ben", 2400L, 25, Gender.Male, false))
                .add(new Employee("Lara", 4500L, 22, Gender.Female,false))
                .add(new Employee("Emily", 8000L, 31, Gender.Female, true))
                .add(new Employee("Liam", 9500L, 46, Gender.Male, true))
                .add(new Employee("Mark", 10000L, 50, Gender.Male, false))
                .add(new Employee("Emily", 3500L, 23, Gender.Female, false))

                .build();
    }

    @Test
    public void avr() {
        OptionalDouble optionalDouble = OptionalDouble.of(5914.285714285715);
        assertEquals(optionalDouble, AverageRevenue.avr(employeeStream));
    }
}