package com.dgyt.tank.strategy;

import com.dgyt.tank.pojo.Bullet;
import com.dgyt.tank.pojo.Tank;
import com.dgyt.tank.type.Direction;

/**
 * @author hanrongjie
 */
public class FourDirectionFireStrategy implements FireStrategy {

    private FourDirectionFireStrategy() {
    }

    public static FourDirectionFireStrategy getInstance() {
        return FourDirectionFireStrategy.FireStrategyHolder.INSTANCE;
    }

    @Override
    public void fire(Tank t) {
        int bx = t.x + (Tank.WIDTH - Bullet.WIDTH) / 2;
        int by = t.y + (Tank.HEIGHT - Bullet.HEIGHT) / 2;
        for (Direction direction : Direction.values()) {
            new Bullet(bx, by, direction, t.group, t.tf);
        }
    }

    private static class FireStrategyHolder {
        static final FourDirectionFireStrategy INSTANCE = new FourDirectionFireStrategy();
    }

}
