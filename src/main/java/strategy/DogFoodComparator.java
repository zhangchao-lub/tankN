package strategy;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/8 17:22
 * @descrption
 */
public class DogFoodComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.getFood() < o2.getFood()) {
            return -1;
        } else if (o1.getFood() > o2.getFood()) {
            return 1;
        } else {
            return 0;
        }
    }
}
