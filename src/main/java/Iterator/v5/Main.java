package Iterator.v5;

/**
 * v1:用数组构建一个容器，可以添加对象
 * v2:用链表来实现一个容器
 * v3:添加容器的共同接口，实现容器的替换
 * v4:如何对容器遍历呢？
 * v5:使用Iterator接口
 */
public class Main {
    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s") + i);
        }
        System.out.println(list.size());

        //Iterator接口的调用方法
        Iterator_ it=list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}