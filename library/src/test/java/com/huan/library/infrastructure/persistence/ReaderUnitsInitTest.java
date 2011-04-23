package com.huan.library.infrastructure.persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.reader.ReaderUnits;

/**
 * ���߲��ų�ʼ��
 * 
 * @author huan
 * @time 2011-3-17 ����10:41:51
 */
public class ReaderUnitsInitTest {

	private static ReaderUnitsDao readerUnitsDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		readerUnitsDao = (ReaderUnitsDao) BaseSpringBeans.getInstance()
				.getBean("readerUnitsDao");
	}

	// @Test //��ʼ�����ڵ� ��������ѧԺ ����ɾ��
	public void testUnitsRootInit() {
		ReaderUnits readerUnits = new ReaderUnits();
		readerUnits.setUnitcode("10000");
		readerUnits.setUnitName("��������ѧԺ");
		readerUnits.setUnitDesc("��������ѧԺͼ���");
		readerUnits.setUnitShortName("lib");
		readerUnits.setParentUnit(null);

		readerUnitsDao.saveOrUpdate(readerUnits);
	}

	@Test
	// ¼�� ��������ѧԺ��Ժ /��Ժ
	public void testUnitsChildrenInit() {

		ReaderUnits parentUnit = readerUnitsDao.selectById(1);

		ReaderUnits readerUnitsS = new ReaderUnits();
		readerUnitsS.setUnitcode("10002");
		readerUnitsS.setUnitName("��������ѧԺ��Ժ");
		readerUnitsS.setUnitDesc("��������ѧԺͼ���");
		readerUnitsS.setUnitShortName("lib");
		readerUnitsS.setParentUnit(parentUnit);
		readerUnitsDao.saveOrUpdate(readerUnitsS);

		ReaderUnits readerUnitsN = new ReaderUnits();
		readerUnitsN.setUnitcode("10003");
		readerUnitsN.setUnitName("��������ѧԺ��Ժ");
		readerUnitsN.setUnitDesc("��������ѧԺͼ���");
		readerUnitsN.setUnitShortName("lib");
		readerUnitsN.setParentUnit(parentUnit);

		readerUnitsDao.saveOrUpdate(readerUnitsN);
	}

}
