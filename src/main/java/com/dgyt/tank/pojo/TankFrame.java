package com.dgyt.tank.pojo;

import com.dgyt.tank.factory.AbstractGameFactory;
import com.dgyt.tank.factory.DefaultGameFactory;
import com.dgyt.tank.strategy.ColorBulletStrategy;
import com.dgyt.tank.strategy.FourDirectionFireStrategy;
import com.dgyt.tank.type.Direction;
import com.dgyt.tank.type.Group;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class TankFrame extends Frame {

    public final static AbstractGameFactory GAME_FACTORY = new DefaultGameFactory();
    final static int GAME_WIDTH = 1200, GAME_HEIGHT = 600;
    final java.util.List<BaseBullet> bulletList = new ArrayList<>();
    public final java.util.List<BaseTank> tankList = new ArrayList<>();
    final java.util.List<BaseExplode> explode = new ArrayList<>();
    private final BaseTank goodTank = GAME_FACTORY.createTank(80, 120, Direction.UP, Group.GOOD, this);
    Image offScreenImage = null;

    public TankFrame(String name) {
        super.setVisible(true);
        super.setResizable(true);
        super.setName(name);
        super.setTitle(name);
        super.setSize(GAME_WIDTH, GAME_HEIGHT);
        super.addWindowListener(new WindowAdapter() {
            // close frame
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        super.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawString(String.format("子弹数量:%d", bulletList.size()), 60, 60);
        g.drawString(String.format("敌人数量:%d", tankList.size()), 60, 40);
        g.setColor(originalColor);
        goodTank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).paint(g);
        }
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tankList.size(); j++) {
                bulletList.get(i).collide(tankList.get(j));
            }
        }
        for (int i = 0; i < explode.size(); i++) {
            explode.get(i).paint(g);
        }
    }

    // 造成原因为，屏幕的刷新频率高于画的频率，
    //解决屏幕闪烁问题，首先将需要画的内容画到一张图里，待图完成后，刷到frame上。
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    class MyKeyListener implements KeyListener {
        // 如果同时按两个键怎么处理
        //up
        private boolean bU = false;
        //Down
        private boolean bD = false;
        //Left
        private boolean bL = false;
        //Right
        private boolean bR = false;

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            // 39 ->
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainDirection();
        }

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    goodTank.fire(ColorBulletStrategy.getInstance());
                    break;
                default:
                    break;
            }
            setMainDirection();
        }

        private void setMainDirection() {
            if (!bL && !bR && !bU && !bD) {
                goodTank.setMoving(false);
            } else {
                if (bL) goodTank.direction = Direction.LEFT;
                if (bR) goodTank.direction = Direction.RIGHT;
                if (bU) goodTank.direction = Direction.UP;
                if (bD) goodTank.direction = Direction.DOWN;
                goodTank.setMoving(true);
            }
        }
    }


}


