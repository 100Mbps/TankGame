package com.dgyt.tank.factory;

import com.dgyt.tank.pojo.*;
import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

/**
 * @author hanrongjie
 */
public class DefaultGameFactory extends AbstractGameFactory {
    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new Bullet(x, y, direction, group, tankFrame);
    }

    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tf) {
        return new Tank(x, y, direction, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, boolean painting, TankFrame tankFrame) {
        return null;
    }
}
