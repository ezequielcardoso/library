package com.huan.library.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class ResponseUtils {

	public static void outJsonObj(HttpServletResponse response,
			JSONObject jsonObject) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("json=>" + jsonObject.toString());
		out.write(jsonObject.toString());
		out.flush();
		out.close();

	}

}
