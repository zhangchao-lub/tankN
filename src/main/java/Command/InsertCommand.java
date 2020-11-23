package Command;

import java.io.InputStreamReader;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/10 17:31
 * @descrption
 */
public class InsertCommand extends Command {

    Content c;
    String strToCommand = "http://www.dachapge.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + strToCommand;
    }

    @Override
    public void undo() {
        c.msg =c.msg.substring(0,c.msg.length()-strToCommand.length());
    }
}
