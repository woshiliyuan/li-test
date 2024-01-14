package com.li.test.rabbitmq.direct.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.test.rabbitmq.direct.DirectConstant;

/**
 * @author yuan.li
 *
 *         生产
 */
@Service
public class DirectMessageService implements IDirectMessageService {

	private static Logger LOGGER = LoggerFactory.getLogger(DirectMessageService.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 发送消息到队列
	 */
	@Override
	public void send(String queue, Object message) {
		LOGGER.info("发送消息,queue:{},message:{}", queue, message);
		if (DirectConstant.LI_QUEUE1_DELAY.equals(queue)) {
			LOGGER.info("queue非法");
			return;
		}
		rabbitTemplate.convertAndSend(DirectConstant.LI_EXCHANGE, queue, message);
	}

	/**
	 * 延迟发送消息到队列
	 */
	@Override
	public void sendDlx(String queue, Object message, long times) {
		LOGGER.info("发送消息,queue:{},message:{},times:{}", queue, message, times);

		MessagePostProcessor processor = new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				message.getMessageProperties().setExpiration(times + "");
				return message;
			}
		};
		rabbitTemplate.convertAndSend(DirectConstant.LI_EXCHANGE, queue, message, processor);
	}

	@Override
	public void sendDelay(String exchange, String queue, Object message, long times) {
		rabbitTemplate.convertAndSend(exchange, queue, message, new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				message.getMessageProperties().setHeader("x-delay", times);
				return message;
			}
		});
	}

}
