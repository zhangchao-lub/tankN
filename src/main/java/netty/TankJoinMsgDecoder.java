package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import tank.Dir;
import tank.Group;

import java.util.List;
import java.util.UUID;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/14 17:48
 * @descrption 解码器
 */
public class TankJoinMsgDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes()<33){ //TCP 拆包 粘包
            return;
        }
        TankJoinMsg msg=new TankJoinMsg();
        msg.x=in.readInt();
        msg.y=in.readInt();
        msg.dir=Dir.values()[in.readInt()];
        msg.moving=in.readBoolean();
        msg.group=Group.values()[in.readInt()];
        msg.id=new UUID(in.readLong(),in.readLong());

        out.add(msg);
    }
}
