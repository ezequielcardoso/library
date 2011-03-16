package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.Project;

/**
 * ��Ŀ:���/����/����/����
 * @author huan
 * @time  2011-3-16 ����06:34:27
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
			project.setShortName("����");
			dictItemDao.saveOrUpdate(project);
		
			Project project2 = new Project();
			project2.setShortName("����");
			dictItemDao.saveOrUpdate(project2);

			Project project3 = new Project();
			project3.setShortName("����");
			dictItemDao.saveOrUpdate(project3);

			Project project4 = new Project();
			project4.setShortName("���");
			dictItemDao.saveOrUpdate(project4);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
