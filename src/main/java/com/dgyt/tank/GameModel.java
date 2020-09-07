package com.dgyt.tank;

import java.awt.*;
import java.util.ArrayList;


/**
 * @author hanrongjie
 * @date 2020/9/7
 *
 * MVC 之 model
 *
 */
public class GameModel {
    final java.util.List<Bullet> bulletList = new ArrayList<>();
    final java.util.List<Tank> tankList = new ArrayList<>();
    final java.util.List<Explode> explode = new ArrayList<>();
    public final Tank mainTank ;


    public GameModel(){
        int initTankCount = Integer.parseInt(PropertyManager.get("initTankCount").toString());
        mainTank = new Tank(80, 120, Direction.UP, Group.GOOD, this);
        for (int i = 0; i < initTankCount; i++) {
            tankList.add(new Tank(50 * i + 50, 80, Direction.DOWN, Group.BAD, this));
        }
    }


    public void paint(Graphics g){
        Color originalColor = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawString(String.format("子弹数量:%d", bulletList.size()), 60, 60);
        g.drawString(String.format("敌人数量:%d", tankList.size()), 60, 40);
        g.setColor(originalColor);
        mainTank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).paint(g);
        }
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tankList.size(); j++) {
                bulletList.get(i).collide(tankList.get(j));
            }
        }
        for (int i = 0; i < explode.size(); i++) {
            explode.get(i).paint(g);
        }
    }
}
