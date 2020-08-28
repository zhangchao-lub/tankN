import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 15:09
 * @descrption
 */
public class TankFrame extends Frame {
    Tank myTank=new Tank(200,200,null);
    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        myTank.paint(g);

//        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        boolean bU = false;
        boolean bD = false;
        boolean bL = false;
        boolean bR = false;

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                default:
                    break;
            }
            setMainTankDirNull();
        }

        private void setMainTankDir() {
            if (bU) myTank.setDir(Dir.UP);
            if (bD) myTank.setDir(Dir.DOWN);
            if (bL) myTank.setDir(Dir.LEFT);
            if (bR) myTank.setDir(Dir.RIGHT);
        }

        private void setMainTankDirNull() {
            myTank.setDir(null);
        }

    }
}
