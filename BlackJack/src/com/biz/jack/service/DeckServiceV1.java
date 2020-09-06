package com.biz.jack.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.biz.jack.domain.DeckVO;

//게임에서 사용할 한벌의 게임카드를 생성하는 부분
public class DeckServiceV1 {

	// 생성된 1벌의 카드를 리스트에 담기

	List<DeckVO> deckList;
	String suit = "다이아몬드◆:하트♥:스페이드♠:클로버♣";

	// 배열!!!
	String[] arrSuit = new String[] { "다이아몬드◆", "하트♥", "스페이드♠", "클로버♣" };
	String denomination = "A234567890KQJ";

public DeckServiceV1() {
	this.deckList =new LinkedList<DeckVO>();
}

public List<DeckVO> getDeck(){
	
	for(DeckVO vo :deckList ) {
		Collections.shuffle(this.deckList);	
	}
	
	return this.deckList;
}

public void makeDeck() {
	
	String[] denoms = denomination.split("");
	for(String suit :arrSuit) { //52번 반복
		
		for(String denom : denoms) {
			// 각 카드가 갖게 될 value값 생성
			// value는 denoms 기준으로 생성
			// 2~9까지는 보이는 값 그대로사용
			//A는 1로, JQK는 10으로
			
			int intValue=0;
			
			try {
				// 2~9까지는 각각 값들이 정수로 정상변환된다
				//하지만 AJQK는 exception 발생
				// catch실행될것
				intValue = Integer.valueOf(denom);	
				if(intValue ==0) intValue=10;
				// 위에 0이 10임
			}catch (Exception e) {
				if(denom.equals("A")) intValue=1;
				else intValue =10; //JKQ일때
			}
			
			DeckVO dVO = new DeckVO();
			dVO.setSuit(suit);
			dVO.setDenomination(denom);
			dVO.setValue(intValue);
			
			deckList.add(dVO);
		}
	}
	
	
	
}

}