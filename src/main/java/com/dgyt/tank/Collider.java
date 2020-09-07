package com.dgyt.tank;

/**
 * 碰撞器
 * @author hanrongjie
 * @date 2020/9/7 下午10:02
 */
public interface Collider {

    void collide(GameObject o1,GameObject o2);
}
