package strategy;

/**
 * 比较器
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/8 17:02
 * @descrption
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1,T o2);

    default void m(){
        System.out.println("m");
    }
}
