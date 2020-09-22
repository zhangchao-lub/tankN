package aTank;

import aTank.service.TankFrame;
import aTank.util.Audio;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 14:57
 * @descrption
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //播放游戏登陆音效
        new Thread(() -> new Audio("war1.wav").play()).start();

        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
