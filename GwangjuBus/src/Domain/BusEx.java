package Domain;

import java.util.Scanner;

public class BusEx {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("나이를 입력하세요 >>");
			String strAge = scan.nextLine();

			int intAge = 0;
			try {
				intAge = Integer.valueOf(strAge);
			} catch (Exception e) {
				// TODO: handle exception
			}

			if (intAge >= 19 && intAge <= 64) {
				System.out.println("일반요금 대상입니다(1500원)");
			} else if (intAge >=13 && intAge <= 18) {
				System.out.println("청소년 요금입니다(1200원)");
			} else if (intAge >= 7 && intAge <= 12) {
				System.out.println("아동 요금입니다(800원)");
			} else {
				System.out.println("요금이 면제됩니다");
			}
		}
	}
}

/*
 * 만 6세이하는 0원 만 12세이하는 800원 만 18세 이하는 1200원 만 65세 이상은 0원 일반 요금은 1500원 어떤 승객의 나이를
 * 입렷햇을때얼마인지?
 */
