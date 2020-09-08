package com.dgyt.tank;

import java.awt.*;

/**
 * @author hanrongjie
 * @date 2020/9/8 下午11:25
 */
public abstract class GoDecrator extends GameObject{

    protected GameObject go;

    public GoDecrator(GameObject go) {
        this.go = go;
    }
    public abstract void paint(Graphics g);
}
