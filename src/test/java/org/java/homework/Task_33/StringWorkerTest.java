package org.java.homework.Task_33;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringWorkerTest {

    @Test
    public void testAct() {
       int result = StringWorker.act(StringAlg ::getNumberParts, "Java is a general-purpose computer-programming " +
               "language that is concurrent, class-based, object-oriented, and specifically designed to have as few " +
               "implementation dependencies as possible");
        assertEquals(4,result);
    }
}