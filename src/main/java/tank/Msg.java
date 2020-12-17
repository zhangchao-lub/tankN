package tank;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/17 9:42
 * @descrption
 */
public abstract class Msg {
    public abstract void handle();
    public abstract byte[] toBytes();
    public abstract void parse(byte[] bytes);
    public abstract MsgType getMsgType();

}
