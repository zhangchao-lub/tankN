package netty;

import lombok.extern.slf4j.Slf4j;
import tank.*;

import java.io.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/14 17:38
 * @descrption
 */
@Slf4j
public class BulletNewMsg extends Msg {
    public int x, y;
    public Dir dir;
    public Group group;

    public BulletNewMsg() {
    }

    public BulletNewMsg(Bullet b) {
        this.x =b.getX();
        this.y = b.getY();
        this.dir = b.getDir();
        this.group = b.getGroup();
    }

    public BulletNewMsg(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
    }

    public void parse(byte[] bytes) {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        try {
            //TODO:先读TYPE信息，根据类型处理不同的数据
            //掠过消息类型

            this.x = dis.readInt();
            this.y = dis.readInt();
            this.dir = Dir.values()[dis.readInt()];
            this.group = Group.values()[dis.readInt()];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.BulletNew;
    }

    @Override
    public byte[] toBytes() {
        ByteArrayOutputStream baos = null;
        DataOutputStream dos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
            dos.writeInt(x);
            dos.writeInt(y);
            dos.writeInt(dir.ordinal());
            dos.writeInt(group.ordinal());
            dos.flush();
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName())
                .append("[")
                .append("x=" + x + " | ")
                .append("y=" + y + " |")
                .append("dir=" + dir + " | ")
                .append("group=" + group + " | ")
                .append("]");
        return builder.toString();

    }

    @Override
    public void handle() {
        log.info(String.valueOf(this));
        Bullet t = new Bullet(this);
        TankFrame.getInstance().addBullet(t);
    }
}
