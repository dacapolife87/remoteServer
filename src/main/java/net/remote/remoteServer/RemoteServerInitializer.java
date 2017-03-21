package net.remote.remoteServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import net.remote.remoteServer.common.ServerConstant;
import net.remote.remoteServer.controller.MsgController;

public class RemoteServerInitializer extends ChannelInitializer<SocketChannel> {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		logger.info("initChannel !");
		ChannelPipeline p = ch.pipeline();
		p.addLast( new HttpObjectAggregator(ServerConstant.MAX_LENGTH));
		p.addLast( new MsgController());
	}

}
