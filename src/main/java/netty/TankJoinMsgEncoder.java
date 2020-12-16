package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/14 17:40
 * @descrption 编码器
 */
public class TankJoinMsgEncoder extends MessageToByteEncoder<TankJoinMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, TankJoinMsg msg, ByteBuf out) throws Exception {
        out.writeBytes(msg.toBytes());
    }
}
