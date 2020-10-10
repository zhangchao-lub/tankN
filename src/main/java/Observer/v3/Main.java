package Observer.v3;

/**
 * 加入观察者
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/27 15:22
 * @descrption
 */
class Child {
    private boolean cry = false;
    private Dad d = new Dad();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Waking up! Crying gagagagaga...");
        cry = true;
        d.feed();
    }
}

class Dad {

    public void feed() {
        System.out.println("dad feeding...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}