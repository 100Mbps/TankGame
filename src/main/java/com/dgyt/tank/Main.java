package com.dgyt.tank;

import com.dgyt.tank.pojo.Tank;
import com.dgyt.tank.pojo.TankFrame;
import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

import java.util.concurrent.TimeUnit;

//Design Pattern Branch
public class Main {

    public static void main(String[] args) {
        int initTankCount = Integer.parseInt(PropertyManager.get("initTankCount").toString());
        final TankFrame frame = new TankFrame("my tank game");
        for (int i = 0; i < initTankCount; i++) {
            frame.tankList.add(TankFrame.GAME_FACTORY.createTank(50 * i + 50, 80, Direction.DOWN, Group.BAD, frame));
        }
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                frame.repaint();
            }
        }).start();
    }


}
