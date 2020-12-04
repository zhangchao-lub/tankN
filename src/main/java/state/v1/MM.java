package state.v1;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/4 16:08
 * @descrption 增加新的状态时非常不方便
 */
public class MM {
    String name;
    private enum MMState{
        HAPPY,SAD
    }
    MMState state;
    public void smile(){

    }
    public void cry(){

    }
    public void say(){

    }
}
