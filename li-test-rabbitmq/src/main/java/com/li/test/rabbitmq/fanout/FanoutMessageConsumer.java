package com.li.test.rabbitmq.fanout;

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
public class FanoutMessageConsumer {

	private static Logger LOGGER = LoggerFactory.getLogger(FanoutMessageConsumer.class);

	@RabbitListener(queues = FanoutConstant.LI_FANOUT_QUEUE1)
	public void process1(String content) {
		LOGGER.info("接收消息1", content);
	}

	@RabbitListener(queues = FanoutConstant.LI_FANOUT_QUEUE2)
	public void process2(String content) {
		LOGGER.info("接收消息2", content);
	}

	@RabbitListener(queues = FanoutConstant.LI_FANOUT_QUEUE3)
	public void process3(String content) {
		LOGGER.info("接收消息3", content);
	}
}
