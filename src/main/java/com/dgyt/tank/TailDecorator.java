package com.dgyt.tank;

import java.awt.*;

/**
 * @author hanrongjie
 * @date 2020/9/8 下午11:27
 */
public class TailDecorator extends GoDecrator {

    public TailDecorator(GameObject go) {
        super(go);
    }

    /**
     * @return width
     */
    @Override
    public int getWidth() {
        return go.getWidth();
    }

    /**
     * @return height
     */
    @Override
    public int getHeight() {
        return go.getHeight();
    }

    @Override
    public void paint(Graphics g) {
          go.paint(g);
          Color originalColor = g.getColor();
          g.setColor(Color.yellow);
          this.x = go.x;
          this.y = go.y;
          g.fillOval(x,y,10,10);
          g.setColor(originalColor);
    }
}
