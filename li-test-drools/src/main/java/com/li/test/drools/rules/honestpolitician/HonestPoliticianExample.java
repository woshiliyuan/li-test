package com.li.test.drools.rules.honestpolitician;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.li.test.drools.dto.Politician;

/**
 * @author yuan.li
 *
 */
public class HonestPoliticianExample {
	public static void main(final String[] args) {
		KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
		System.out.println(kc.verify().getMessages().toString());
		execute(kc);
	}

	private static void execute(KieContainer kc) {
		KieSession ksession = kc.newKieSession("HonestPoliticianKS");

		final Politician p1 = new Politician("President of Umpa Lumpa", true);
		final Politician p2 = new Politician("Prime Minster of Cheeseland", true);
		final Politician p3 = new Politician("Tsar of Pringapopaloo", true);
		final Politician p4 = new Politician("Omnipotence Om", true);

		ksession.insert(p1);
		ksession.insert(p2);
		ksession.insert(p3);
		ksession.insert(p4);

		ksession.fireAllRules();

		ksession.dispose();
	}
}
