package com.dgyt.tank.pojo;

import com.dgyt.tank.ResourceManager;

import java.awt.*;

/**
 * @author hanrongjie
 */
public class Explode extends BaseExplode {

    public final static int WIDTH = ResourceManager.EXPLODES[0].getWidth();
    public final static int HEIGHT = ResourceManager.EXPLODES[0].getHeight();
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
        if (step++ < ResourceManager.EXPLODES.length - 1) {
            g.drawImage(ResourceManager.EXPLODES[step], x, y, null);
        } else {
            this.tankFrame.explode.remove(this);
        }
    }


}
