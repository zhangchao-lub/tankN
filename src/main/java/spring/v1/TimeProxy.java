package spring.v1;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/28 10:58
 * @descrption
 */
class TimeProxy {

    public void before() {
        System.out.println(">>>start moving.." + System.currentTimeMillis());
    }

    private void after() {
        System.out.println(">>>end moving.." + System.currentTimeMillis());
    }

}
