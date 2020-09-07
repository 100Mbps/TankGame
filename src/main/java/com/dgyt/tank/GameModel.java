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
    final java.util.List<GameObject> gos = new ArrayList<>();
    Collider collider = new BulletTankCollider();
    Collider collider2 = new TankCollider();
    public final Tank mainTank ;
    private final ColliderChain chain = new ColliderChain();


    public GameModel(){
        int initTankCount = Integer.parseInt(PropertyManager.get("initTankCount").toString());
        mainTank = new Tank(80, 120, Direction.UP, Group.GOOD, this);
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 * i + 50, 80, Direction.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go){

        gos.add(go);
    }

    public void remove(GameObject go){
        gos.remove(go);
    }


    public void paint(Graphics g){
        Color originalColor = g.getColor();
        g.setColor(Color.YELLOW);
//        g.drawString(String.format("子弹数量:%d", bulletList.size()), 60, 60);
//        g.drawString(String.format("敌人数量:%d", tankList.size()), 60, 40);
        g.setColor(originalColor);
        mainTank.paint(g);
        for (int i = 0; i < gos.size(); i++) {
            gos.get(i).paint(g);
        }
        for(int i=0;i<gos.size()-1;i++){
            for(int j=i+1;j<gos.size();j++){
                GameObject o1 = gos.get(i);
                GameObject o2 = gos.get(j);
                chain.collide(o1,o2);
            }
        }
    }
}
