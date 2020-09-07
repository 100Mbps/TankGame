package com.dgyt.tank.pojo;

import com.dgyt.tank.ResourceManager;
import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

import java.awt.*;

public class Bullet extends BaseBullet {

    public static final int WIDTH = ResourceManager.bulletL.getWidth();
    public static final int HEIGHT = ResourceManager.bulletL.getHeight();
    //static final int SPEED = 10;
    private final TankFrame tankFrame;
    private final Group group;
    Rectangle rect;
    Direction direction;
    private int x;
    private int y;
    private boolean alive = true;

    public Bullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
        this.group = group;
        rect = new Rectangle(x, y, WIDTH, HEIGHT);
        this.tankFrame.bulletList.add(this);
    }

    @Override
    public void paint(Graphics g) {
        move();
        if (!alive) {
            tankFrame.bulletList.remove(this);
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
            default:break;
        }
    }

    public void move() {
        switch (direction) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:break;
        }
        this.setAlive();
    }


    private void setAlive() {
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            this.alive = false;
        }
    }

    @Override
    public void collide(BaseTank tank) {
        if (this.group == tank.group) {
            return;
        }
        this.rect.x = this.x;
        this.rect.y = this.y;
        tank.rect.x = tank.x;
        tank.rect.y = tank.y;
        if (this.rect.intersects(tank.rect)) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.alive = false;
    }
}
