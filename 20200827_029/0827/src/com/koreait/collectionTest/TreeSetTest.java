package com.koreait.collectionTest;

import java.util.TreeSet;
import java.util.Random;

public class TreeSetTest {

	public static void main(String[] args) {
		
//		TreeSet은 중복되는 데이터 입력을 허용하지 않는다.
//		데이터를 입력하는 순서와 입력된 데이터가 실제로 저장되는 순서가 달라서 get(), set() 메소드가 제공되지 않는다.
//		TreeSet은 HashSet과 다르게 데이터가 입력되는 순서와 관계 없이 오름차순으로 정렬되서 저장된다.
		
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
//		add(value) => TreeSet에 value를 저장한다.
		tset.add(500);
//		size() => TreeSet에 저장된 데이터의 개수를 얻어온다.
		System.out.println(tset.size() + " : " + tset);
		tset.add(100);
		System.out.println(tset.size() + " : " + tset);
		tset.add(999);
		System.out.println(tset.size() + " : " + tset);
		tset.add(50);
		System.out.println(tset.size() + " : " + tset);
		tset.add(100);		// 중복되는 데이터는 입력되지 않는다.
		System.out.println(tset.size() + " : " + tset);
		
//		remove(value) => TreeSet에 저장된 value를 제거한다.
		tset.remove(500);
		System.out.println(tset.size() + " : " + tset);
//		clear() => TreeSet에 저장된 모든 데이터를 제거한다.
		tset.clear();
		System.out.println(tset.size() + " : " + tset);
		
//		로또 1등 번호
		Random random = new Random();
		while (true) {
			int lotto = random.nextInt(45) + 1;
			tset.add(lotto);
//			TreeSet 객체에 중복되지 않는 숫자 6개가 저장되면 무한 루프를 탈출한다.
			if (tset.size() == 6) {
				break;
			}
		}
		System.out.println("1등 번호 : " + tset);
		
//		보너스
		int bonus = 0;
//		while (true) {
//			bonus = random.nextInt(45) + 1;
//			tset.add(bonus);
//			if (tset.size() == 7) {
//				break;
//			}
//		}
//		tset.remove(bonus);
//		System.out.println("1등 번호 : " + tset);
//		System.out.println("보너스 번호 : " + bonus);

		while (true) {
			bonus = random.nextInt(45) + 1;
//			contains() : 객체에 인수로 지정된 데이터가 포함되어 있으면 true, 없으면 false를 리턴한다.
//			if (tset.contains(bonus) == false) {
			if (!tset.contains(bonus)) {
				break;
			}
		}
		System.out.println("1등 번호 : " + tset);
		System.out.println("보너스 번호 : " + bonus);
		
	}
	
}











