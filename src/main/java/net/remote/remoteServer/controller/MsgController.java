package net.remote.remoteServer.controller;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.remote.remoteServer.common.db.MyBatisConnectionFactory;
import net.remote.remoteServer.dao.AccountDAO;
import net.remote.remoteServer.vo.LoginUser;

public class MsgController extends SimpleChannelInboundHandler<Object>{

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("===== msg Receiver =====");
//		LoginUser userData = (LoginUser) msg;
		ByteBuf buff = (ByteBuf) msg;
		
//		logger.debug(msg.toString());
		logger.debug(userData.toString());
		logger.debug(msg.getClass().getName());
		
		
		String userId = null;
		String userPw = null;
		LoginUser loginUser = new LoginUser(userId, userPw);
		LoginUser loginResult;
		logger.debug("MyBatisConnectionFactory");
		MyBatisConnectionFactory mybatisFactory = null;
		mybatisFactory = MyBatisConnectionFactory.getInstance();
		logger.debug("test1");
		System.out.println("mybatisFactory : "+mybatisFactory);
		logger.debug("AccountDAO");
		AccountDAO accountDao = new AccountDAO(mybatisFactory.getSqlSessionFactory());
		logger.debug("selectLogin");
		loginResult = accountDao.selectLogin(loginUser);
		
		System.out.println(loginResult.toString());
	}

}
