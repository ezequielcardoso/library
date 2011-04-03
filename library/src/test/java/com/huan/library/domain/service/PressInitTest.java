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
 * 出版社初始化
 * @author huan
 * @time  2011-3-16 下午03:42:51
 */
public class PressInitTest {
   
	private static String filePath = Constants.ExcelDir + "press.xls";
	
    private static PressDao pressDao;
    
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pressDao = (PressDao)BaseSpringBeans.getInstance().getBean("pressDao");
	}
   
    //@Test  //分页测试
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
    
	@Test  //初始化出出版社
	public void testPressInit(){
		List<Press> presses = new ArrayList<Press>();
		try {
			// 文件流指向excel文件
			FileInputStream fin = new FileInputStream(filePath);
			//InputStream is = this.getClass().getClassLoader().getResourceAsStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fin);// 创建工作薄
			HSSFSheet sheet = workbook.getSheetAt(0);// 得到工作表
			HSSFRow row = null;// 对应excel的行
			HSSFCell cell = null;// 对应excel的列
         
           int totalRow = sheet.getLastRowNum();// 得到excel的总记录条数
          
			for (int i = 0; i <=totalRow; i++) {
				Press press = new Press();
				 String pressAddress=null; //地址
			     String pressISBN = null; //ISBN
				 String pressName = null; //出版社名称
				 String zipCode = null;   //邮编
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
