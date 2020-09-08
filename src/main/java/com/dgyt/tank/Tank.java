package com.dgyt.tank;

import com.dgyt.tank.util.Utils;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject{

    public static final int WIDTH = ResourceManager.tankL.getWidth();
    public static final int HEIGHT = ResourceManager.tankL.getHeight();
    private static final int SPEED = 5;
    private final Random random = new Random();
    Rectangle rect;
    Group group;
    boolean alive = true;
    Direction direction;
    private boolean moving = true;
    private int time;

    public Tank(int x, int y, Direction direction, Group group) {
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
        if (!alive) {
            GameModel.INSTANCE.remove(this);
            return;
        }
        switch (direction) {
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        if (moving) {
            switch (direction) {
                case LEFT:
                    if (x > 0) {
                        x -= SPEED;
                    }
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

        }
        //碰撞检测矩形随坦克移动
        rect.x = x;
        rect.y = y;
        if (this.group == Group.BAD) {
            autoFire();
            autoChangeDirectionV2();
        }

    }

    /**
     * 碰壁转向+距离检测
     */
    private void autoChangeDirectionV2() {
        time++;
        if (x <= 0 || (x + Tank.WIDTH >= TankFrame.GAME_WIDTH) || (y <= 0) || y + Tank.HEIGHT >= TankFrame.GAME_HEIGHT) {
            this.autoChangeDirection();
        }
        if (time * SPEED >= 200) {
            randomDirection();
            time = 0;
        }
    }

    /**
     * 随机向某个方向转向
     */
    public void autoChangeDirection() {

        switch (this.direction) {
            case LEFT:
                if (x <= 0) {
                    this.randomDirection();
                }
                break;
            case RIGHT:
                if (x + Tank.WIDTH >= TankFrame.GAME_WIDTH) {
                    this.randomDirection();
                }
                break;
            case UP:
                if (y <= 0) {
                    this.randomDirection();
                }
                break;
            case DOWN:
                if (y + Tank.HEIGHT >= TankFrame.GAME_HEIGHT) {
                    this.randomDirection();
                }
                break;
        }
    }


    private void autoFire() {
        if (random.nextInt(10) > 8) this.fire(DefaultFireStrategy.getInstance());
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire(FireStrategy s) {
        s.fire(this);
    }
    public void die() {
        alive = false;
        int eX = x + (Tank.WIDTH - Explode.WIDTH) / 2;
        int eY = y + (Tank.HEIGHT - Explode.HEIGHT) / 2;
        GameModel.INSTANCE.add(new Explode(eX, eY, true));
    }

    /**
     * 改变方向
     */
    public void randomDirection() {
       this.direction =  Utils.randomDirection(this.direction);
    }
}
