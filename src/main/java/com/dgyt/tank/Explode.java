package com.dgyt.tank;

import com.dgyt.tank.factory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {

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

    @Override
    public void paint(Graphics g) {
        if (step++ < ResourceManager.explodes.length - 1) {
            g.drawImage(ResourceManager.explodes[step], x, y, null);
        } else {
            this.tankFrame.explode.remove(this);
        }
    }


}
