package com.li.test.rabbitmq.direct.send;

/**
 * @author yuan.li
 *
 */
public interface IDirectMessageService {
	/**
	 * 发送消息到队列
	 * 
	 * @param queue
	 *            队列名称
	 * @param message
	 *            消息内容
	 */
	public void send(String queue, Object message);

	/**
	 * 延迟发送消息到队列
	 * 
	 * @param queue
	 *            队列名称
	 * @param message
	 *            消息内容
	 * @param times
	 *            延迟时间 单位毫秒
	 */
	public void sendDlx(String queue, Object message, long times);

	public void sendDelay(String exchange, String queue, Object message, long times);
}
