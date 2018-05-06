package org.java.homework.Task_33;
@FunctionalInterface
public interface DoOnlyAction<T> {
    T toDo(String s);
}
