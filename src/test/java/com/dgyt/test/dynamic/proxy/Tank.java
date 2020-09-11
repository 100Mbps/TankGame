package com.dgyt.test.dynamic.proxy;

/**
 * @author hanrongjie
 * @date 2020/9/11 下午9:55
 */
public class Tank implements Moveable{
    @Override
    public void move() {
        System.out.println("tank is moving");
    }
}
