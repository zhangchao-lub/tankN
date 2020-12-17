package netty;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import tank.*;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/11 11:04
 * @descrption
 */
@Slf4j
public class Client {

    public final static Client INSTANCE = new Client();
    private Channel channel = null;

    private Client() {

    }

    public void connect() {
        //线程池
        EventLoopGroup group = new NioEventLoopGroup();
        //辅助启动类
        Bootstrap b = new Bootstrap();

        try {
            ChannelFuture f =
                    b.group(group)
                            .channel(NioSocketChannel.class)
                            .handler(new ClientChannelInitializer())
                            .connect("172.16.2.166", 8888)
                            //连接监听器
                            .addListener(new ChannelFutureListener() {
                                @Override
                                public void operationComplete(ChannelFuture future) throws Exception {
                                    if (future.isSuccess()) {
                                        log.info("connected");
                                        channel = future.channel();
                                    } else {
                                        log.error("not connected");
                                    }
                                }
                            })
                            .sync();

            f.channel().closeFuture().sync();//close()->ChannelFuture
            log.info("client connect stopped");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public void send(Msg msg) {
        channel.writeAndFlush(msg);
    }

//    public void closeConnect() {
//        this.send("_bye_");
//    }
}

//初始化客户端channel
class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new TankJoinMsgEncoder())
                .addLast(new TankJoinMsgDecoder())
                .addLast(new ClientHandler());
    }

}

@Slf4j
class ClientHandler extends SimpleChannelInboundHandler<Msg> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(new TankJoinMsg(TankFrame.getInstance().getMainTank()));
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Msg msg) throws Exception {
        msg.handle();

    }
}
