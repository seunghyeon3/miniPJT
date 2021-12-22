package com.edu.ProductController;

import java.io.IOException;
<<<<<<< HEAD
import java.util.Enumeration;
import java.util.HashMap;
=======
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
>>>>>>> 4f2639b949b4c36ad331cd6d9ea9d05770da506f

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
=======
import com.edu.VO.ProductVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
>>>>>>> 4f2639b949b4c36ad331cd6d9ea9d05770da506f
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 싱글톤(싱글톤 객체로 gatherModel 쓰면 됨)

	GatherModel getProduct = GatherModel.getInstance();

	// .do 파일을 list에 담아서 사용하기 위함
	HashMap<String, Controller> list = null;

	public ProductServlet() {

		super();
	}
	
	@Override
	public void init() throws ServletException {

		list = new HashMap<String, Controller>();
		//입력
		list.put("/productServlet/productInsert.do", new ProductInsertController());
		//전체상품화면
		list.put("/productServlet/productShow.do", new ProductShowController());
		//상품삭제
		//list.put("/productServlet/productDelete.do", new ProductDeleteController());
		//상품수정
		//list.put("/productServlet/productUpdate.do", new ProductUpdateController());
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//상품전체리스트
		String cmd = request.getParameter("cmd");
		if(cmd.equals("productList")) {
		//상품리스트를 불러오는 DAO
			List<ProductVO> productList =  getProduct.getProduct();
			System.out.println(productList);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			response.getWriter().print(gson.toJson(productList).toString());
		}
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
		         
		         
			
		String cmd = request.getParameter("cmd");
		
		//cmd null일떄 예외처리 방식 재정의
		if(cmd == null) {
			cmd = "a";
		}
		String uri = request.getRequestURI();
		System.out.println(uri);
		String context = request.getContextPath();
		System.out.println(context);

		int toPos = uri.indexOf(".do");
		Controller subCont = null;
		if(toPos > 0) {
			String path = uri.substring(context.length(), toPos + 3);
			System.out.println(path);
			subCont = list.get(path);
		}else {
			String path = uri.substring(context.length());
			System.out.println(path);
			subCont = list.get(path);
		}
		
		//String path2 = uri.substring(context.length()); 동일함		
		subCont.execute(request, response);
		         
		
		}
		

	}
}
