package com.hanb.vo;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

public class GoodsVo {

	private int no;
	private String item;
	private int qty;
	private String fname;
	private int price;
	private String detail;
	
	private MultipartFilter uploadFile;
	
	
	public MultipartFile getUploadFile() {
		return (MultipartFile) uploadFile;
	}
	public void setUploadFile(MultipartFilter uploadFile) {
		this.uploadFile = uploadFile;
	}
	public GoodsVo(int no, String item, int qty, String fname, int price, String detail) {
		super();
		this.no = no;
		this.item = item;
		this.qty = qty;
		this.fname = fname;
		this.price = price;
		this.detail = detail;
	}
	public GoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
