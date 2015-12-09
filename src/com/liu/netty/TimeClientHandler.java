package com.liu.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		String clientStr = "hahahahhahahahaahhahaha";
		
		ByteBuf by = Unpooled.copiedBuffer(clientStr.getBytes());
		
		ctx.writeAndFlush(by);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		ByteBuf by = (ByteBuf) msg;
		
		byte[] bytes = new byte[by.readableBytes()];
		
		by.readBytes(bytes);
		
		String str = new String(bytes,"utf-8");
	
		System.out.println("接受服务端消息："+str);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		ctx.close();
	}
	
}
