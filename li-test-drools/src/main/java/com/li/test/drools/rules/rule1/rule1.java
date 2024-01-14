package com.li.test.drools.rules.rule1;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author yuan.li
 * 
 *         使用kmodule的方式调用drools /resources/META-INF/kmodule.xml
 * 
 * 
 *         通过KieServices对象得到一个KieContainer，然后KieContainer根据session
 *         name来新建一个KieSession，最后通过KieSession来运行规则。
 */
public class rule1 {
	public static void main(final String[] args) {
		KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
		System.out.println(kc.verify().getMessages().toString());
		execute(kc);
	}

	private static void execute(KieContainer kc) {
		KieSession ksession = kc.newKieSession("rule1KS");
		// 通过kSession.fireAllRules方法来通知规则引擎执行规则。
		ksession.fireAllRules();

		ksession.dispose();
	}
}
