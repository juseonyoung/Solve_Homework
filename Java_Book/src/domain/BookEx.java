package domain;

import service.BookService;
import service.BookServiceImplV1;

public class BookEx {

	public static void main(String[] args) {
		
		BookService bService = new BookServiceImplV1();
		
		while(1==1) {
			if(bService.inputBook()) {
				break;
			}
		}
		//System.out.println("입력완료");
		bService.bookList();
		bService.inputBook();
	}
}
