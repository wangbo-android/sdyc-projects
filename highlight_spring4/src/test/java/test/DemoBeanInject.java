package test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.TestBean;
import config.TestConfig;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("dev")
public class DemoBeanInject {

	@Autowired
	private TestBean testBean;
	
	@SuppressWarnings("deprecation")
	@Test
	public void prodBean(){
		
		String expected = "from production profile";
		
		String actual = testBean.getContent();
		
		Assert.assertEquals(expected, actual);
	}
}
