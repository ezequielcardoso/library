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
			project.setItemName("开户");
			project.setItemCode("Project");
			dictItemDao.saveOrUpdate(project);
		
			Project project2 = new Project();
			project2.setItemName("补卡");
			project2.setItemCode("Project2");
			dictItemDao.saveOrUpdate(project2);

			Project project3 = new Project();
			project3.setItemName("罚款");
			project3.setItemCode("Project3");
			dictItemDao.saveOrUpdate(project3);

			Project project4 = new Project();
			project4.setItemName("租金");
			project4.setItemCode("Project4");
			dictItemDao.saveOrUpdate(project4);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
