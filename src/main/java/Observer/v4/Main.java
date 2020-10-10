package Observer.v4;

/**
 * 加入多个观察者
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/27 15:22
 * @descrption
 */
class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Waking up! Crying gagagagaga...");
        cry = true;
        dad.feed();
        mum.hug();
        dog.wang();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}

class Mum {
    public void hug() {
        System.out.println("mum hugging...");
    }
}

class Dog {
    public void wang() {
        System.out.println("dog wang...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}