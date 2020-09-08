package com.dgyt.tank;

import java.awt.*;

/**
 * 一堵墙
 * @author hanrongjie
 * @date 2020/9/8 下午9:04
 */
public class Wall  extends GameObject{
   //位置
   int x,y;
   //长宽
   int width,height;

   public  Rectangle rect ;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rectangle(x,y,width,height);
    }

    /**
     * @return width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * 画
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.white);
        g.fillRect(x,y,width,height);
        g.setColor(originalColor);
    }
}
