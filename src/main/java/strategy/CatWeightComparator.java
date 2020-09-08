package strategy;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/8 17:23
 * @descrption
 */
public class CatWeightComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getWeight() < o2.getWeight()) {
            return -1;
        } else if (o1.getWeight() > o2.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
