package com.biz.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.domain.StudentVO;

public class StudentServiceImplV1 implements StudentService {

	private List<StudentVO> studentList;
	private StudentVO stuvo = new StudentVO();
	private Scanner scan;
	private String sFile = "";

	public StudentServiceImplV1() {
		studentList = new ArrayList<>();
		sFile = "src/com/biz/data/student.txt";
		scan = new Scanner(System.in);

	}

	@Override
	public boolean inputNum() {
		// StudentVO stuvo = new StudentVO();

		int year=2020;
		while (true) {
			System.out.println("학번을 입력하세요!");
			String num = scan.nextLine(); // 문자열 입력하기위해 string

			try {
				num=String.format("%04d", Integer.valueOf(num));
			} catch (Exception e) {
			}
			//int intNum = num.length();
			/*
			 * try { intNum = Integer.valueOf(num);
			 * 
			 * } catch (Exception e) { System.out.println("학년은 숫자로만 입력해야 합니다"); return
			 * false; }
			 */
			/*
			 * int intNum = num.length();
			 * 
			 * if (intNum < 0 || intNum > 4) { System.out.println("4자리이내"); continue; }
			 * 
			 * num = String.format("%04d",intNum);
			 */
			stuvo.setNum(year+num);
			

			for(StudentVO stuvo : studentList) {
				if(stuvo.getNum().equals(year+num)){
					System.out.println((year+num)+"학생의 학번이 이미 등록되어 있습니다");
					return false;
					
				}
			}
			break;
		}
		return true;
	}

	@Override
	public boolean inputName() {
		while (true) {

			System.out.println("이름을 입력해 주세요 >>");
			String name = scan.nextLine();
			if (name.isEmpty()) {
				System.out.println("이름은 반드시 입력해야 합니다");
				continue;
			}
			stuvo.setName(name);
			break;
		}
		return true;
	}

	@Override
	public boolean inputDept() {
		while (true) {

			System.out.println("전공을 입력하세요 >>");
			String dept = scan.nextLine();
			if (dept.isEmpty()) {
				System.out.println("전공을 반드시 입력하세요");
				continue;
			}
			stuvo.setDept(dept);
			break;
		}
		return true;

	}

	@Override
	public boolean inputGrade() {
		while (true) {
			System.out.println("학년을 입력해 주세요 >>");
			String grade = scan.nextLine();

			int intGrade = 0;
			try {
				intGrade = Integer.valueOf(grade);

			} catch (Exception e) {
				System.out.println("학년은 숫자로만 입력해야 합니다");
				return false;
			}
			

			if (intGrade < 1 || intGrade > 5) {
				System.out.println("학년은 1~5 범위여야 합니다");
				continue;
			}
			stuvo.setGrade(grade);
			break;
		}
		return true;
	}

	@Override
	public boolean inputTel() {
		while (true) {

			System.out.println("전화번호를 입력해 주세요 >>");
			String tel = scan.nextLine();
			if (tel.isEmpty()) {
				System.out.println("번호를 반드시 입력해야 합니다");
				continue;
			}
			stuvo.setTel(tel);
			break;
		}
		return true;
	}

	@Override
	public void saveList() {

		FileWriter filewriter = null;
		PrintWriter printwriter = null;

		try {
			filewriter = new FileWriter(sFile,true);
			printwriter = new PrintWriter(filewriter);

			String st = String.format("%s:%s:%s:%s:%s", stuvo.getNum(), stuvo.getName(), stuvo.getDept(),
					stuvo.getGrade(), stuvo.getTel());

			printwriter.println(st);
			printwriter.flush();
			printwriter.close();

		} catch (Exception e) {
			System.out.println("파일을 열 수 없습니다");
		}
		studentList.add(stuvo);
		// return true;

	}

	@Override
	public void loadList() {
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(sFile);
			buffer = new BufferedReader(fileReader);

			String reader = "";

			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}
				String[] st = reader.split(":");

				StudentVO stuvo = new StudentVO();
				stuvo.setNum((st[0]));
				stuvo.setName(st[1]);
				stuvo.setDept(st[2]);
				stuvo.setGrade(st[3]);
				stuvo.setTel(st[4]);

				studentList.add(stuvo); // 중요!!

			}
			buffer.close();
			fileReader.close();

		} catch (Exception e) {
			System.out.println("파일을 읽을 수 없습니다");
		}

	}

	@Override
	public void studentList() {
		System.out.println("====================================================");
		System.out.println("학생 정보");
		System.out.println("====================================================");

		for (StudentVO stuvo : studentList) {
			System.out.printf("학번:"+"%s\t", stuvo.getNum());
			System.out.println();
			System.out.printf("이름:"+"%s\t", stuvo.getName());
			System.out.println();
			System.out.printf("전공:"+"%s\t", stuvo.getDept());
			System.out.println();
			System.out.printf("학년:"+"%s\t", stuvo.getGrade());
			System.out.println();
			System.out.printf("전화번호:"+"%s\t", stuvo.getTel());
		}
		System.out.println("====================================================");
	}

}
