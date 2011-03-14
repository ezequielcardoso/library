package com.huan.library.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Dom4J操作XML文件
 * @author Administrator
 *
 */
public class Dom4JUtil {

	/**
	 * 从文件读取XML，输入文件名，返回XML文档
	 * @param fileName
	 * @return
	 */
	public static Document read(String fileName){
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(fileName));
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		return document;
	}

	/**
	 * 取得Root节点
	 * @param doc
	 * @return
	 */
	public static Element getRootElement(Document doc) {
		return doc.getRootElement();
	}


    /**
     * Xml文件输出
     * @param document
     * @param fileName
     */
    public static void writeByFileWriter(Document document, String fileName){
        FileWriter out;
		try {
			out = new FileWriter( fileName );
			document.write(out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Xml文件输出--缩减格式
     * @param document
     * @param fileName
     * @param encoding
     */
    public static void writeByXMLWriterCompactFormat(Document document, String fileName, String encoding) {
        XMLWriter writer;
		try {
			OutputFormat format = OutputFormat.createCompactFormat();
			/** 指定XML编码 */
	        format.setEncoding(encoding);
	        writer = new XMLWriter( new FileWriter( fileName ), format );
	        writer.write( document );
	        writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
        
     }
    
    /**
     * Xml文件输出--无格式
     * @param document
     * @param fileName
     */
    public static void writeByXMLWriterNoFormat(Document document, String fileName) {
        XMLWriter writer;
		try {
			writer = new XMLWriter( new FileWriter( fileName ));
			writer.write( document );
	        writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
        
     }
    
    /**
     * Xml文件输出--美化格式
     * @param document
     * @param fileName
     * @param encoding
     */
    public static void writeByXMLWriterPrettyPrint(Document document, String fileName, String encoding) {
        XMLWriter writer;
		try {
	        OutputFormat format = OutputFormat.createPrettyPrint();
	        /** 指定XML编码 */
	        format.setEncoding(encoding);
	        writer = new XMLWriter( new FileWriter( fileName ), format );
	        writer.write( document );
	        writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
        
     }

    
}
