package com.li.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.li.test.rabbitmq.fanout.FanoutConstant;
import com.li.test.rabbitmq.fanout.send.IFanoutMessageService;

/**
 * @author yuan.li
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@SpringBootTest(classes = RabbitmqTest_fanout.class)
@ContextConfiguration
public class RabbitmqTest_fanout {
	@Autowired
	private IFanoutMessageService iFanoutMessageService;

	@Test
	public void test1() {
		String message = "测试消息";
		iFanoutMessageService.send(FanoutConstant.LI_FANOUT, message);
		while (true)
			;
	}
}
