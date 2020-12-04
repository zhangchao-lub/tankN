package state.thread;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/4 16:40
 * @descrption
 */
public class TeriminatedState extends ThreadState_ {
    private Thread_ t;

    public TeriminatedState(Thread_ t) {
        this.t = t;
    }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}
