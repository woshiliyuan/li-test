package com.li.test.rabbitmq.fanout.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuan.li
 *
 *         生产
 */
@Service
public class FanoutMessageService implements IFanoutMessageService {

	private static Logger LOGGER = LoggerFactory.getLogger(FanoutMessageService.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void send(String exchange, String message) {
		LOGGER.info("发送消息,exchange:{},message:{}", exchange, message);

		rabbitTemplate.convertAndSend(exchange, "", message);
	}

}
