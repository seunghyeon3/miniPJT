package com.edu.ProductController;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controller.Controller;
import com.edu.service.GatherModel;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 싱글톤(싱글톤 객체로 gatherModel 쓰면 됨)
	GatherModel getBoard = GatherModel.getInstance();

	// .do 파일을 list에 담아서 사용하기 위함
	HashMap<String, Controller> list = null;

	public ProductServlet() {

		super();
	}
	
	@Override
	public void init() throws ServletException {
		list.put("/productServlet/productInsert.do", new ProductInsertController());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ckeditor 서버로 전송.
		   ServletContext context = getServletContext();
		      String saveUrl = context.getRealPath("upload");
		      System.out.println(saveUrl);
		      int maxSize = 30 * 1024 * 1024;
		      String encoding = "UTF-8";
		      
		   
		      MultipartRequest mRequest = new MultipartRequest(request, // 요청정보
		            saveUrl, // 저장위치
		            maxSize, // Max Size
		            encoding, // encoding 방식
		            new DefaultFileRenamePolicy() // 리네임정책
		      );
		      

		      Enumeration names = mRequest.getFileNames();

		      while (names.hasMoreElements()) {
		         String name = (String)names.nextElement();
		         String fileName = mRequest.getFilesystemName(name);
		         
		         String fileUrl = request.getContextPath() + "/upload/" + fileName;
		         
		         System.out.println(fileUrl);
		         
		         // ckditor 결과값을 반환.
		         JsonObject json = new JsonObject();
		         json.addProperty("upload", 1); // 성공 1 실패 0
		         json.addProperty("fileName", fileName);
		         json.addProperty("url", fileUrl);
		         
		         response.setContentType("application/json;charset=UTF-8");
		         response.getWriter().print(json);
		         
		         
			
		}
		

	}

}
