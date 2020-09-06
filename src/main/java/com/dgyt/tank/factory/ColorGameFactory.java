package com.dgyt.tank.factory;

import com.dgyt.tank.pojo.BaseBullet;
import com.dgyt.tank.pojo.BaseExplode;
import com.dgyt.tank.pojo.BaseTank;
import com.dgyt.tank.pojo.TankFrame;
import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

public class ColorGameFactory extends AbstractGameFactory {
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
    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return null;
    }

    /**
     * @param x         location
     * @param y         location
     * @param direction direction
     * @param group     group
     * @param tf        tf
     * @return Tank
     */
    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tf) {
        return null;
    }

    /**
     * @param x         location
     * @param y         location
     * @param painting  painting
     * @param tankFrame tf
     * @return Explode
     */
    @Override
    public BaseExplode createExplode(int x, int y, boolean painting, TankFrame tankFrame) {
        return null;
    }
}
