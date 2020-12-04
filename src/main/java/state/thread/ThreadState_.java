package state.thread;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/4 16:39
 * @descrption
 */
public abstract class ThreadState_ {
    abstract void move(Action input);
    abstract void run();
}
