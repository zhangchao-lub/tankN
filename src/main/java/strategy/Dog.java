package strategy;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/8 16:52
 * @descrption
 */
public class Dog implements Comparable<Dog> {

    private int food;

    public Dog() {

    }

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog d) {
        if (this.food < d.food) {
            return -1;
        } else if (this.food > d.food) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
