package com.dgyt.tank;

/**
 * @author hanrongjie
 * @date 2020/9/7 下午10:04
 */
public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            if (bullet.group == tank.group) return false;

            if (bullet.rect.intersects(tank.rect)) {
                tank.die();
                bullet.die();
                return false;
            }else{
                return true;
            }

        }else if(o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
