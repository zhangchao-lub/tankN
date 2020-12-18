import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import netty.BulletNewMsg;
import netty.MsgDecoder;
import netty.MsgEncoder;
import netty.TankJoinMsg;
import org.junit.Assert;
import org.junit.Test;
import tank.Dir;
import tank.Group;
import tank.MsgType;

import java.util.UUID;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/15 16:04
 * @descrption
 */
public class BulletNewTest {
    @Test
    public void testEncoder() {
        EmbeddedChannel ch = new EmbeddedChannel();

        BulletNewMsg msg = new BulletNewMsg(5, 10, Dir.DOWN, Group.GOOD);
        ch.pipeline()
                .addLast(new MsgEncoder());

        //写数据
        ch.writeOutbound(msg);

        //读数据
        ByteBuf buf = ch.readOutbound();

        //比较消息类型
        MsgType msgType = MsgType.values()[buf.readInt()];
        Assert.assertEquals(MsgType.BulletNew, msgType);

        //比较消息长度
        int length = buf.readInt();
        Assert.assertEquals(msg.toBytes().length, length);

        //比较数据
        int x = buf.readInt();//获取x
        int y = buf.readInt();//获取y
        Dir dir = Dir.values()[buf.readInt()];//获取方向
        Group g = Group.values()[buf.readInt()];

        Assert.assertEquals(5, x);
        Assert.assertEquals(10, y);
        Assert.assertEquals(Dir.DOWN, dir);
        Assert.assertEquals(Group.GOOD, g);
    }

    @Test
    public void testDecoder() {
        EmbeddedChannel ch = new EmbeddedChannel();

        BulletNewMsg msg = new BulletNewMsg(5, 10, Dir.DOWN, Group.GOOD);
        ch.pipeline().addLast(new MsgDecoder());

        ByteBuf buf = Unpooled.buffer();
        //字节数组写到buf里面
        buf.writeInt(MsgType.BulletNew.ordinal());
        byte[] bytes = msg.toBytes();
        buf.writeInt(bytes.length);
        buf.writeBytes(bytes);

        //复制一份写入解析
        ch.writeInbound(buf.duplicate());

        BulletNewMsg msgR = ch.readInbound();

        Assert.assertEquals(5, msgR.x);
        Assert.assertEquals(10, msgR.y);
        Assert.assertEquals(Dir.DOWN, msgR.dir);
        Assert.assertEquals(Group.GOOD, msgR.group);
    }
}
