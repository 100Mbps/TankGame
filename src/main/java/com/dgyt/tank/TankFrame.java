package com.dgyt.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame {
    final static int GAME_WIDTH = 1200, GAME_HEIGHT = 600;
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
        GameModel.INSTANCE.paint(g);
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
            Tank mainTank = GameModel.INSTANCE.mainTank;
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
                    mainTank.fire(FourDirectionFireStrategy.getInstance());
                    break;
                default:
                    break;
            }
            setMainDirection();
        }

        private void setMainDirection() {
            Tank mianTank = GameModel.INSTANCE.mainTank;
            if (!bL && !bR && !bU && !bD) {
                mianTank.setMoving(false);
            } else {
                if (bL) mianTank.direction = Direction.LEFT;
                if (bR) mianTank.direction = Direction.RIGHT;
                if (bU) mianTank.direction = Direction.UP;
                if (bD) mianTank.direction = Direction.DOWN;
                mianTank.setMoving(true);
            }
        }
    }


}


