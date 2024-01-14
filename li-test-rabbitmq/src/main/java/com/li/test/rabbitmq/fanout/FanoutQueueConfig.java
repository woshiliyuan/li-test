package com.li.test.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan.li
 * 
 *         Fanout
 *         形式又叫广播形式,因此我们发送到路由器的消息会使得绑定到该路由器的每一个Queue接收到消息,这个时候就算指定了Key,或者规则
 *         ,也会被忽略!
 */
@Configuration
public class FanoutQueueConfig {

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(FanoutConstant.LI_FANOUT);
	}

	@Bean(name = FanoutConstant.LI_FANOUT_QUEUE1)
	public Queue queue1() {
		return new Queue(FanoutConstant.LI_FANOUT_QUEUE1);
	}

	@Bean(name = FanoutConstant.LI_FANOUT_QUEUE2)
	public Queue queue2() {
		return new Queue(FanoutConstant.LI_FANOUT_QUEUE2);
	}

	@Bean(name = FanoutConstant.LI_FANOUT_QUEUE3)
	public Queue queue3() {
		return new Queue(FanoutConstant.LI_FANOUT_QUEUE3);
	}

	@Bean
	public Binding bindingQueue1(@Qualifier(FanoutConstant.LI_FANOUT_QUEUE1) Queue queue1) {
		return BindingBuilder.bind(queue1).to(fanoutExchange());
	}

	@Bean
	public Binding bindingQueue2(@Qualifier(FanoutConstant.LI_FANOUT_QUEUE2) Queue queue2) {
		return BindingBuilder.bind(queue2).to(fanoutExchange());
	}

	@Bean
	public Binding bindingQueue3(@Qualifier(FanoutConstant.LI_FANOUT_QUEUE3) Queue queue3) {
		return BindingBuilder.bind(queue3).to(fanoutExchange());
	}
}
