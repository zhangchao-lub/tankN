package Observer.v7;

import java.util.LinkedList;
import java.util.List;

/**
 *  有很多时候，观察者需要根据事件的具体情况来进行处理
 *  大多数时候，我们处理事件的时候，需要事件源对象
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

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed",this);
        for (Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

//事件类 fire Event
class WakeUpEvent {
    long timestamp;
    String loc;
    Child source;

    public WakeUpEvent(long timestamp, String loc,Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source=source;
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