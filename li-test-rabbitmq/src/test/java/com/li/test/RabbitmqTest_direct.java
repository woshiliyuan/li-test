package com.li.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.li.test.rabbitmq.User;
import com.li.test.rabbitmq.direct.DirectConstant;
import com.li.test.rabbitmq.direct.send.IDirectMessageService;

/**
 * @author yuan.li
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@SpringBootTest(classes = RabbitmqTest_direct.class)
@ContextConfiguration
public class RabbitmqTest_direct {
	@Autowired
	private IDirectMessageService iDirectMessageService;

	@Test
	public void test1() {
		User user = new User();
		user.setName("liyuan1");
		user.setAddr("流浪地球1");
		iDirectMessageService.send(DirectConstant.LI_QUEUE1, user);
		while (true)
			;
	}

	@Test
	public void testDlx() {
		User user = new User();
		user.setName("liyuan222");
		user.setAddr("流浪地球2222");
		for (int i = 0; i < 4; i++) {
			iDirectMessageService.sendDlx(DirectConstant.LI_QUEUE1_DELAY, user, 10000);
		}
		while (true)
			;
	}

	// @Test
	// public void testDelay() {
	// User user = new User();
	// user.setName("liyuan");
	// user.setAddr("流浪地球");
	// for (int i = 0; i < 4; i++) {
	// iDirectMessageService.sendDelay(DirectConstant.LI_EXCHANGE_DELAY,
	// DirectConstant.LI_QUEUE_DELAY, user, 10000);
	// }
	// while (true)
	// ;
	// }

	@Test
	public void testAck() {

		String message = "测试普通消息11111";
		iDirectMessageService.send(DirectConstant.LI_QUEUE2, message);
		while (true)
			;
	}
}
