package com.dgyt.tank;

/**
 * 碰撞器
 * @author hanrongjie
 * @date 2020/9/7 下午10:02
 */
public interface Collider {
    /**
     *
     * @param o1 go1
     * @param o2 go2
     * @return  flag true 继续执行其他碰撞检测， false 终止碰撞检测
     */
    boolean collide(GameObject o1,GameObject o2);
}
