package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import tank.Dir;
import tank.Group;
import tank.Msg;
import tank.MsgType;

import java.util.List;
import java.util.UUID;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/14 17:48
 * @descrption 解码器
 */
public class MsgDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 8) { //消息类型和长度都有了才解析
            return;
        }
        //标记开始读得位置
        in.markReaderIndex();

        //读取消息类型
        MsgType msgType = MsgType.values()[in.readInt()];
        //读取长度
        int length = in.readInt();
        //数据没有全部到达
        if (in.readableBytes() < length) {
            //重置指针
            in.resetReaderIndex();
            return;
        }
        //数据读到字节数组里面
        byte[] bytes = new byte[length];
        in.readBytes(bytes);
        //具体解析
        Msg msg = null;
        switch (msgType) {
            case TankJoin:
                msg = new TankJoinMsg();
                break;
            case TankStartMoving:
                msg = new TankStartMovingMsg();
                break;
            case TankStop:
                msg = new TankStopMsg();
                break;
            case TankDirChanged:
                msg = new TankDirChangedMsg();
                break;
            case BulletNew:
                msg = new BulletNewMsg();
                break;
            default:
                break;
        }
        msg.parse(bytes);
        out.add(msg);

    }
}
