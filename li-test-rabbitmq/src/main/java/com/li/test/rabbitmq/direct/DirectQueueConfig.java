package com.li.test.rabbitmq.direct;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan.li
 * 
 *         Direct是RabbitMQ默认的交换机模式,也是最简单的模式.即创建消息队列的时候,指定一个BindingKey.
 *         当发送者发送消息的时候, 指定对应的Key.当Key和消息队列的BindingKey一致的时候,消息将会被发送到该消息队列中.
 * 
 *         队列配置，所有配置@Bean的队列名称，由系统启动时创建队列，并绑定到Exchane上
 */
@Configuration
public class DirectQueueConfig {

	// exchange
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(DirectConstant.LI_EXCHANGE, true, false);
	}

	/** queue1 *****************/
	@Bean
	public Queue queue1() {
		return new Queue(DirectConstant.LI_QUEUE1, true, false, false);
	}

	@Bean
	public Binding queue1Binding() {
		return BindingBuilder.bind(queue1()).to(directExchange()).with(DirectConstant.LI_QUEUE1);
	}

	/** dlx *****************/
	@Bean
	public Queue queue1delayQueue() {
		Map<String, Object> arguments = new HashMap<>();
		arguments.put("x-dead-letter-exchange", DirectConstant.LI_EXCHANGE);
		arguments.put("x-dead-letter-routing-key", DirectConstant.LI_QUEUE1);
		return new Queue(DirectConstant.LI_QUEUE1_DELAY, true, false, false, arguments);
	}

	@Bean
	public Binding queue1delayBinding() {
		return BindingBuilder.bind(queue1delayQueue()).to(directExchange()).with(DirectConstant.LI_QUEUE1_DELAY);
	}

	/** ack *****************/
	@Bean
	public Queue queue2() {
		return new Queue(DirectConstant.LI_QUEUE2, true, false, false);
	}

	@Bean
	public Binding queue2Binding() {
		return BindingBuilder.bind(queue2()).to(directExchange()).with(DirectConstant.LI_QUEUE2);
	}

	/** delay *****************/
	// @Bean
	// public CustomExchange delayExchange() {
	// Map<String, Object> args = new HashMap<>();
	// args.put("x-delayed-type", "direct");
	// return new CustomExchange(DirectConstant.LI_EXCHANGE_DELAY,
	// "x-delayed-message", true, false, args);
	// }
	//
	// @Bean
	// public Queue delayQueue() {
	// return new Queue(DirectConstant.LI_QUEUE_DELAY, true);
	// }
	//
	// @Bean
	// public Binding delaybinding() {
	// return BindingBuilder.bind(delayQueue()).to(delayExchange())
	// .with(DirectConstant.LI_QUEUE_DELAY).noargs();
	// }
}
