package com.biz.exec;

import com.biz.service.StudentService;
import com.biz.service.StudentServiceImplV1;

public class StudentEx {

	public static void main(String[] args) {

		StudentService sService = new StudentServiceImplV1();

		

		while(true) {
			
			sService.loadList();
			if(sService.inputNum())
			if(sService.inputName())
			if(sService.inputDept())
			if(sService.inputGrade())
			if(sService.inputTel())
				break;
		}

		sService.saveList();
		sService.studentList();
		

	}
}
