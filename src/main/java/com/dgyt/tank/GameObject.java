package com.dgyt.tank;

import java.awt.*;

/**
 * @author hanrongjie
 * @date 2020/9/7 21:42
 */
public abstract class GameObject {
    /**
     * 位置
     */
    int x,y;

    /**
     * 画
     * @param g 画笔
     */
    public abstract  void paint(Graphics g);
}
