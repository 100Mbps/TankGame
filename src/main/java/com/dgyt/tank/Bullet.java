package com.dgyt.tank;

import java.awt.*;

public class Bullet extends GameObject{

    public static final int WIDTH = ResourceManager.bulletL.getWidth();
    public static final int HEIGHT = ResourceManager.bulletL.getHeight();
    private static final int SPEED = 10;
    public final Group group;
    Rectangle rect;
    Direction direction;
    private boolean alive = true;

    public Bullet(int x, int y, Direction direction, Group group) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        rect = new Rectangle(x, y, WIDTH, HEIGHT);
    }

    /**
     * @return width
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

    /**
     * @return height
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public void paint(Graphics g) {
        move();
        if (!alive) {
            GameModel.INSTANCE.remove(this);
            return;
        }
        switch (direction) {
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
        }
    }

    private void move() {
        switch (direction) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        //碰撞检测矩形随子弹移动
        rect.x = x;
        rect.y = y;
        this.setAlive();
    }


    private void setAlive() {
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            this.alive = false;
        }
    }

    public void collide(Tank tank) {

    }

    public void die() {
        this.alive = false;
    }
}
