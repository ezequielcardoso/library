package com.huan.library.util;

import java.util.Date;

import jxl.format.CellFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
/**
 * EXCEL CELL 操作
 * @author Administrator
 *
 */
public class ExcelOperate {

	/**
	 * 写入文本  
	 * @param ws
	 * @param col
	 * @param row
	 * @param cont
	 * @param format
	 * @throws Exception
	 */
    public static void addLabelToSheet(WritableSheet ws, int col, int row,   
            String cont, CellFormat format) throws Exception {   
        Label label = new Label(col, row, cont, format);   
        ws.addCell(label);   
    }   

    /**
     * 写入文本(合并后的单元格) 
     * @param ws
     * @param firstCol
     * @param firstRow
     * @param lastCol
     * @param lastRow
     * @param cont
     * @param format
     * @throws Exception
     */
    public static void addLabelToSheet(WritableSheet ws, int firstCol,   
            int firstRow, int lastCol, int lastRow, String cont,   
            CellFormat format) throws Exception {   
        ws.mergeCells(firstCol, firstRow, lastCol, lastRow);   
        addLabelToSheet(ws, firstCol, firstRow, cont, format);   
    }   

    /**
     * 写入数字   
     * @param ws
     * @param col
     * @param row
     * @param num
     * @param format
     * @throws Exception
     */
    public static void addLabelToSheet(WritableSheet ws, int col, int row,   
            double num, CellFormat format) throws Exception {   
        Number number = new Number(col, row, num, format);   
        ws.addCell(number);   
    }   

    /**
     * 写入日期  
     * @param ws
     * @param col
     * @param row
     * @param date
     * @param format
     * @throws Exception
     */
    public static void addLabelToSheet(WritableSheet ws, int col, int row,   
            Date date, CellFormat format) throws Exception {   
        DateTime dt = new DateTime(col, row, date, format, DateTime.GMT);   
        ws.addCell(dt);   
    }   
    
    
}
