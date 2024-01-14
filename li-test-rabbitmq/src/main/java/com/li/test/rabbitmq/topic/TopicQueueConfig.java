package com.li.test.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan.li
 * 
 *         topic转发信息主要是依据通配符,队列和交换机的绑定主要是依据一种模式(通配符+字符串),而当发送消息的时候,
 *         只有指定的Key和该模式相匹配的时候, 消息才会被发送到该消息队列中.
 */
@Configuration
public class TopicQueueConfig {

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(TopicConstant.LI_TOPIC);
	}

	@Bean(name = TopicConstant.LI_TOPIC_QUEUE)
	public Queue queue() {
		return new Queue(TopicConstant.LI_TOPIC_QUEUE);
	}

	@Bean(name = TopicConstant.LI_TOPIC_QUEUES)
	public Queue queues() {
		return new Queue(TopicConstant.LI_TOPIC_QUEUES);
	}

	@Bean
	public Binding bindingQueue(@Qualifier(TopicConstant.LI_TOPIC_QUEUE) Queue queue) {
		return BindingBuilder.bind(queue).to(topicExchange()).with(TopicConstant.LI_TOPIC_QUEUE);
	}

	@Bean
	public Binding bindingQueues(@Qualifier(TopicConstant.LI_TOPIC_QUEUES) Queue queues) {
		return BindingBuilder.bind(queues).to(topicExchange()).with("li.#");// *表示一个词,#表示零个或多个词
	}
}
