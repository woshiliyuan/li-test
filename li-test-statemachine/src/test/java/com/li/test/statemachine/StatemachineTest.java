package com.li.test.statemachine;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.li.test.statemachine.turnstile.StatemachineService;
import com.li.test.statemachine.turnstile.TurnstileEvents;

/**
 * @author yuan.li
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@SpringBootTest(classes = StatemachineTest.class)
@ContextConfiguration
public class StatemachineTest {

	@Autowired
	private StatemachineService statemachineService;

	@Test
	public void test1() {
		Map<String, Object> context = new HashMap<>();
		context.put("context", "some code");

		System.out.println("状态机|============================1");
		statemachineService.execute(1, TurnstileEvents.PUSH, context);
		System.out.println("状态机|============================2");
		statemachineService.execute(1, TurnstileEvents.PUSH, context);
		System.out.println("状态机|============================3");
		statemachineService.execute(1, TurnstileEvents.COIN, context);
		System.out.println("状态机|============================4");
		statemachineService.execute(1, TurnstileEvents.COIN, context);
		System.out.println("状态机|============================5");

		// 状态机|============================1
		// 状态机|OnTransition --- toLocked
		// 状态机|状态机处理未执行成功，请处理，ID：1，当前context：{context=some code}
		// 状态机|============================2
		// 状态机|OnTransition --- toLocked
		// 状态机|状态机处理未执行成功，请处理，ID：1，当前context：{context=some code}
		// 状态机|============================3
		// 状态机|OnTransition --- toLocked
		// 状态机|解锁旋转门，以便游客能够通过，当前状态机上下文：....
		// 状态机|OnTransition --- toUnlocked
		// 状态机|============================4
		// 状态机|OnTransition --- toLocked
		// 状态机|状态机处理未执行成功，请处理，ID：1，当前context：{context=some code}
		// 状态机|============================5
	}

	@Test
	public void test2() {
		Map<String, Object> context = new HashMap<>();
		context.put("context", "some code");

		statemachineService.execute(1, TurnstileEvents.COIN, context);
		statemachineService.execute(1, TurnstileEvents.PUSH, context);
		statemachineService.execute(1, TurnstileEvents.COIN, context);
		statemachineService.execute(1, TurnstileEvents.PUSH, context);
		statemachineService.execute(1, TurnstileEvents.PUSH, context);
		statemachineService.execute(1, TurnstileEvents.COIN, context);
		statemachineService.execute(1, TurnstileEvents.PUSH, context);
		statemachineService.execute(1, TurnstileEvents.COIN, context);
		statemachineService.execute(1, TurnstileEvents.COIN, context);
		statemachineService.execute(1, TurnstileEvents.PUSH, context);

		// 状态机|解锁旋转门，以便游客能够通过，当前状态机上下文：....
		// 状态机|当游客通过，锁定旋转门，当前状态机上下文：....
		// 状态机|解锁旋转门，以便游客能够通过，当前状态机上下文：....
		// 状态机|当游客通过，锁定旋转门，当前状态机上下文：....
		// 状态机|状态机处理未执行成功，请处理，ID：1，当前context：{context=some code}
		// 状态机|解锁旋转门，以便游客能够通过，当前状态机上下文：....
		// 状态机|当游客通过，锁定旋转门，当前状态机上下文：....
		// 状态机|解锁旋转门，以便游客能够通过，当前状态机上下文：....
		// 状态机|状态机处理未执行成功，请处理，ID：1，当前context：{context=some code}
		// 状态机|当游客通过，锁定旋转门，当前状态机上下文：....
	}

}
