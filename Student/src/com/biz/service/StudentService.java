package com.biz.service;

public interface StudentService {

	
	public boolean inputNum();
	public boolean inputName();
	public boolean inputDept();
	public boolean inputGrade();
	public boolean inputTel();
	
	public void saveList(); //저장하고
	public void loadList(); //로드
	public void studentList();
	
	
	//public void lastList();
}
