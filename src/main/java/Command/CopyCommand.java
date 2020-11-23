package Command;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/10 17:56
 * @descrption
 */
public class CopyCommand extends Command {
    Content c;

    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0, c.msg.length() / 2);
    }
}
