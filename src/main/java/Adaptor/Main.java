package Adaptor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 15:10
 * @descrption  接口转换器/包装器/适配器 Adaptor
 * 使用场景：1，电压转接头
 *           2，java.io
 *           3，jdbc.odbc bridge(不是桥接模式)
 *           4，ASM transformer
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\GZWX\\Desktop\\项目网址.txt");
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        String line;
        while ((line=br.readLine())!=null) {
            System.out.println(line);
        }
        br.close();

    }
}

/**
 * 常见的Adaptor反而不是Adaptor
 * 如 WindowAdaptor
 *    keyAdaptor
 * */
class Test{

    public static void main(String[] args) {
        Frame f=new Frame();
        f.addWindowListener(new WindowAdapter() {
            //实现自己想重写的方法

        });
    }
}
