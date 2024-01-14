package com.li.test.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yuan.li
 *
 *         消费
 */
@Component
public class TopicMessageConsumer {

	private static Logger LOGGER = LoggerFactory.getLogger(TopicMessageConsumer.class);

	@RabbitListener(queues = TopicConstant.LI_TOPIC_QUEUE)
	public void process1(String content) {
		LOGGER.info("接收消息1", content);
	}

	@RabbitListener(queues = TopicConstant.LI_TOPIC_QUEUES)
	public void process2(String content) {
		LOGGER.info("接收消息2", content);
	}
}
