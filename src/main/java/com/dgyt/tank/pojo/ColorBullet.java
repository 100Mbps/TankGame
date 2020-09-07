package com.dgyt.tank.pojo;

import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

import java.awt.*;

public class ColorBullet extends BaseBullet {

    private Rectangle rect;

    private int width, height;

    private Color[] colors = new Color[]{Color.red, Color.green, Color.white, Color.cyan};

    private int curColor;

    public ColorBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
        this.group = group;
        this.height = 10;
        this.width = 10;
        rect = new Rectangle(x, y, width, height);
        this.tankFrame.bulletList.add(this);
    }

    /**
     * 绘制子弹
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        //是否出屏幕
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            this.tankFrame.bulletList.remove(this);
            return;
        }
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
        Color originalColor = g.getColor();
        if (curColor == colors.length) curColor = 0;
        g.setColor(colors[curColor++]);
        g.fillOval(x, y, width, height);
        g.setColor(originalColor);
    }

    private void die() {
        this.tankFrame.bulletList.remove(this);
    }

    /**
     * 与tank碰撞后的行为
     *
     * @param tank tank
     */
    @Override
    public void collide(BaseTank tank) {
        if (this.group == tank.group) return;
        this.rect.x = this.x;
        this.rect.y = this.y;
        tank.rect.x = tank.x;
        tank.rect.y = tank.y;
        if (this.rect.intersects(tank.rect)) {
            tank.die();
            this.die();
        }
    }

}
