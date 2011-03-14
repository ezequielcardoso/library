package com.huan.library.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetToList {
    public static List<Map<String,Object>> convertList(ResultSet rs) throws SQLException {

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        ResultSetMetaData md = rs.getMetaData();

        int columnCount = md.getColumnCount(); // Map rowData;

        while (rs.next()) { // rowData = new HashMap(columnCount);

            Map<String,Object> rowData = new HashMap<String,Object>();

            for (int i = 1; i <= columnCount; i++) {

                rowData.put(md.getColumnName(i), rs.getObject(i));

            }

            list.add(rowData);

        }
        return list;

    }
    
    public static Map<String,String> convertMap (ResultSet rs) throws SQLException{
    	Map<String,String> map = new HashMap<String,String>();
    	ResultSetMetaData md = rs.getMetaData();
    	int columncounts = md.getColumnCount();
    	while (rs.next()) {
    	for(int i=1; i<=columncounts;i++){
    		if(rs.getObject(i) != null){		
    			map.put(md.getColumnName(i), rs.getObject(i).toString());
    		}else{
    			map.put(md.getColumnName(i), null);
    		}
    	}
      }
    	return map;
    }
}
