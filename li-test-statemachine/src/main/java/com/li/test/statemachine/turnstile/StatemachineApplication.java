//package com.li.test.statemachine.turnstile;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author yuan.li
// * 
// *         启动类及测试用例
// */
//@SpringBootApplication
//public class StatemachineApplication implements CommandLineRunner {
//
//	@Autowired
//	private StatemachineService statemachineService;
//
//	public static void main(String[] args) {
//		SpringApplication.run(StatemachineApplication.class, args);
//	}
//
//	@Override
//	public void run(String... strings) throws Exception {
//
//		Map<String, Object> context = new HashMap<>();
//		context.put("context", "some code");
//		statemachineService.execute(1, TurnstileEvents.PUSH, context);
//		statemachineService.execute(1, TurnstileEvents.PUSH, context);
//		statemachineService.execute(1, TurnstileEvents.COIN, context);
//		statemachineService.execute(1, TurnstileEvents.COIN, context);
//
//	}
//
//}