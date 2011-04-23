package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.reader.ReaderUnits;

/**
 * 读者部门初始化
 * 
 * @author huan
 * @time 2011-3-17 上午10:41:51
 */
public class ReaderUnitsInitTest {

	private static ReaderUnitsDao readerUnitsDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		readerUnitsDao = (ReaderUnitsDao) BaseSpringBeans.getInstance()
				.getBean("readerUnitsDao");
	}

	// @Test //初始化根节点 湖北警官学院 不能删除
	public void testUnitsRootInit() {
		ReaderUnits readerUnits = new ReaderUnits();
		readerUnits.setUnitcode("10000");
		readerUnits.setUnitName("湖北警官学院");
		readerUnits.setUnitDesc("湖北警官学院图书馆");
		readerUnits.setUnitShortName("lib");
		readerUnits.setParentUnit(null);

		readerUnitsDao.saveOrUpdate(readerUnits);
	}

	@Test
	// 录入 湖北警官学院南院 /北院
	public void testUnitsChildrenInit() {

		ReaderUnits parentUnit = readerUnitsDao.selectById(1);

		ReaderUnits readerUnitsS = new ReaderUnits();
		readerUnitsS.setUnitcode("10002");
		readerUnitsS.setUnitName("湖北警官学院北院");
		readerUnitsS.setUnitDesc("湖北警官学院图书馆");
		readerUnitsS.setUnitShortName("lib");
		readerUnitsS.setParentUnit(parentUnit);
		readerUnitsDao.saveOrUpdate(readerUnitsS);

		ReaderUnits readerUnitsN = new ReaderUnits();
		readerUnitsN.setUnitcode("10003");
		readerUnitsN.setUnitName("湖北警官学院男院");
		readerUnitsN.setUnitDesc("湖北警官学院图书馆");
		readerUnitsN.setUnitShortName("lib");
		readerUnitsN.setParentUnit(parentUnit);

		readerUnitsDao.saveOrUpdate(readerUnitsN);
	}

}
