package com.dgyt.tank.factory;

import com.dgyt.tank.pojo.BaseBullet;
import com.dgyt.tank.pojo.BaseExplode;
import com.dgyt.tank.pojo.BaseTank;
import com.dgyt.tank.pojo.TankFrame;
import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

/**
 * 如何决定使用抽象类还是接口
 * <p>
 * 一、第一种方式
 * 1.名词抽象类 food
 * 2.形容词接口 movable
 * 二、第二种方式
 * 1.现实中存在的事物抽象类 面包、牛奶
 * 2.拥有某种功能或者行为  如移动、跳
 *
 * @author hanrongjie
 */
public abstract class AbstractGameFactory {
    /**
     * create bullet
     *
     * @param x         location
     * @param y         location
     * @param direction init direction
     * @param group     init group
     * @param tankFrame frame
     * @return BaseBullet
     */
    public abstract BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame);

    /**
     * @param x         location
     * @param y         location
     * @param direction direction
     * @param group     group
     * @param tf        tf
     * @return Tank
     */
    public abstract BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tf);

    /**
     * @param x         location
     * @param y         location
     * @param painting  painting
     * @param tankFrame tf
     * @return Explode
     */
    public abstract BaseExplode createExplode(int x, int y, boolean painting, TankFrame tankFrame);

}
