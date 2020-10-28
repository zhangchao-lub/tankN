package Iterator.v5;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/28 14:50
 * @descrption
 */
public interface Collection_ {
    void add(Object o);
    int size();

    Iterator_ iterator();
}
