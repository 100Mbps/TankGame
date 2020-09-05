package com.dgyt.tank.factory;

import com.dgyt.tank.Direction;
import com.dgyt.tank.FireStrategy;

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
