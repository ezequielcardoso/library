package com.huan.library.domain.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.application.Constants;
import com.huan.library.domain.model.book.Press;
import com.huan.library.infrastructure.persistence.PressDao;
import com.huan.library.util.PageModel;

/**
 * �������ʼ��
 * @author huan
 * @time  2011-3-16 ����03:42:51
 */
public class PressInitTest {
   
	private static String filePath = Constants.ExcelDir + "press.xls";
	
    private static PressDao pressDao;
    
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pressDao = (PressDao)BaseSpringBeans.getInstance().getBean("pressDao");
	}
   
    //@Test  //��ҳ����
    public void findByPage(){
    	try {
			PageModel<Press> pressModel = pressDao.selectByPage(0, 3);
			List<Press> pressList = pressModel.getRestleList();
			System.out.println(pressModel.getTotalRecords());
			for(Press press:pressList){
				System.out.println(press.getPressId()+" "+ press.getPressName()+" " +press.getPressAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	@Test  //��ʼ����������
	public void testPressInit(){
		List<Press> presses = new ArrayList<Press>();
		try {
			// �ļ���ָ��excel�ļ�
			FileInputStream fin = new FileInputStream(filePath);
			//InputStream is = this.getClass().getClassLoader().getResourceAsStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fin);// ����������
			HSSFSheet sheet = workbook.getSheetAt(0);// �õ�������
			HSSFRow row = null;// ��Ӧexcel����
			HSSFCell cell = null;// ��Ӧexcel����
         
           int totalRow = sheet.getLastRowNum();// �õ�excel���ܼ�¼����
          
			for (int i = 0; i <=totalRow; i++) {
				Press press = new Press();
				 String pressAddress=null; //��ַ
			     String pressISBN = null; //ISBN
				 String pressName = null; //����������
				 String zipCode = null;   //�ʱ�
				row = sheet.getRow(i);
				cell = row.getCell(0);
				pressISBN = cell.getRichStringCellValue().toString();
				cell = row.getCell(1);
				pressName = cell.getRichStringCellValue().toString();
				cell=row.getCell(2);   
				if(cell!=null && !"".equals(cell)){
					pressAddress=cell.getRichStringCellValue().toString();
				}else{
				    pressAddress=" ";
				}
				cell=row.getCell(3);   
				if(cell!=null && !"".equals(cell)){
					String zipCodeCopy=String.valueOf(cell);
					zipCode = zipCodeCopy.substring(0, zipCodeCopy.length()-2);
				}else{
					zipCode=" ";
				}
				press.setPressISBN(pressISBN);
				press.setPressName(pressName);
				press.setPressAddress(pressAddress);
				press.setZipCode(zipCode);
				presses.add(press);
			}
			pressDao.insertPressBatch(presses);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}	
	}
}
