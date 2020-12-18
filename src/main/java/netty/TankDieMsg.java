package netty;

import lombok.extern.slf4j.Slf4j;
import tank.*;

import java.io.*;
import java.util.UUID;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/14 17:38
 * @descrption
 */
@Slf4j
public class TankDieMsg extends Msg {
    public UUID id;

    public TankDieMsg() {
    }

    public TankDieMsg(Tank t) {
        this.id = t.getId();
    }

    public TankDieMsg(int x, int y, Dir dir, UUID id) {
        this.id = id;
    }

    public void parse(byte[] bytes) {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        try {
            //TODO:先读TYPE信息，根据类型处理不同的数据
            //掠过消息类型

            this.id = new UUID(dis.readLong(), dis.readLong());
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
        return MsgType.TankDie;
    }

    @Override
    public byte[] toBytes() {
        ByteArrayOutputStream baos = null;
        DataOutputStream dos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            dos = new DataOutputStream(baos);
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
                .append("uuid=" + id + " |  ")
                .append("]");
        return builder.toString();

    }

    @Override
    public void handle() {
        if (this.id.equals(TankFrame.getInstance().getMainTank().getId())
        ) {
            //TODO 关闭通道

            return;
        }
        log.info(String.valueOf(this));
        Tank t = TankFrame.getInstance().findByUUID(this.id);

        if (t != null) {
            TankFrame.getInstance().deleteByUUID(this.id);
        }
    }
}
