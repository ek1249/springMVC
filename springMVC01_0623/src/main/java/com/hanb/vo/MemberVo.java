package com.hanb.vo;

public class MemberVo {
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_gender;
	private String member_hobby;
	private String member_job;
	private String member_soge;
	private String member_age;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String member_id, String member_pwd, String member_name, String member_gender, String member_hobby,
			String member_job, String member_soge, String member_age) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.member_gender = member_gender;
		this.member_hobby = member_hobby;
		this.member_job = member_job;
		this.member_soge = member_soge;
		this.member_age = member_age;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_hobby() {
		return member_hobby;
	}
	public void setMember_hobby(String member_hobby) {
		this.member_hobby = member_hobby;
	}
	public String getMember_job() {
		return member_job;
	}
	public void setMember_job(String member_job) {
		this.member_job = member_job;
	}
	public String getMember_soge() {
		return member_soge;
	}
	public void setMember_soge(String member_soge) {
		this.member_soge = member_soge;
	}
	public String getMember_age() {
		return member_age;
	}
	public void setMember_age(String member_age) {
		this.member_age = member_age;
	}
	
	
}
