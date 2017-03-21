package net.remote.remoteServer;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import net.remote.remoteServer.common.ServerConstant;

public class RemoteServer {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		new RemoteServer().serverStart();
	}
	
	public void serverStart(){
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			final ServerBootstrap sb = new ServerBootstrap();
			
			sb.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.localAddress(new InetSocketAddress(ServerConstant.PORT))
			.childHandler(new RemoteServerInitializer());
			
			Channel ch = sb.bind().sync().channel();
			
			logger.debug("remoteServer started at port " + ServerConstant.PORT);
			
			ch.closeFuture().sync();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
