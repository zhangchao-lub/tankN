package singleton;

import java.util.Date;

/**
 * 静态内部类的方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/7 17:07
 * @descrption
 */
public class Mgr07 {

    private Mgr07() {
    }

    private static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Long startTime=new Date().getTime();
        for (int i = 0; i < 10000; i++) {
//            //匿名内部类写法
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    //
//                }
//            });
            //lambob表达式  只有一个方法的匿名内部类简写方法
            new Thread(() -> {
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
        Long endTime=new Date().getTime();
        System.out.println("耗时:"+(endTime-startTime));
    }
}
