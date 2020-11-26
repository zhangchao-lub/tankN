package prototype.v3;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/25 16:31
 * @descrption
 */
public class Test2 {
    private final static Executor executor = Executors.newCachedThreadPool();//启用多线程
    public static void main(String[] args) {

        for(int i=0;i<=4000;i++){
            final int j=i;                                                                                                                                  //关键是这一句代码，将 i 转化为  j，这样j 还是final类型的参与线程
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println(j);
                    }catch(Exception e){


                    }
                }
            });
        }


    }


}
