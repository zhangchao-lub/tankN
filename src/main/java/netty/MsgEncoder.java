package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import tank.Msg;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/14 17:40
 * @descrption 编码器
 */
public class MsgEncoder extends MessageToByteEncoder<Msg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Msg msg, ByteBuf out) throws Exception {
        //写出下消息类型
        out.writeInt(msg.getMsgType().ordinal());
        //写入字节数组长度
        byte[] bytes=msg.toBytes();
        out.writeInt(bytes.length);
        //写入字节数组
        out.writeBytes(bytes);
    }
}
