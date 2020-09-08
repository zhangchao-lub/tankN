package singleton;

/**
 * lazy loading
 * 懒汉式
 * 什么时候需要，什么时候初始化
 * 缺点：多线程不安全
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/7 17:07
 * @descrption
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            //多线程测试会有问题
//            try{
//                Thread.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            //匿名内部类写法
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    //
//                }
//            });
            //lambob表达式  只有一个方法的匿名内部类简写方法
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
