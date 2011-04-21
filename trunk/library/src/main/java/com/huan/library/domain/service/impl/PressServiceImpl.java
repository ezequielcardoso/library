package com.huan.library.domain.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PressService;
import com.huan.library.infrastructure.persistence.PressDao;
import com.huan.library.util.FileOperate;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.PressView;

@Service("pressService")
public class PressServiceImpl implements PressService {

	@Autowired
	private PressDao pressDao;

	public PressDao getPressDao() {
		return pressDao;
	}

	public void setPressDao(PressDao pressDao) {
		this.pressDao = pressDao;
	}

	public Press addOrModifyPress(Press press) throws Exception {
		Press pressCopy = new Press();
		try {
			pressCopy = pressDao.saveOrUpdate(press);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return pressCopy;
	}

	public void removePress(Press press) throws Exception {
		try{
		   pressDao.delete(press);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Press findPressById(Long pressId) throws Exception {
		Press pressCopy = new Press();
		try {
			pressCopy = pressDao.selectById(pressId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return pressCopy;
	}

	public PageModel<Press> findPressesByPage(int pageNo, int pageSize)
			throws Exception {
		PageModel<Press> pageModel = new PageModel<Press>();
		try {
			pageModel = pressDao.selectByPage(pageNo, pageSize);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return pageModel;
	}

	public List<Press> findPresses(PressView pressView) throws Exception{
		List<Press> presses = new ArrayList<Press>();
		try {
			presses = this.pressDao.selectPresses(pressView);
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return presses;
	}

	
	/**
	 * public static void writeExcel(OutputStream os) throws Exception {
	    jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(os);
	    
	    jxl.write.WritableSheet ws = wwb.createSheet("TestSheet1", 0);
	    jxl.write.Label labelC = new jxl.write.Label(0, 0, "我爱中国");
	    ws.addCell(labelC);
	    jxl.write.WritableFont wfc = new jxl.write.WritableFont(WritableFont.ARIAL,20, WritableFont.BOLD, false,
	    UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.GREEN);
	    jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(wfc);
	    wcfFC.setBackground(jxl.format.Colour.RED);
	    labelC = new jxl.write.Label(6, 0, "中国爱我",wcfFC);
	    ws.addCell(labelC);
	    //写入Exel工作表
	    wwb.write();
	    //关闭Excel工作薄对象
	    wwb.close();
	    }

	    //最好写一个这样的main方法来测试一下你的这个class是否写好了。
	    public static void main(String[] args)throws Exception{
	    
	     File f= new File("F://kk.xls");
	    f.createNewFile();
	    writeExcel(new FileOutputStream(f));
	    }
	 */
	public void exportExcel(String rootDir, PressView pressView) {
		List<Press> presses = new ArrayList<Press>();
		try {
			presses = this.pressDao.selectPresses(pressView);
			FileOperate.newFile("temp", rootDir);
			File reportFile = new File(rootDir+"/temp/presses.xls");
			reportFile.createNewFile();
			
//			WritableWorkbook wwb = Workbook.createWorkbook(os);		
			
		} catch (Exception e) {
		  
		}	
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
