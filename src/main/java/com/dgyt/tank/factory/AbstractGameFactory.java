package com.dgyt.tank.factory;

import com.dgyt.tank.Direction;
import com.dgyt.tank.Group;
import com.dgyt.tank.TankFrame;

public abstract class AbstractGameFactory {
    /**
     * create bullet
     *
     * @param x         location
     * @param y         location
     * @param direction init direction
     * @param group     init group
     * @param tankFrame frame
     * @return BaseBullet
     */
    public abstract BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame);

    /**
     * @param x         location
     * @param y         location
     * @param direction direction
     * @param group     gourp
     * @param tf        tf
     * @return Tank
     */
    public abstract BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tf);

    /**
     * @param x         location
     * @param y         location
     * @param painting  painting
     * @param tankFrame tf
     * @return Explode
     */
    public abstract BaseExplode createExplode(int x, int y, boolean painting, TankFrame tankFrame);

}
