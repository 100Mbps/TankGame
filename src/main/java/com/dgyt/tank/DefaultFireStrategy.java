package com.dgyt.tank;

/**
 *
 */
public class DefaultFireStrategy implements FireStrategy {

    private DefaultFireStrategy() {
    }

    public static DefaultFireStrategy getInstance() {
        return FireStrategyHolder.instance;
    }
    private static class FireStrategyHolder {
        static final DefaultFireStrategy instance = new DefaultFireStrategy();
    }


    @Override
    public void fire(Tank t) {
        int bx = t.x + (Tank.WIDTH - Bullet.WIDTH) / 2;
        int by = t.y + (Tank.HEIGHT - Bullet.HEIGHT) / 2;
        new Bullet(bx, by, t.direction, t.group, t.tf);
    }
}
