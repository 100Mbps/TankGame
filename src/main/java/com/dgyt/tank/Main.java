package com.dgyt.tank;

import java.util.concurrent.TimeUnit;

//Design Pattern Branch
public class Main {

    public static void main(String[] args) {

        final TankFrame frame = new TankFrame("my tank game");

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                    frame.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


}
