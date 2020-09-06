package com.dgyt.tank.pojo;

import com.dgyt.tank.type.Direction;
import com.dgyt.tank.strategy.FireStrategy;
import com.dgyt.tank.type.Group;

import java.awt.*;

public abstract class BaseTank {

    /**
     * move direction
     */
    public Direction direction;
    /**
     * tank type good or bad
     */
    public Group group;

    public int x,y;

    public Rectangle rect;

    private boolean moving = true;

    /**
     * fire
     *
     * @param fs fire strategy
     */
    public abstract void fire(FireStrategy fs);

    /**
     *
     */
    public abstract  void die();

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public abstract void paint(Graphics g);
}
