package Command;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/10 18:02
 * @descrption
 */
public class DeleteCommand extends Command {
    Content c;
    String deleted;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        deleted = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
    }

    @Override
    public void undo() {
        c.msg = deleted + c.msg;
    }
}
