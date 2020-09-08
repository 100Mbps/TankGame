package com.dgyt.tank;

import java.awt.*;

public class Explode extends GameObject{

    public final static int WIDTH = ResourceManager.explodes[0].getWidth();
    public final static int Height = ResourceManager.explodes[0].getHeight();
    boolean painting;
    private int step = 0;

    public Explode(int x, int y, boolean painting) {
        this.x = x;
        this.y = y;
        this.painting = painting;
    }
    @Override
    public void paint(Graphics g) {
        if (step++ < ResourceManager.explodes.length - 1) {
            g.drawImage(ResourceManager.explodes[step], x, y, null);
        } else {
            GameModel.INSTANCE.remove(this);
        }
    }


}
