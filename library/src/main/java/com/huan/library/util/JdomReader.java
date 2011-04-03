package com.huan.library.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * xml文件解析，读取虚拟路径与真实路径映射
 * 2010-9-28 上午09:32:07
 * 
 */
public class JdomReader {
    private static Document doc;
    // 创建解析器对象
    private static SAXBuilder builder = new SAXBuilder(false);
    //解析xml文档
    public static void createDocument(String config) throws JDOMException, IOException{
        doc = builder.build(new File(config));
    }
    //获取根节点
    public static  Element getRootElement(){
        return doc.getRootElement();
    }
    //根据名字获取子节点
    public static Element getChildByName(Element e ,String name){
        return e.getChild(name);
    }
    //获取子节点集合
    @SuppressWarnings("unchecked")
    public static List<Element> getChildren(Element e){
        return e.getChildren();
    }
    //包含业务逻辑的方法，选择可用空间最大的磁盘
    public static Map<String,String> chooseDisk(String mediaType){
        Map<String,String> diskMap = null;
        Element media = getChildByName(getRootElement(),mediaType);
        long diskSpace = 0;
        Element temp = null;
        for(Element e : getChildren(media)){
            File file = new File(e.getValue());
            if(file.exists()&&file.getUsableSpace()>diskSpace){
                temp = e;
                diskSpace = file.getUsableSpace();
            }
        }
        diskMap = new HashMap<String, String>();
        diskMap.put("virtualdisk",temp.getAttributeValue("name"));
        diskMap.put("realpath", temp.getValue());
        return diskMap;
    }
    
  //根据虚拟盘符和虚拟盘符类型找到实际路径
    public static String getRealPath(String mediaType, String virtualDisk){
        Element root = getRootElement();
        Element media = getChildByName(root,mediaType);
        String realPath = "";
        for(Element e : getChildren(media)){
        	if(e.getAttributeValue("name").equalsIgnoreCase(virtualDisk)){
        		realPath = e.getValue();
        	}
        }
        return realPath;
    }
    public static void main(String[] args){
        try {
            createDocument("WebContent\\WEB-INF\\media.xml");
            System.out.println(getRealPath("vedio", "D"));
            System.out.println(chooseDisk("vedio"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //包含业务逻辑的方法，根据虚拟盘符的名字获取真实路径--该方法对当前文档结构不适用
    public static String getRealPathByVirtualdisk(String mediaType,String virtualdisk){
        return getChildByName(getChildByName(getRootElement(), mediaType), virtualdisk).getValue();
    }
}