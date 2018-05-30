package org.java.homework.Task_38;
import org.java.homework.Task_34.Employee;
import org.java.homework.Task_37.Deserialization;
import java.io.*;
import java.net.URISyntaxException;
import java.util.List;


public class WriteToFile {
    public static void main(String[] args) {
        writeToFile();
    }

    public static void writeToFile(){
        String oldFilePath = "input.csv";
        String newFilePath = "C:\\Users\\Asus\\IdeaProjects\\maventest\\res\\output.csv";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(newFilePath))) {
           List<Employee> employees = Modernize.createFilteredList(Deserialization.createEmployees
                   (Modernize.getPathToResourse(oldFilePath)));
            String isMarried;
            for (Employee e: employees
                 ) {
                if (e.isMarried()){
                    isMarried = "yes";
                }
                else {
                    isMarried = "no";
                }
                String s = "\"" + e.getName()+ "\"" + "," + e.getSalary() + "," + e.getAge() +
                        ",\"" + e.getGender() + "\"" + ",\"" + isMarried + "\"";
                bw.write(s);
                bw.newLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O Exception was occurred");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception was found");
            e.printStackTrace();
        }
    }
}
