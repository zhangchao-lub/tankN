package Iterator.v7;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/28 14:50
 * @descrption
 */
public interface Collection_<E> {
    void add(E o);
    int size();

    Iterator_<E> iterator();
}
