package com.dgyt.tank;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hanrongjie
 * @date 2020/9/7 下午11:10
 */
public class ColliderChain implements Collider{

    private final List<Collider> chain = new LinkedList<>();

    public ColliderChain(){
        chain.add(new TankCollider());
        chain.add(new BulletTankCollider());
        chain.add(new TankWallCollider());
    }
    @Override
    public boolean  collide(GameObject o1,GameObject o2){
        for(Collider collider :chain){
           boolean flag =  collider.collide(o1,o2);
           if(!flag) return false;
        }
        return true;
    }

}
