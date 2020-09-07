package com.dgyt.tank.strategy;

import com.dgyt.tank.pojo.Bullet;
import com.dgyt.tank.pojo.Tank;

/**
 * @author hanrongjie
 */
public class DefaultFireStrategy implements FireStrategy {

    private DefaultFireStrategy() {
    }

    public static DefaultFireStrategy getInstance() {
        return FireStrategyHolder.INSTANCE;
    }

    @Override
    public void fire(Tank t) {
        int bx = t.x + (Tank.WIDTH - Bullet.WIDTH) / 2;
        int by = t.y + (Tank.HEIGHT - Bullet.HEIGHT) / 2;
        new Bullet(bx, by, t.direction, t.group, t.tf);
    }

    private static class FireStrategyHolder {
        static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
    }
}
