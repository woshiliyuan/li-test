package com.li.test.drools.rules.rule2;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import com.li.test.drools.dto.Person;

/**
 * @author yuan.li
 *
 */
public class rule2 {

	public static void main(final String[] args) {
		KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
		System.out.println(kc.verify().getMessages().toString());
		execute(kc);
	}

	private static void execute(KieContainer kc) {
		KieSession ksession = kc.newKieSession("rule2KS");

		Person p1 = new Person(35, "li", "handsome");
		Person p2 = new Person(30, "yuan", "handsome");

		ksession.insert(p1);
		ksession.insert(p2);

		ksession.fireAllRules();

		QueryResults results = ksession.getQueryResults("people2");
		System.out.println("we have " + results.size() + " people over the age  of 30");

		System.out.println("These people are are over 30:");

		for (QueryResultsRow row : results) {
			Person person = (Person) row.get("person");
			System.out.println(person.getName() + "\n");
		}

		ksession.dispose();
	}
}
