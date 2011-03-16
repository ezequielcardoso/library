package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.Project;

/**
 * 项目:租金/罚款/补卡/开户
 * @author huan
 * @time  2011-3-16 下午06:34:27
 */
public class ProjectInitTest {
    
	private static DictItemDao dictItemDao; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	}
	
	@Test
	public void testProjectInit(){
		try{
			Project project = new Project();
			project.setShortName("开户");
			dictItemDao.saveOrUpdate(project);
		
			Project project2 = new Project();
			project2.setShortName("补卡");
			dictItemDao.saveOrUpdate(project2);

			Project project3 = new Project();
			project3.setShortName("罚款");
			dictItemDao.saveOrUpdate(project3);

			Project project4 = new Project();
			project4.setShortName("租金");
			dictItemDao.saveOrUpdate(project4);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
