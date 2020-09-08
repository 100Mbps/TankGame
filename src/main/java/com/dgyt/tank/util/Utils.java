package com.dgyt.tank.util;

import com.dgyt.tank.Direction;

import java.util.Random;

/**
 * @author hanrongjie
 * @date 2020/9/7 下午10:56
 */
public class Utils {

    private static final class RandomNumberGeneratorHolder {
        static final Random randomNumberGenerator = new Random();
    }

    public  static Direction randomDirection(Direction original){
        int nextDirection = RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(4);
        Direction  newDirection = original;
        while (newDirection == original) {
            newDirection = Direction.values()[nextDirection];
            nextDirection = RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(4);
        }
        return newDirection;
    }
    public  static Direction reverseDirection(Direction original){
        switch (original){
            case LEFT: return Direction.RIGHT;
            case RIGHT: return Direction.LEFT;
            case UP: return Direction.DOWN;
            case DOWN: return Direction.UP;
            default: return null;
        }





    }

}
