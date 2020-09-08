package com.dgyt.tank;

import com.dgyt.tank.util.Utils;

/**
 * @author hanrongjie
 * @date 2020/9/7 下午10:28
 */
public class TankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof  Tank && o2 instanceof Tank){
             Tank tank1 = (Tank) o1;
             Tank tank2 = (Tank) o2;
             if(tank1.rect.intersects(tank2.rect)){
                  tank1.direction = Utils.reverseDirection(tank1.direction);
                  tank2.direction = Utils.reverseDirection(tank2.direction);
             }
        }
        return  true;

    }
}
