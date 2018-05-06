package org.java.homework.Task_31;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class FilterTest {
    private static List<Student> studentList;
    private static Filter filter;

    @BeforeClass
    public static void beforeClass() {
        filter = new Filter();
        studentList = new LinkedList<>();
        Student student1 = new Student(5, "Matt", 23);
        Student student2 = new Student(1, "Dennis", 18);
        Student student3 = new Student(3, "Anna", 21);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

    }

    @Test
    public void testFilterById() {
        assertEquals(filter.getStudentList(), Filter.filterById(studentList));
    }


    @Test
    public void testFilterByName() {
        assertEquals(filter.getStudentList(), Filter.filterByName(studentList));
    }

    @Test
    public void testFilterByAge() {
        assertEquals(filter.getStudentList(), Filter.filterByAge(studentList));
    }
}