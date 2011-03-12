package com.huan.library.util;

import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class ExcelStyle {

    /**
     * 列表内容样式   
     * @param format
     * @param topb
     * @param bottomb
     * @param leftb
     * @param rightb
     * @return
     * @throws Exception
     */
    public static WritableCellFormat getContentStyle(CellFormat format, boolean topb, boolean bottomb, boolean leftb, boolean rightb) throws Exception {   
    	WritableFont wfont = new WritableFont(format.getFont());
    	WritableCellFormat wformat = new WritableCellFormat(wfont);
		wformat.setAlignment(format.getAlignment());
		wformat.setVerticalAlignment(format.getVerticalAlignment());
    	wformat.setWrap(format.getWrap());
        //设置边框
    	if(format.getBorderLine(Border.ALL)==BorderLineStyle.NONE){
    		wformat.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK); 
    	}
        if(topb==true){
        	wformat.setBorder(Border.TOP, BorderLineStyle.MEDIUM);
        } else {
        	wformat.setBorder(Border.TOP, format.getBorderLine(Border.TOP));
        }
        if(bottomb==true){
        	wformat.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
        } else {
        	wformat.setBorder(Border.BOTTOM, format.getBorderLine(Border.BOTTOM));
        }
        if(leftb==true){
        	wformat.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
        } else {
        	wformat.setBorder(Border.LEFT, format.getBorderLine(Border.LEFT));
        }
        if(rightb==true){
        	wformat.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
        } else {
        	wformat.setBorder(Border.RIGHT, format.getBorderLine(Border.RIGHT));
        }
        return wformat;   
    } 

    /**
     * 合并单元格样式
     * @param leftTopCellFormat
     * @param rightBottomCellFormat
     * @return
     * @throws Exception
     */
	public static CellFormat getContentStyle(CellFormat leftTopCellFormat,
			CellFormat rightBottomCellFormat) throws Exception {
		WritableFont wfont = new WritableFont(leftTopCellFormat.getFont());
    	WritableCellFormat wformat = new WritableCellFormat(wfont);
		wformat.setAlignment(leftTopCellFormat.getAlignment());
		wformat.setVerticalAlignment(leftTopCellFormat.getVerticalAlignment());
    	wformat.setWrap(leftTopCellFormat.getWrap());
    	wformat.setBorder(Border.TOP, leftTopCellFormat.getBorderLine(Border.TOP));
    	wformat.setBorder(Border.BOTTOM, rightBottomCellFormat.getBorderLine(Border.BOTTOM));
    	wformat.setBorder(Border.LEFT, leftTopCellFormat.getBorderLine(Border.LEFT));
    	wformat.setBorder(Border.RIGHT, rightBottomCellFormat.getBorderLine(Border.RIGHT));
        return wformat;   
	}

	/**
	 * 单元格样式
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static CellFormat getContentStyle(CellFormat format) throws Exception {
		WritableFont wfont = new WritableFont(format.getFont());
    	WritableCellFormat wformat = new WritableCellFormat(wfont);
		wformat.setAlignment(format.getAlignment());
		wformat.setVerticalAlignment(format.getVerticalAlignment());
    	wformat.setWrap(format.getWrap());
    	wformat.setBorder(Border.TOP, format.getBorderLine(Border.TOP));
    	wformat.setBorder(Border.BOTTOM, format.getBorderLine(Border.BOTTOM));
    	wformat.setBorder(Border.LEFT, format.getBorderLine(Border.LEFT));
    	wformat.setBorder(Border.RIGHT, format.getBorderLine(Border.RIGHT));
        return wformat;   
	}

}