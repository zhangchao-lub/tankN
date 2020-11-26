package Command;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/10 17:29
 * @descrption 命令/事务 模式
 *             宏命令: command 与 树状结构
 *           多次undo: command 与
 *    transaction回滚;
 */
public abstract class Command {
    public abstract void doit();
    public abstract void undo();
}
