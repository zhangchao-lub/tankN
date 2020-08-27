import java.awt.*;
import java.awt.event.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 15:09
 * @descrption
 */
public class TankFrame extends Frame {
    int x = 200, y = 200;

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        System.out.println("paint");
        g.fillRect(x, y, 50, 50);
//        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            System.out.println("key press");
            x += 30;
            y += 30;
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            System.out.println("key release");
        }

    }
}
