package com.dgyt.tank.pojo;

import com.dgyt.tank.type.Direction;
import com.dgyt.tank.strategy.FireStrategy;

import java.awt.*;

public abstract class BaseTank {

    public Direction direction;

    private boolean moving = true;

    /**
     * fire
     *
     * @param fs fire strategy
     */
    public abstract void fire(FireStrategy fs);

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public abstract void paint(Graphics g);
}
