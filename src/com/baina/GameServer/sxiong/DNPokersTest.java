package com.baina.GameServer.sxiong;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DNPokersTest {
	DNPokers pokers;
	@Before
	public void testDNPokers() {
		pokers = new DNPokers();
		assertNotNull(pokers);
		for (int i = 0; i < pokers.getPoker().length; i++) {
			assertEquals(null, pokers.getPoker()[i]);
		}
		assertEquals(DN_TYPE.UNDEFINED, pokers.getDn_type());
	}
	
	@Test
	public void testGetDn_type() {
		assertEquals(DN_TYPE.UNDEFINED, pokers.getDn_type());
	}

	@Test
	public void testSetDn_type() {
		pokers.setDn_type(DN_TYPE.NIU_NIU);
		assertEquals(DN_TYPE.NIU_NIU, pokers.getDn_type());
	}

	@Test
	public void testGetPoker() {
		Poker[] poker = new Poker[DNPokers.NUM];
		poker = pokers.getPoker();
		for (int i = 0; i < poker.length; i++) {
			assertEquals(null, poker[i]);
		}
	}

	@Test
	public void testSetPokerPokerArray() {
		Poker[] poker = new Poker[DNPokers.NUM];
		for (int i = 0; i < poker.length; i++) {
			poker[i] = new Poker((byte)(i+1),(byte)2);
		}
		pokers.setPoker(poker);
		for (int i = 0; i < pokers.getPoker().length; i++) {
			assertEquals(i+1, pokers.getPoker()[i].getPoker_value());
			assertEquals(2, pokers.getPoker()[i].getPoker_color());
		}
	}

	@Test
	public void testSetPokerPokerInt() {
		Poker[] poker = new Poker[DNPokers.NUM];
		for (int i = 0; i < poker.length; i++) {
			poker[i] = new Poker((byte)(i+1),(byte)2);
		}
		for (int i = 0; i < poker.length; i++) {
			pokers.setPoker(poker[i], i);
		}
		for (int i = 0; i < pokers.getPoker().length; i++) {
			assertEquals(i+1, pokers.getPoker()[i].getPoker_value());
			assertEquals(2, pokers.getPoker()[i].getPoker_color());
		}
	}

	@Test
	public void testGetTypeofNiuNum() {
		Poker []newPoker = new Poker[5];
		for (int j = 0; j < newPoker.length; j++) {
			newPoker[j] = new Poker((byte)(j+9),(byte)3);	
			pokers.getPoker()[j] = newPoker[j];
		}
		newPoker[0].setPoker_value((byte)10);
		newPoker[1].setPoker_value((byte)11);
		newPoker[2].setPoker_value((byte)3);
		newPoker[3].setPoker_value((byte)7);
		for (int i = 0; i <= 9; i++) {
			newPoker[4].setPoker_value((byte)(i+1));
			assertEquals(i+1, pokers.getTypeofNiuNum());
		}
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)7);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)7);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)7);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)7);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)7);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		
		
		
		
		newPoker[0].setPoker_value((byte)11);;
		newPoker[1].setPoker_value((byte)10);
		newPoker[2].setPoker_value((byte)10);
		newPoker[3].setPoker_value((byte)10);
		newPoker[4].setPoker_value((byte)10);
		assertEquals(12,pokers.getTypeofNiuNum());
		
		newPoker[0].setPoker_value((byte)11);
		newPoker[1].setPoker_value((byte)12);
		newPoker[2].setPoker_value((byte)10);
		newPoker[3].setPoker_value((byte)10);
		newPoker[4].setPoker_value((byte)10);
		assertEquals(12,pokers.getTypeofNiuNum());
		
		
		
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)3);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)4);
		assertEquals(13,pokers.getTypeofNiuNum());
		
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)6);
		assertEquals(13,pokers.getTypeofNiuNum());
		
		newPoker[0].setPoker_value((byte)10);
		newPoker[1].setPoker_value((byte)11);
		newPoker[2].setPoker_value((byte)8);
		newPoker[3].setPoker_value((byte)4);
		newPoker[4].setPoker_value((byte)7);
		assertEquals(0,pokers.getTypeofNiuNum());
		for (int j = 0; j < newPoker.length; j++) {
			newPoker[j] = new Poker((byte)(j+9),(byte)3);	
		}
		pokers.setPoker(newPoker);
		newPoker[0].setPoker_value((byte)10);
		newPoker[1].setPoker_value((byte)11);
		newPoker[2].setPoker_value((byte)3);
		newPoker[3].setPoker_value((byte)7);
		for (int i = 0; i <= 9; i++) {
			newPoker[4].setPoker_value((byte)(i+1));
			assertEquals(i+1, pokers.getTypeofNiuNum());
		}
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)7);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)7);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)7);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)7);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		newPoker[0].setPoker_value((byte)7);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)1);
		assertEquals(11,pokers.getTypeofNiuNum());
		
		
		
		
		newPoker[0].setPoker_value((byte)11);
		newPoker[1].setPoker_value((byte)10);
		newPoker[2].setPoker_value((byte)10);
		newPoker[3].setPoker_value((byte)10);
		newPoker[4].setPoker_value((byte)10);
		assertEquals(12,pokers.getTypeofNiuNum());
		
		newPoker[0].setPoker_value((byte)11);
		newPoker[1].setPoker_value((byte)12);
		newPoker[2].setPoker_value((byte)10);
		newPoker[3].setPoker_value((byte)10);
		newPoker[4].setPoker_value((byte)10);
		assertEquals(12,pokers.getTypeofNiuNum());
		
		
		
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)3);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)4);
		assertEquals(13,pokers.getTypeofNiuNum());
		
		newPoker[0].setPoker_value((byte)1);
		newPoker[1].setPoker_value((byte)1);
		newPoker[2].setPoker_value((byte)1);
		newPoker[3].setPoker_value((byte)1);
		newPoker[4].setPoker_value((byte)6);
		assertEquals(13,pokers.getTypeofNiuNum());
		
		newPoker[0].setPoker_value((byte)10);
		newPoker[1].setPoker_value((byte)11);
		newPoker[2].setPoker_value((byte)8);
		newPoker[3].setPoker_value((byte)4);
		newPoker[4].setPoker_value((byte)7);
		assertEquals(0,pokers.getTypeofNiuNum());
	}

	@Test
	public void testWuXiaoCheck() {
		pokers.setPoker(new Poker((byte)3,(byte)1), 0);
		pokers.setPoker(new Poker((byte)3,(byte)3), 1);
		pokers.setPoker(new Poker((byte)3,(byte)2), 2);
		pokers.setPoker(new Poker((byte)3,(byte)4), 3);
		pokers.setPoker(new Poker((byte)7,(byte)1), 4);
		assertFalse(pokers.wuXiaoCheck());
		
		pokers.setPoker(new Poker((byte)3,(byte)1), 0);
		pokers.setPoker(new Poker((byte)3,(byte)3), 1);
		pokers.setPoker(new Poker((byte)1,(byte)2), 2);
		pokers.setPoker(new Poker((byte)1,(byte)4), 3);
		pokers.setPoker(new Poker((byte)2,(byte)1), 4);
		assertTrue(pokers.wuXiaoCheck());
		
		pokers.setPoker(new Poker((byte)3,(byte)1), 0);
		pokers.setPoker(new Poker((byte)1,(byte)3), 1);
		pokers.setPoker(new Poker((byte)1,(byte)2), 2);
		pokers.setPoker(new Poker((byte)1,(byte)4), 3);
		pokers.setPoker(new Poker((byte)2,(byte)1), 4);
		assertTrue(pokers.wuXiaoCheck());
	}

	@Test
	public void testWuHuaCheck() {
		pokers.setPoker(new Poker((byte)10,(byte)1), 0);
		pokers.setPoker(new Poker((byte)11,(byte)3), 1);
		pokers.setPoker(new Poker((byte)12,(byte)2), 2);
		pokers.setPoker(new Poker((byte)11,(byte)4), 3);
		pokers.setPoker(new Poker((byte)10,(byte)1), 4);
		assertTrue(pokers.wuHuaCheck());
		
		pokers.setPoker(new Poker((byte)10,(byte)1), 0);
		pokers.setPoker(new Poker((byte)1,(byte)3), 1);
		pokers.setPoker(new Poker((byte)12,(byte)2), 2);
		pokers.setPoker(new Poker((byte)11,(byte)4), 3);
		pokers.setPoker(new Poker((byte)10,(byte)1), 4);
		assertFalse(pokers.wuHuaCheck());
	}

	@Test
	public void testThreeOfFive_Poker() {
		int[] threeInt = new int[3];
		pokers.setPoker(new Poker((byte)3,(byte)1), 0);
		pokers.setPoker(new Poker((byte)7,(byte)3), 1);
		pokers.setPoker(new Poker((byte)11,(byte)2), 2);
		pokers.setPoker(new Poker((byte)8,(byte)4), 3);
		pokers.setPoker(new Poker((byte)9,(byte)1), 4);
		threeInt = pokers.threeOfFive_Poker();
		assertEquals(0, threeInt[0]);
		assertEquals(1,threeInt[1]);
		assertEquals(2,threeInt[2]);
		
		pokers.setPoker(new Poker((byte)3,(byte)1), 0);
		pokers.setPoker(new Poker((byte)7,(byte)3), 1);
		pokers.setPoker(new Poker((byte)7,(byte)2), 2);
		pokers.setPoker(new Poker((byte)7,(byte)4), 3);
		pokers.setPoker(new Poker((byte)9,(byte)1), 4);
		threeInt = pokers.threeOfFive_Poker();
		assertEquals(0, threeInt[0]);
		assertEquals(0,threeInt[1]);
		assertEquals(0,threeInt[2]);
	}

	@Test
	public void testTwoOfFive_Poker() {
		int[] twoInt = new int[2];
		twoInt = pokers.twoOfFive_Poker(0, 2, 4);
		assertEquals(1, twoInt[0]);
		assertEquals(3, twoInt[1]);
	}

	@Test
	public void testSiZhaCheck() {

	}

	@Test
	public void testIsEqualFour() {

	}

	@Test
	public void testGetMaxPoker() {
		pokers.setPoker(new Poker((byte)10,(byte)2),0);
		pokers.setPoker(new Poker((byte)8,(byte)2),1);
		pokers.setPoker(new Poker((byte)4,(byte)2),2);
		pokers.setPoker(new Poker((byte)9,(byte)2),3);
		pokers.setPoker(new Poker((byte)11,(byte)2),4);
		assertEquals(11,pokers.GetMaxPoker().getPoker_value());
		
		pokers.setPoker(new Poker((byte)10,(byte)2),0);
		pokers.setPoker(new Poker((byte)8,(byte)2),1);
		pokers.setPoker(new Poker((byte)11,(byte)2),2);
		pokers.setPoker(new Poker((byte)9,(byte)2),3);
		pokers.setPoker(new Poker((byte)11,(byte)3),4);
		assertEquals(pokers.getPoker()[4],pokers.GetMaxPoker());
	}

	@Test
	public void testCompareNiutype() {
		byte a = 3;
		byte b = 4;
		assertEquals(-1, pokers.CompareNiutype(a,b));
		
		a = 4;
		b = 4;
		assertEquals(0, pokers.CompareNiutype(a, b));
		
		a = 12;
		b = 4;
		assertEquals(1, pokers.CompareNiutype(a, b));
	}

	@Test
	public void testComparePokers() {
		PokerSuit main = new PokerSuit((byte)1, (byte)13);
		DNPokers examples_a = new DNPokers();
		DNPokers examples_b = new DNPokers();

		examples_a = main.DNDeal(1);
		examples_b = main.DNDeal(1);
		examples_a.ComparePokers(examples_b);
		examples_b.ComparePokers(examples_a);
		
		examples_a = main.DNDeal(9);
		examples_b = main.DNDeal(3);
		examples_a.ComparePokers(examples_b);
		examples_b.ComparePokers(examples_a);
		
		examples_a = main.DNDeal(2);
		examples_b = main.DNDeal(5);
		examples_a.ComparePokers(examples_b);
		examples_b.ComparePokers(examples_a);	
	}

}
