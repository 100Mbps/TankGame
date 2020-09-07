package com.dgyt.tank;

import java.awt.*;

public class Explode extends GameObject{

    public final static int WIDTH = ResourceManager.explodes[0].getWidth();
    public final static int Height = ResourceManager.explodes[0].getHeight();
    final private GameModel gm;
    boolean painting;
    private int step = 0;

    public Explode(int x, int y, boolean painting, GameModel gm) {
        this.x = x;
        this.y = y;
        this.painting = painting;
        this.gm = gm;
    }
    @Override
    public void paint(Graphics g) {
        if (step++ < ResourceManager.explodes.length - 1) {
            g.drawImage(ResourceManager.explodes[step], x, y, null);
        } else {
            this.gm.remove(this);
        }
    }


}
