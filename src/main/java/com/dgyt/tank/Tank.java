package com.dgyt.tank;

import java.awt.*;
import java.util.Dictionary;
import java.util.Random;

public class Tank {

    private static final int SPEED = 5;
    private int x = 80;
    private int y = 80;
    private boolean moving = true;
    private final TankFrame tf;
    Rectangle rect;
    Group group;
    private final Random random = new Random();
    boolean alive = true;
    public static  final int WIDTH = ResourceManager.tankL.getWidth();
    public static  final int HEIGHT = ResourceManager.tankL.getHeight();
    Direction direction;
    private int time;
    public Tank(int x, int y, Direction direction,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
        this.group = group;
        rect  = new Rectangle(x,y,WIDTH,HEIGHT);
    }
    public void paint(Graphics g) {
        if(!alive) {
            tf.tankList.remove(this);
            return;
        }
        switch (direction){
            case LEFT:
                g.drawImage(ResourceManager.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceManager.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD,x,y,null);
                break;
        }
        move();
    }

    private void move(){
        if(moving) {
            switch (direction) {
                case LEFT:
                    if(x >0){
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
        if(this.group == Group.BAD){
            autoFire();
            autoChangeDirectionV2();
        }

    }

    /**
     * 碰壁转向+距离检测
     */
    private void autoChangeDirectionV2(){
        time++;
        if (x <= 0 || (x + Tank.WIDTH >= TankFrame.GAME_WIDTH) ||(y <= 0)||y+Tank.HEIGHT >= TankFrame.GAME_HEIGHT) {
            this.autoChangeDirection();
        }
        if(time*SPEED >=200){
            randomDirection(this.direction);
            time = 0;
        }
    }

    /**
     * 碰壁转向
     */
    private void autoChangeDirection(){

        switch (this.direction){
            case LEFT:
                 if(x <= 0){
                     this.randomDirection(Direction.LEFT);
                 }
                 break;
            case RIGHT:
                if(x+Tank.WIDTH >= TankFrame.GAME_WIDTH){
                    this.randomDirection(Direction.RIGHT);
                }
                break;
            case UP:
                if(y <= 0){
                    this.randomDirection(Direction.UP);
                }
                break;
            case DOWN:
                if(y+Tank.HEIGHT >= TankFrame.GAME_HEIGHT){
                    this.randomDirection(Direction.DOWN);
                }
                break;
        }
    }



    private void autoFire(){
        if(random.nextInt(10) >8) this.fire();
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
      int bx = x + (WIDTH - Bullet.WIDTH)/2;
      int by = y + (HEIGHT - Bullet.HEIGHT)/2;
      tf.bulletList.add(new Bullet(bx,by,this.direction,this.group,this.tf));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void die() {
        alive = false;
        int eX = x+(Tank.WIDTH - Explode.WIDTH)/2;
        int eY = y+(Tank.HEIGHT - Explode.Height)/2;
        tf.explode.add(new Explode(eX,eY,true,this.tf));
    }

    private void randomDirection(Direction original){
        int nextDirection = random.nextInt(4);
        while(this.direction == original){
            this.direction = Direction.values()[nextDirection];
            nextDirection = random.nextInt(4);
        }
    }
}
