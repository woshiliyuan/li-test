package com.li.test.rabbitmq.direct;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.li.test.rabbitmq.User;
import com.rabbitmq.client.Channel;

/**
 * @author yuan.li
 * 
 *         消费
 */
@Component
public class DirectMessageConsumer {

	private static Logger LOGGER = LoggerFactory.getLogger(DirectMessageConsumer.class);

	@RabbitListener(queues = DirectConstant.LI_QUEUE1)
	public void process(User user) {

		LOGGER.info("接收消息,queue:{},user:{}", DirectConstant.LI_QUEUE1, user);
	}

	@RabbitListener(queues = DirectConstant.LI_QUEUE2)
	public void processAck(Channel channel, Message message) {
		LOGGER.info("接收消息,queue:{},content:{}", DirectConstant.LI_QUEUE2, message);
		try {
			// 告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			System.out.println("receiver success");
		} catch (IOException e) {
			e.printStackTrace();
			// 丢弃这条消息
			// channel.basicNack(message.getMessageProperties().getDeliveryTag(),
			// false,false);
			System.out.println("receiver fail");
		}
	}

	// @RabbitListener(queues = DirectConstant.LI_QUEUE_DELAY)
	// public void processDelay(User User) {
	//
	// LOGGER.info("接收消息,queue:{},user:{}", DirectConstant.LI_QUEUE_DELAY,
	// User);
	// }
}
