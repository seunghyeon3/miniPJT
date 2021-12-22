package com.edu.VO;

public class ProductVO {
	private String product_id;
	private String product_name;
	private int product_price;
	private String product_content;
	private String product_picture;
	private double product_eval_Point;
		
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
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
	public double getProduct_eval_Point() {
		return product_eval_Point;
	}
	public void setProduct_eval_Point(double product_eval_Point) {
		this.product_eval_Point = product_eval_Point;
	}
	@Override
	public String toString() {
		return "produectVO [product_name=" + product_name + ", product_price=" + product_price + ", product_picture="
				+ product_picture + ", product_content=" + product_content + ", product_id=" + product_id
				+ ", product_eval_Point=" + product_eval_Point + "]";
	}
	
	
}
