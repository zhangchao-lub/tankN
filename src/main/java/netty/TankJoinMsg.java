package netty;

import tank.Dir;
import tank.Group;
import tank.Tank;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/14 17:38
 * @descrption
 */
public class TankJoinMsg {
    public int x, y;
    public Dir dir;
    public boolean moving;
    public Group group;
    public UUID id;

    public TankJoinMsg() {
    }

    public TankJoinMsg(Tank t) {
        this.x = t.getX();
        this.y = t.getY();
        this.dir = t.getDir();
        this.moving = t.isMoving();
        this.group = t.getGroup();
        this.id = t.getId();
    }

    public TankJoinMsg(int x, int y, Dir dir, boolean moving, Group group, UUID id) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.moving = moving;
        this.group = group;
        this.id = id;
    }

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
            dos.writeBoolean(moving);
            dos.writeInt(group.ordinal());
            dos.writeLong(id.getMostSignificantBits());
            dos.writeLong(id.getLeastSignificantBits());
            dos.flush();
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            try {
                if (dos != null) {
                    dos.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return bytes;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(this.getClass().getName())
                .append("[")
                .append("uuid="+id+" |  ")
                .append("x="+x+" | ")
                .append("y="+y+" |")
                .append("moving"+moving+" | ")
                .append("dir="+dir+" | ")
                .append("group" +group+" | ")
                .append("]");
        return builder.toString();

    }
}
