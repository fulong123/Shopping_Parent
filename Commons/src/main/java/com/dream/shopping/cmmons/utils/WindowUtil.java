package com.dream.shopping.cmmons.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class WindowUtil {

	private WindowUtil() {
		throw new AbstractMethodError();
	}
	
	public static void window(HttpServletResponse resp, String description, String path) {

		try {
			resp.getWriter().print("<script>alert('"+ description + "');location.href='" + path +"'; </script>");
		} catch (IOException e) {
			System.out.println("弹窗错误!");
		}
	}
}
