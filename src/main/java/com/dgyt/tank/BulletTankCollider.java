package com.dgyt.tank;

import java.awt.image.BufferedImage;

/**
 * @author hanrongjie
 * @date 2020/9/7 下午10:04
 */
public class BulletTankCollider implements Collider{
    @Override
    public void collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            if (bullet.group == tank.group) return;

            if (bullet.rect.intersects(tank.rect)) {
                tank.die();
                bullet.die();
            }
        }else if(o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        }


    }
}
