package com.li.test.statemachine.turnstile;

import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan.li
 * 
 *         状态机持久化，实际环境中，当前状态往往都是从持久化介质中实时获取的，Spring
 *         Statemachine通过实现StateMachinePersist接口，write和read当前状态机的状态
 * 
 * 
 *         本例中，使用的是HashMap作为模拟存储介质，正式项目中需要使用真实的状态获取途径
 *         
 *         
 *         在StatemachineConfigurer中发布，见StatemachineConfigurer.StateMachinePersister(...)
 */
@Component
public class BizStateMachinePersist implements StateMachinePersist<TurnstileStates, TurnstileEvents, Integer> {

	static Map<Integer, TurnstileStates> cache = new HashMap<>(16);

	@Override
	public void write(StateMachineContext<TurnstileStates, TurnstileEvents> stateMachineContext, Integer integer)
			throws Exception {
		cache.put(integer, stateMachineContext.getState());
	}

	@Override
	public StateMachineContext<TurnstileStates, TurnstileEvents> read(Integer integer) throws Exception {
		return cache.containsKey(integer) ? new DefaultStateMachineContext<>(cache.get(integer), null, null, null,
				null, "turnstileStateMachine") : new DefaultStateMachineContext<>(TurnstileStates.Locked, null, null,
				null, null, "turnstileStateMachine");
	}
}
