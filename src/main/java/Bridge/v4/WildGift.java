package Bridge.v4;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 16:32
 * @descrption
 */
public class WildGift extends GiftImpl{
    public WildGift(GiftImpl impl){
        this.impl=impl;
    }
}
