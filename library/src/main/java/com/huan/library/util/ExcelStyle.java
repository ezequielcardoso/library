package com.huan.library.util;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class ExcelStyle {
	/**
	 * 列头
	 * @return
	 * @throws Exception
	 */
    public static WritableCellFormat getHeaderStyle() throws Exception {   
        WritableFont font = new WritableFont(WritableFont.TIMES, 14); // 设置14号字体   
        font.setColour(Colour.BLUE); // 设置字体颜色   
        font.setBoldStyle(WritableFont.BOLD); // 设置粗体字   
        WritableCellFormat format = new WritableCellFormat(font); // 设置单元格样式   
        format.setBackground(Colour.LIGHT_GREEN); // 设置背景颜色   
        format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);//设置边界样式   
        format.setAlignment(Alignment.CENTRE); // 设置水平位置   
        format.setVerticalAlignment(VerticalAlignment.CENTRE); // 设置竖直位置   
        return format;   
    } 

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
	
	 /**  
     * 内容样式  
     */  
    public static WritableCellFormat getContentStyle() throws Exception {   
        WritableFont font = new WritableFont(WritableFont.TIMES, 14);   
        font.setColour(Colour.BLUE);   
        WritableCellFormat format = new WritableCellFormat(font);   
        format.setBackground(Colour.VERY_LIGHT_YELLOW);   
        format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);   
        format.setAlignment(Alignment.CENTRE);   
        format.setVerticalAlignment(VerticalAlignment.CENTRE);   
        return format;   
    }   
	
    /**  
     * 标题样式  
     */  
    public static WritableCellFormat getTitleStyle() throws Exception {   
        WritableFont font = new WritableFont(WritableFont.TIMES, 14);   
        font.setColour(Colour.GREEN);   
        WritableCellFormat format = new WritableCellFormat(font);   
        format.setBackground(Colour.VERY_LIGHT_YELLOW);   
        format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);   
        format.setAlignment(Alignment.CENTRE);   
        format.setVerticalAlignment(VerticalAlignment.CENTRE);   
        return format;   
    }  

    /**  
     * 普通样式  
     */  
    public static WritableCellFormat getNormalStyle() throws Exception {   
        WritableFont font = new WritableFont(WritableFont.TIMES, 14);   
        font.setColour(Colour.BLUE);   
        WritableCellFormat format = new WritableCellFormat(   
                DateFormats.FORMAT12);   
        format.setBackground(Colour.VERY_LIGHT_YELLOW);   
        format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);   
        format.setAlignment(Alignment.CENTRE);   
        format.setVerticalAlignment(VerticalAlignment.CENTRE);   
        return format;   
    }   

    /**  
     * 日期样式  
     */  
    public static WritableCellFormat getDateStyle() throws Exception {   
        WritableFont font = new WritableFont(WritableFont.TIMES, 14);   
        font.setColour(Colour.BLUE);   
        WritableCellFormat format = new WritableCellFormat(   
                DateFormats.FORMAT1);   
        format.setBackground(Colour.VERY_LIGHT_YELLOW);   
        format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);   
        format.setAlignment(Alignment.CENTRE);   
        format.setVerticalAlignment(VerticalAlignment.CENTRE);   
        return format;   
    }   
}
