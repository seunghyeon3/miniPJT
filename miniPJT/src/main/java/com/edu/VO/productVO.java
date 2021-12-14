package com.edu.VO;

public class productVO {

	//DB table column을 기준으로 작성
	private String product_name;
	private String product_price;
	private String product_picture;
	private String product_content;
	private String product_id;
	private String product_eval;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_picture() {
		return product_picture;
	}
	public void setProduct_picture(String product_picture) {
		this.product_picture = product_picture;
	}
	public String getProduct_content() {
		return product_content;
	}
	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_eval() {
		return product_eval;
	}
	public void setProduct_eval(String product_eval) {
		this.product_eval = product_eval;
	}
	@Override
	public String toString() {
		return "produectVO [product_name=" + product_name + ", product_price=" + product_price + ", product_picture="
				+ product_picture + ", product_content=" + product_content + ", product_id=" + product_id
				+ ", product_eval=" + product_eval + "]";
	}
	
	
}
