package com.dgyt.tank;

import java.awt.*;

/**
 * @author hanrongjie
 * @date 2020/9/8 下午11:40
 */
public class RectDecorator extends GoDecrator{

    public RectDecorator(GameObject go) {
        super(go);
    }

    /**
     * @return width
     */
    @Override
    public int getWidth() {
        return 0;
    }

    /**
     * @return height
     */
    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void paint(Graphics g) {
           go.paint(g);
           this.x = go.x;
           this.y = go.y;
          Color original =  g.getColor();
          g.setColor(Color.red);
          g.drawRect(x,y,go.getWidth(),go.getHeight());
          g.setColor(original);
    }
}
