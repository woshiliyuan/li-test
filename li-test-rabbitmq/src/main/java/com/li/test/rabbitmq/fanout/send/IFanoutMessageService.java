package com.li.test.rabbitmq.fanout.send;

/**
 * @author yuan.li
 * 
 */
public interface IFanoutMessageService {

	/**
	 * 发送消息到队列
	 * 
	 * @param exchange
	 * @param message
	 */
	public void send(String exchange, String message);
}
