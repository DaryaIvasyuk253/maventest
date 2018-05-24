package org.java.homework.Task_38;

public class Main {
    public static void main(String[] args)  {
        Serealization serealization = new Serealization();
        Write write = new Write(serealization.createFilteredList());
       write.write();
    }
}
