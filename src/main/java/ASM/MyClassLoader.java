package ASM;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/2 17:14
 * @descrption
 */
public class MyClassLoader extends ClassLoader{
    public Class defineClass(String name,byte[] b){
        return defineClass(name,b,0,b.length);
    }
}
