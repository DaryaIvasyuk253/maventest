package org.java.homework.Task_33;

public class StringWorker {
    public static<T> T act(DoOnlyAction action, String s) {
        return (T) action.toDo(s);
    }
}
