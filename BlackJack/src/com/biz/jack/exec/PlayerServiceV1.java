package com.biz.jack.exec;

import java.util.ArrayList;
import java.util.List;

import com.biz.jack.domain.DeckVO;

public class PlayerServiceV1 {

	//두개의 리스트를 가진다
	
	// 각 플레이어가 받은 카드를 저장할 리스트!
	List<DeckVO> myDeckList;
	
	// 데크에서 한장씩 플레이어에게 전달할 카드들
	List<DeckVO> pubDeckList;
	
	String playerName = "";
	
	
	public PlayerServiceV1(List<DeckVO> deckList) {
		this(deckList,"딜러");
		// 플레이어 이름이 없는 상태로 생성되면 딜러로 쓰겠다
	}
	
	
	//두개를 매개변수로
	public PlayerServiceV1(List<DeckVO> deckList, String playName) {
		
		this.myDeckList = new ArrayList<>();
		this.pubDeckList = deckList;
		this.playerName = playName;
		
	}
	
	// 자신이 받은 카드의 점수를 계산하는 method
	public int sumValue() {
		
		int sumValue = 0;
		for(DeckVO vo : myDeckList) {
			sumValue += vo.getValue();
		}
		return sumValue; //외부에서 쓰도록
	}
	
	// 각 플레이어들이 hit했을 때 수행하는 메서드
	public void hit() {
		
		if(this.playerName.equals("딜러") && this.sumValue() > 16) {
			System.out.println("딜러 점수 :" + this.sumValue());
			System.out.println("딜러 HIT 금지!");
		} else {
			// 받은카드를 내 리스트에 추가
			myDeckList.add(pubDeckList.get(0));
			
			// 받을 카드에서 첫번 1장을 제외(내가 가져옴)
			pubDeckList.remove(0);
			
		}
		System.out.println("================================");
		System.out.println("플레이어:"+playerName);
		System.out.println("================================");
		
		//현재 보유중인 카드리스트
		System.out.println("보유중인 카드");
		for(DeckVO vo : myDeckList) {
			System.out.println(vo);
		}
		System.out.println("================================");
		System.out.println("현재점수:" +this.sumValue());
		
	}
	
	
	
}
