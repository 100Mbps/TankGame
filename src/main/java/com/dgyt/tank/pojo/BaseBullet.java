package com.dgyt.tank.pojo;

import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

import java.awt.*;

public abstract class BaseBullet {
    /**
     * 子弹默认速度
     */
    protected int SPEED = 10;
    /**
     * 位置
     */
    protected  int x,y;

    /**
     *方向
     */
    protected Direction direction;
    /**
     * 组别
     */
    protected Group group;
    /**
     * 窗体
     */
    protected TankFrame tankFrame;

    /**
     * 绘制子弹
     * @param g 画笔
     */
    public abstract void paint(Graphics g);

    /**
     * 与tank碰撞后的行为
     * @param tank tank
     */
    public abstract  void collide(BaseTank tank);
}
