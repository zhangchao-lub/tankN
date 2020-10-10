package Observer.v5;

import java.util.LinkedList;
import java.util.List;

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
  private List<Observer> observers=new LinkedList<>();
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
        for(Observer o:observers){
            o.actionOnWakeUp();
        }
    }
}

interface Observer {
    void actionOnWakeUp();
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        this.feed();
    }
}

class Mum implements Observer{
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp() {
        this.hug();
    }
}

class Dog implements Observer{
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp() {
        this.wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}