package org.java.homework.Task_32;

import org.junit.Test;

import static org.junit.Assert.*;

public class StrategyHelperTest {

    @Test
    public void testSelectStrategy() {
        Complexity complexity = Complexity.GREEN;
        Complexity complexity1 = Complexity.ADVANCE;
        Complexity complexity2 = Complexity.EXPERT;
        assertEquals(true,StrategyHelper.selectStrategy(complexity2, 17));

    }
}