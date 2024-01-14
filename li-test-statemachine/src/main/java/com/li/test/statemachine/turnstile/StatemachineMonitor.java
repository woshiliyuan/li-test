package com.li.test.statemachine.turnstile;

import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author yuan.li
 * 
 *         定义动作监听类，StatemachineMonitor，添加注解@WithStateMachine。
 *         本例中使用id进行状态机绑定，根据文档定义，可以使用name和id两种属性绑定需要监听的状态机实例。如果不定义任何name或者id，
 *         默认监听名称为stateMachine的状态机。
 */
@WithStateMachine(id = "turnstileStateMachine")
public class StatemachineMonitor {

//	@OnTransition
//	public void anyTransition() {
//		System.out.println("状态机|OnTransition --- init");
//	}

	@OnTransition(target = "Unlocked")
	public void toUnlocked() {
		System.out.println("状态机|OnTransition --- toUnlocked");
	}

	@OnTransition(target = "Locked")
	public void toLocked() {
		System.out.println("状态机|OnTransition --- toLocked");
	}

	@OnStateChanged(source = "Unlocked")
	public void fromUnlocked() {
		System.out.println("状态机|OnTransition --- fromUnlocked");
	}
}
