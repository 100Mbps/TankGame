package com.dgyt.tank;

import java.awt.*;

public class Bullet {

    private static final int SPEED = 10;
    private int x;
    private int y;
    private final TankFrame tankFrame;
    private boolean alive = true;
    public static  final int WIDTH = ResourceManager.bulletL.getWidth();
    public static  final int HEIGHT = ResourceManager.bulletL.getHeight();
    private final Group group;
    Rectangle rect;
    Direction direction;

    public Bullet(int x, int y, Direction direction,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
        this.group = group;
        rect  = new Rectangle(x,y,WIDTH,HEIGHT);
    }

    public void paint(Graphics g) {
        move();
        if(!alive) {
            tankFrame.bulletList.remove(this);
            return;
        }
        switch (direction){
            case LEFT:
                g.drawImage(ResourceManager.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceManager.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD,x,y,null);
                break;
        }
    }
    private void move(){
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
        this.setAlive();
    }


    private void setAlive(){
       if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
           this.alive =false;
       }
    }

    public void collide(Tank tank) {
           if(this.group == tank.group)  return;
           this.rect.x = this.x;
           this.rect.y = this.y;
           tank.rect.x = tank.getX();
           tank.rect.y = tank.getY();
           if(this.rect.intersects(tank.rect)){
               tank.die();
               this.die();
           }
    }

    private void die() {
      this.alive = false;
    }
}
