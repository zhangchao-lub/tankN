package state.thread;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/4 16:38
 * @descrption
 */
public class Thread_ {
    ThreadState_ state;

    void move(Action input){
        state.move(input);
    }
    void run(){
        state.run();
    }
}
