package Observer.v6;

import java.util.LinkedList;
import java.util.List;

/**
 * 分离观察者和被观察者
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/27 15:22
 * @descrption
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new LinkedList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Waking up! Crying gagagagaga...");
        cry = true;

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed");
        for (Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

//事件类 fire Event
class WakeUpEvent {
    long timestamp;
    String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

interface Observer {
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        this.feed();
    }

}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        this.hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        this.wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}