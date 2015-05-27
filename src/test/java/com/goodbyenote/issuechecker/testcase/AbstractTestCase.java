/**
 * 
 */
package com.goodbyenote.issuechecker.testcase;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author June Park
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"classpath:mybatis/mybatis-config.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
@WebAppConfiguration
public abstract class AbstractTestCase {

}
