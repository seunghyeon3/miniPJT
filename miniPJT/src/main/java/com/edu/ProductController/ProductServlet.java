package com.edu.ProductController;

import java.io.IOException;
<<<<<<< HEAD
=======

import java.util.Enumeration;
import java.util.HashMap;

>>>>>>> 83bce4341f3b5d0a29ef78029a4fcb04e38504d2
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

=======
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
>>>>>>> 83bce4341f3b5d0a29ef78029a4fcb04e38504d2
import com.edu.VO.ProductVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

	
	@Override
	public void init() throws ServletException {
		list = new HashMap<String, Controller>();
		// 상품 입력
		list.put("/productServlet/productInsert.do", new ProductInsertController());
<<<<<<< HEAD
		//전체상품화면
		//list.put("/productServlet/productShow.do", new ProductShowController());
		//상품삭제
		//list.put("/productServlet/productDelete.do", new ProductDeleteController());
		//상품수정
		//list.put("/productServlet/productUpdate.do", new ProductUpdateController());
=======

		//상품 조회
		list.put("/productServlet/productSearch.do", new ProductSearchConroller());
		// 상품삭제
		list.put("/productServlet/productDelete.do", new ProductDeleteController());
		// 상품 수정
		list.put("/productServlet/productUpdate.do", new ProductUpdateController());
		
>>>>>>> 83bce4341f3b5d0a29ef78029a4fcb04e38504d2
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//상품전체리스트
		String cmd = request.getParameter("cmd");
		if(cmd.equals(null)) {
			cmd = "a";
		}
		if(cmd.equals("productList")) {
		//상품리스트를 불러오는 DAO
			List<ProductVO> productList =  getProduct.listProduct();
			System.out.println(productList);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			response.getWriter().print(gson.toJson(productList).toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		//cmd null일떄 예외처리 방식 재정의
		if(cmd == null) {
			cmd = "a";
		}
		String uri = request.getRequestURI();
		System.out.println(uri);
//		String context = request.getContextPath();
//		System.out.println(context);
//
//		int toPos = uri.indexOf(".do");
//		Controller subCont = null;
//		if(toPos > 0) {
//			String path = uri.substring(context.length(), toPos + 3);
//			System.out.println(path);
//			subCont = list.get(path);
//		}else {
//			String path = uri.substring(context.length());
//			System.out.println(path);
//			subCont = list.get(path);
//		}
//		
//		//String path2 = uri.substring(context.length()); 동일함		
//		subCont.execute(request, response);
//		         
		
		}
		

	}