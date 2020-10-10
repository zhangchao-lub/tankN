package Observer.v9;


import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/9 16:41
 * @descrption
 */
public class TestFrame extends Frame {
    public void launch() {
        Button b=new Button("press me");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.setLocation(600, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }

    private class MyActionListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ((Button)e.getSource()).setLabel("press me again!");
            System.out.println("button pressed!");
        }

    }

    private class MyActionListener2 implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed 2!");
        }
    }
}
