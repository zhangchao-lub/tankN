package flyweight;

/**
 * String 就是享元模式
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/10 15:31
 * @descrption
 */
public class TestString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s1);
        System.out.println(s3.intern() == s4.intern());
    }
}
