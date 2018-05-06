package org.java.homework.Task_31;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Filter {
    private static List<Student> studentList;

    public Filter() {
        studentList = new LinkedList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public static void iterator(List<Student> students){
        for (Student st: students
             ) {
        }
    }
    public static List<Student> filterById(List<Student> students){
        studentList.clear();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            if (!filterId(iterator.next())) {
                iterator.remove();
            }
        }
        studentList.addAll(students);
        System.out.println(studentList);
        return students;
    }

    public static List<Student> filterByName(List<Student> students){
        studentList.clear();
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();){
            Student value = iterator.next();
            if (!filterName(value)){
                iterator.remove();
            }
        }
        studentList.addAll(students);
        System.out.println(studentList);
        return students;
    }

    public static List<Student> filterByAge(List<Student> students){
        studentList.clear();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            if (!filterAge(iterator.next())) {
                iterator.remove();
            }
        }
        studentList.addAll(students);
        System.out.println(studentList);
        return students;
    }

    private static boolean filterAge(Student student){
        FilterStudent filterStudent = student1 -> student.getAge() < 19;
        return filterStudent.check(student);
    }

    private static boolean filterName(Student student){
        FilterStudent filterStudent = student1 -> student.getName().startsWith("A");
        return filterStudent.check(student);
    }

    private static boolean filterId(Student student){
       FilterStudent filterStudent = student1 -> student.getId() < 5;
       return filterStudent.check(student);
    }


}
