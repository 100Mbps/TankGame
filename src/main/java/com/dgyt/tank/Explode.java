package com.dgyt.tank;

import java.awt.*;

public class Explode {

    public final static int WIDTH = ResourceManager.explodes[0].getWidth();
    public final static int Height = ResourceManager.explodes[0].getHeight();
    final private TankFrame tankFrame;
    int x, y;
    boolean painting;
    private int step = 0;

    public Explode(int x, int y, boolean painting, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.painting = painting;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (step++ < ResourceManager.explodes.length - 1 && painting) {
            g.drawImage(ResourceManager.explodes[step], x, y, null);
        } else {
            this.tankFrame.explode.remove(this);
        }
    }


}
