package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.BookVO;

public class BookServiceImplV1 implements BookService{

	// 변수, 인스턴스는 private 이나 protected로 선언
	private List<BookVO> bookList;
	private Scanner scan = new Scanner(System.in);
	private BookVO bookvo = new BookVO();
	

	public BookServiceImplV1() {
		bookList = new ArrayList<>();
		
	}
	
	@Override
	public boolean inputBook() {
		
		while(true) {
		System.out.println("도서코드를 입력하세요!");
		String code = scan.nextLine(); //문자열 입력하기위해 string
		
		int intCode = code.length();
		if(intCode <0 || intCode>5) {
			System.out.println("도서코드 5자리이내");
			continue;
		}
		
		code =String.format("%05d", intCode);
		bookvo.setCode(code);
		break;
		/*
		 * try { code=String.format("%05d", code); //code는 스트링인데 왜 integer..
		 * if(code.length() >5) { //자릿수 System.out.println("도서코드는 1~5자리만 유효합니다");
		 * System.out.println("다시 입력하세요"); continue; }
		 * 
		 * } catch (Exception e) {
		 * 
		 * 
		 * }
		 */
		}
		//bookList.add(bookvo);
		
		while(1==1) {
		System.out.println("도서명을 입력하세요");
		String name =scan.nextLine();
		//bookvo.setName(name);
		
		//String strName="";
		try {
			//도서명 입력하지않았을때 .isempty를 써야 null값과 공백이 같이 검사된다
			if(name.isEmpty()){
				//return false;
				System.out.println("도서명은 반드시 입력해야 합니다");
				System.out.println("도서명을 다시 입력하세요!");
				continue; //empty가 아니었을때  if벗어남
			}
			
				
		} catch (Exception e) {
			//String strName=scan.nextLine();
			//bookvo.setName(strName);
			
		}
		bookvo.setName(name);
		
		
		System.out.println("도서가격을 입력하세요");
		String strPrice = scan.nextLine();
		
		int Price=0;
		try {
			Price=Integer.valueOf(strPrice);
			
		} catch (Exception e) {
			System.out.println("숫자로 입력하세요");
		}
		bookvo.setPrice(Price);
		
		
		bookList.add(bookvo);
		
		return true;
		}
		}
	
	
	

	@Override
	public void bookList() {
		System.out.println("도서대출현황");
		System.out.println("======================================");
		for(BookVO bvo : bookList) {
			System.out.println("도서코드 : "+bvo.getCode());
			System.out.println("도서명 : "+bvo.getName());
			System.out.println("도서가격 : "+bvo.getPrice()+"원");
			
		}
		System.out.println("======================================");
		
		//scan.close();
	}

}
