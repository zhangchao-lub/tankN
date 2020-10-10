package Observer.v2;

/**
 * 面向对象的傻等
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/27 15:22
 * @descrption
 */
class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Waking up! Crying gagagagaga...");
        cry = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }
}