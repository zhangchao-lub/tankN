package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/10 20:01
 * @descrption
 */
@Slf4j
public class Server {
    private static class ChatServerHolder {
        private final static Server INSTANCE = new Server();
    }

    public static Server getInstance() {
        return ChatServerHolder.INSTANCE;
    }

    //管道组
    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public void serverStart() {
        //线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup(2);

        try {
            ServerBootstrap b = new ServerBootstrap();
            //处理线程组分组
            ChannelFuture f = b.group(bossGroup, workGroup)
                    //设置客户端通道类型
                    .channel(NioServerSocketChannel.class)
                    //处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pl = ch.pipeline();
                            pl
                                    .addLast(new MsgDecoder())
                                    .addLast(new MsgEncoder())
                                    .addLast(new ServerChildHandler());
                        }
                    })
                    .bind("172.16.2.166", 8888)
                    .sync();
            ServerFrame.getInstance().updateServerMsg("server started");
            f.channel().closeFuture().sync();//close()->ChannelFuture
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}

@Slf4j
class ServerChildHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Server.clients.add(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ServerFrame.getInstance().updateClientMsg(String.valueOf(msg));
        Server.clients.writeAndFlush(msg);
//        ByteBuf buf = null;
//        int oldCount = 0;
//        try {
//            TankJoinMsg tm= (TankJoinMsg) msg;
//            log.info(String.valueOf(tm));
//            ServerFrame.getInstance().updateClientMsg(tm.toString());
//            Server.clients.writeAndFlush(tm);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (buf != null && oldCount == 0) {
////                ReferenceCountUtil.release(buf);
//            }
//        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        Server.clients.remove(ctx.channel());
        ctx.close();
    }
}

