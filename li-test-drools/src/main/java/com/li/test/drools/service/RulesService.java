package com.li.test.drools.service;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.test.drools.dao.Rules;
import com.li.test.drools.dao.RulesDao;
import com.li.test.drools.dto.Person;

/**
 * @author yuan.li
 *
 */

@Service
public class RulesService {

	@Autowired
	private RulesDao rulesDao;

	/**
	 * 动态获取KieSession
	 *
	 * @param rules
	 *            rule
	 * @return KieSession
	 * @throws Exception
	 */
	public KieSession getKieSession(String rules) throws Exception {
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kfs = kieServices.newKieFileSystem();
		kfs.write("src/main/resources/rules/rules.drl", rules.getBytes());
		KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
		Results results = kieBuilder.getResults();
		if (results.hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
			System.out.println(results.getMessages());
			throw new Exception("results error!");
		}
		KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
		KieBase kieBase = kieContainer.getKieBase();

		return kieBase.newKieSession();
	}

	/**
	 * 验证规则是否合法
	 * 
	 * @param rule
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public Boolean ruleVerify(String rule, Person p) throws Exception {
		KieSession kieSession = getKieSession(rule);
		kieSession.insert(p);
		int rules = kieSession.fireAllRules();
		System.out.println(rules);
		kieSession.dispose();
		return true;
	}

	/**
	 * 动态加载已经部署的rule
	 *
	 * @param id
	 *            rule id
	 * @param p
	 *            对象
	 * @return 结果对象
	 * @throws Exception
	 */
	public Person getRulesWrite(Integer id, Person p) throws Exception {
		String rules;
		Rules ru = rulesDao.selectById(id);
		if (ru != null && ru.getRule() != null) {
			rules = ru.getRule();
		} else
			throw new Exception("ru.getRule() = null");

		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kfs = kieServices.newKieFileSystem();
		kfs.write("src/main/resources/rules/rules.drl", rules.getBytes());
		KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
		Results results = kieBuilder.getResults();
		if (results.hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
			System.out.println(results.getMessages());
			throw new IllegalStateException("### errors ###");
		}
		KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
		KieBase kieBase = kieContainer.getKieBase();
		KieSession ksession = kieBase.newKieSession();

		ksession.insert(p);
		ksession.fireAllRules();
		return p;
	}
}
