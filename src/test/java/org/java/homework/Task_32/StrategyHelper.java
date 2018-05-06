package org.java.homework.Task_32;

public class StrategyHelper {
    public static boolean selectStrategy(Complexity complexity, int param){
        boolean ifTrue = false;
        switch (complexity){
            case GREEN:
                Strategy strategy = currentValue -> param >= 13;
                return strategy.sayStop(param);
            case ADVANCE:
                Strategy strategy1 = currentValue -> param >= 15;
                return strategy1.sayStop(param);
            case EXPERT:
                Strategy strategy2 = currentValue -> param >=17;
               return strategy2.sayStop(param);

        }
        return ifTrue;

    }
}
