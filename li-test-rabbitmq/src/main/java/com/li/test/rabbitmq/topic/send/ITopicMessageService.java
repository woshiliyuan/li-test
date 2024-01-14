package com.li.test.rabbitmq.topic.send;

/**
 * @author yuan.li
 * 
 */
public interface ITopicMessageService {

	/**
	 * 发送消息到队列
	 * 
	 * @param exchange
	 * @param queue
	 * @param message
	 */
	public void send(String exchange, String queue, String message);
}
