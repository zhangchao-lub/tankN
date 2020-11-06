package Bridge.v4;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 16:27
 * @descrption 分离抽象和现实
 */
public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    private void give(MM mm, Gift g) {
        System.out.println(g.getClass().getName()+" gived!");
    }
}
