package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.BookVO;

public class BookServiceImplV1 implements BookService{

	List<BookVO> bookList;
	Scanner scan = new Scanner(System.in);
	BookVO bookvo = new BookVO();
	

	public BookServiceImplV1() {
		bookList = new ArrayList<>();
		
	}
	
	@Override
	public boolean inputBook() {
		
		
		System.out.println("도서코드를 입력하세요!");
		String code = scan.nextLine(); //문자열 입력하기위해 string
		
		try {
			code=String.format("%05d", Integer.valueOf(code));
			if(Integer.valueOf(code) >5) {
				System.out.println("도서코드는 1~5자리만 유효합니다");
				System.out.println("다시 입력하세요");
				return false;
			}
			
		} catch (Exception e) {
			
			
		}
		bookvo.setCode(code);
		//bookList.add(bookvo);
		
		while(1==1) {
		System.out.println("도서명을 입력하세요");
		String name =scan.nextLine();
		//bookvo.setName(name);
		
		//String strName="";
		try {
			if("".equals(name)){
				//return false;
				System.out.println("도서명은 반드시 입력해야 합니다");
				System.out.println("도서명을 다시 입력하세요!");
				continue;
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
		
	}

}