package com.li.test.drools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.li.test.drools.dao.Rules;
import com.li.test.drools.dao.RulesDao;
import com.li.test.drools.dto.Person;
import com.li.test.drools.service.RulesService;

/**
 * @author yuan.li
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@SpringBootTest(classes = RulesServiceTest.class)
@ContextConfiguration
public class RulesServiceTest {
	@Autowired
	private RulesDao rulesDao;
	@Autowired
	private RulesService rulesService;

	@Test
	public void test() throws Exception {
		System.out.println("**************************");
		Person p = new Person(31, "li", "handsome");
		Rules rule = rulesDao.selectById(2);
		rulesService.ruleVerify(rule.getRule(), p);
	}

	@Test
	public void test1() throws Exception {
		rulesService.getRulesWrite(1, null);
	}

	@Test
	public void test2() throws Exception {
		System.out.println("**************************");
		Person p1 = new Person(30, "li", "handsome");
		rulesService.getRulesWrite(2, p1);
		System.out.println("**************************");
		Person p2 = new Person(35, "yuan", "handsome");
		rulesService.getRulesWrite(2, p2);
	}
}
