package com.li.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.li.test.rabbitmq.topic.TopicConstant;
import com.li.test.rabbitmq.topic.send.ITopicMessageService;

/**
 * @author yuan.li
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@SpringBootTest(classes = RabbitmqTest_topic.class)
@ContextConfiguration
public class RabbitmqTest_topic {
	@Autowired
	private ITopicMessageService iTopicMessageService;

	@Test
	public void test1() {
		String message = "测试消息";
		iTopicMessageService.send(TopicConstant.LI_TOPIC, TopicConstant.LI_TOPIC_QUEUE, message);
		while (true)
			;
	}

	@Test
	public void test2() {
		String message = "测试消息";
		iTopicMessageService.send(TopicConstant.LI_TOPIC, TopicConstant.LI_TOPIC_QUEUES, message);
		while (true)
			;
	}
}
