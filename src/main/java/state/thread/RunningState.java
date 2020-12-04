package state.thread;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/4 16:39
 * @descrption
 */
public class RunningState extends ThreadState_{
    Thread_ t;

    public RunningState(Thread_ t) {
        this.t = t;
    }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}
