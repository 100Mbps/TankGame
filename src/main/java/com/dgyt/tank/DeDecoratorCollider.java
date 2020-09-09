package com.dgyt.tank;

/**
 * 给装饰者扒皮，呈现本来对象面貌
 * @author hanrongjie
 * @date 2020/9/9 下午10:31
 */
public class DeDecoratorCollider implements Collider{
    /**
     * @param o1 go1
     * @param o2 go2
     * @return flag true 继续执行其他碰撞检测， false 终止碰撞检测
     */
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        while(o1 instanceof  GoDecrator){
            o1 = ((GoDecrator) o1).go;
        }
        while (o2 instanceof  GoDecrator){
            o2  = ((GoDecrator) o2).go;
        }
        return new ColliderChain().collide(o1,o2);
    }
}
