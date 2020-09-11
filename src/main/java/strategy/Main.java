package strategy;

import java.util.Arrays;

/**
 * 策略模式
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/8 16:15
 * @descrption
 */
public class Main {
    public static void main(String[] args) {
        int[] a={9,2,5,8,4,6,7,3,1};
        Cat[] c={new Cat(3,3),new Cat(5,1),new Cat(1,5)};
        Dog[] d={new Dog(3),new Dog(5),new Dog(1)};
        Sorter<Cat> sorter=new Sorter();
//        sorter.sort(a);
//        sorter.sort(c);
//        sorter.sort(d);
        sorter.sort(c,new CatHeightComparator());
        System.out.println(Arrays.toString(c));
        sorter.sort(c,(o1,o2)->{
            if(o1.getWeight()<o2.getWeight()){
                return -1;
            }else if(o1.getWeight()>o2.getWeight()){
                return 1;
            }else {
                return 0;
            }
        });
//        sorter.sort(d,new DogFoodComparator());
        System.out.println(Arrays.toString(c));
//        System.out.println(Arrays.toString(d));
    }
}
