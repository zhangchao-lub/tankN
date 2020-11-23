package Command;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/10 17:29
 * @descrption
 */
public abstract class Command {
    public abstract void doit();
    public abstract void undo();
}
