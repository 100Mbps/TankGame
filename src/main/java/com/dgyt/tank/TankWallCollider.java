package com.dgyt.tank;

import com.dgyt.tank.util.Utils;

/**
 * @author hanrongjie
 * @date 2020/9/8 下午9:12
 */
public class TankWallCollider implements Collider{
    /**
     * @param o1 go1
     * @param o2 go2
     * @return flag true 继续执行其他碰撞检测， false 终止碰撞检测
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Wall && o2 instanceof Tank){
            Wall wall = (Wall) o1;
            Tank tank = (Tank) o2;
            if(wall.rect.intersects(tank.rect)){
                tank.direction = Utils.reverseDirection(tank.direction);
                return  false;
            }
        }else if(o2 instanceof Wall && o1 instanceof Tank){
            return collide(o2,o1);
        }
        return false;
    }
}
