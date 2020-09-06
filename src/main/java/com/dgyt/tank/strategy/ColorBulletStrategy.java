package com.dgyt.tank.strategy;

import com.dgyt.tank.pojo.Bullet;
import com.dgyt.tank.pojo.ColorBullet;
import com.dgyt.tank.pojo.Tank;
import com.dgyt.tank.type.Direction;

public class ColorBulletStrategy implements FireStrategy{


    private static class FireStrategyHolder {
        static final ColorBulletStrategy instance = new ColorBulletStrategy();
    }

    public static ColorBulletStrategy getInstance() {
        return ColorBulletStrategy.FireStrategyHolder.instance;
    }

    @Override
    public void fire(Tank t) {
        int bx = t.x + (Tank.WIDTH - Bullet.WIDTH) / 2;
        int by = t.y + (Tank.HEIGHT - Bullet.HEIGHT) / 2;
        for (Direction direction : Direction.values()) {
            new ColorBullet(bx, by, direction, t.group, t.tf);
        }
    }
}
