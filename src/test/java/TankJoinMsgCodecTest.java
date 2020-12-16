import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import netty.TankJoinMsg;
import netty.TankJoinMsgDecoder;
import netty.TankJoinMsgEncoder;
import org.junit.Assert;
import org.junit.Test;
import tank.Dir;
import tank.Group;

import java.util.UUID;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/15 16:04
 * @descrption
 */
public class TankJoinMsgCodecTest {
    @Test
    public void testEncoder() {
        EmbeddedChannel ch = new EmbeddedChannel();

        UUID id = UUID.randomUUID();
        TankJoinMsg msg = new TankJoinMsg(5,10, Dir.DOWN, true, Group.GOOD, id);
        ch.pipeline()
                .addLast(new TankJoinMsgEncoder());

        ch.writeOutbound(msg);

        ByteBuf buf=ch.readOutbound();

        int x=buf.readInt();//获取x
        int y=buf.readInt();//获取y
        Dir dir=Dir.values()[buf.readInt()];//获取方向
        boolean moving =buf.readBoolean();//获取移动状态
        Group g=Group.values()[buf.readInt()];
        UUID uuid=new UUID(buf.readLong(),buf.readLong());

        Assert.assertEquals(5,x);
        Assert.assertEquals(10,y);
        Assert.assertEquals(Dir.DOWN,dir);
        Assert.assertEquals(true,moving);
        Assert.assertEquals(Group.GOOD,g);
        Assert.assertEquals(id,uuid);
    }

    @Test
    public void testDecoder(){
        EmbeddedChannel ch=new EmbeddedChannel();

        UUID id=UUID.randomUUID();
        TankJoinMsg msg=new TankJoinMsg(5,10, Dir.DOWN, true, Group.GOOD, id);
        ch.pipeline().addLast(new TankJoinMsgDecoder());

        ByteBuf buf= Unpooled.buffer();
        //字节数组写到buf里面
        buf.writeBytes(msg.toBytes());
        //复制一份写入解析
        ch.writeInbound(buf.duplicate());

        TankJoinMsg msgR=ch.readInbound();
        Assert.assertEquals(5,msgR.x);
        Assert.assertEquals(10,msgR.y);
        Assert.assertEquals(Dir.DOWN,msgR.dir);
        Assert.assertEquals(true,msgR.moving);
        Assert.assertEquals(Group.GOOD,msgR.group);
        Assert.assertEquals(id,msgR.id);
    }
}
