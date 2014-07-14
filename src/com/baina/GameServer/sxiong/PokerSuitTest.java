package com.baina.GameServer.sxiong;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PokerSuitTest {
	PokerSuit pokerSuit = null;
	@Before
	public void setUp() throws Exception {
		pokerSuit = new PokerSuit(PokerSuit.MIN_DNPOKER_VALUE, PokerSuit.MAX_DNPOKER_VALUE);
	}

	@Test
	public void testPokerSuit() {
		pokerSuit = new PokerSuit((byte)15, (byte)5);
		pokerSuit = new PokerSuit((byte)5, (byte)15);
		pokerSuit = new PokerSuit((byte)15, (byte)15);
	}

	@Test
	public void testInitPokers() {
		pokerSuit.initPokers((byte)15, (byte)13);
		pokerSuit.initPokers((byte)13, (byte)13);
		pokerSuit.initPokers((byte)1, (byte)13);
		assertEquals(52, pokerSuit.getPokers().length);
		assertNotNull(pokerSuit.getPokers()[0]);
		assertNotNull(pokerSuit.getPokers()[4]);
		assertNotNull(pokerSuit.getPokers()[51]);
	}

	@Test
	public void testShuffle() {
		assertEquals(true, pokerSuit.shuffle((short)30));
	}

	@Test
	public void testDNDeal() {
		pokerSuit.shuffle((short)30);
		for (int i = 0; i < 10; i++) {
			assertNotNull(pokerSuit.DNDeal());
		}	
		assertEquals(50, pokerSuit.getPoker_Position());
		assertNull(pokerSuit.DNDeal());
	}

	@Test
	public void testDNDealInt() {
		for (int i = 0; i < 10; i++) {
			pokerSuit.shuffle((short)30);
			pokerSuit.setPoker_Position((byte)46);
			pokerSuit.DNDeal(0);
			pokerSuit.setPoker_Position((byte)46);
			pokerSuit.DNDeal(5);
			pokerSuit.setPoker_Position((byte)46);
			pokerSuit.DNDeal(10);
			pokerSuit.setPoker_Position((byte)46);
			pokerSuit.DNDeal(11);
			pokerSuit.setPoker_Position((byte)46);
			pokerSuit.DNDeal(14);
		}
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.setPokers(new Poker((byte)1, (byte)1),46);
		pokerSuit.setPokers(new Poker((byte)1, (byte)2),47);
		pokerSuit.setPokers(new Poker((byte)1, (byte)3),48);
		pokerSuit.setPokers(new Poker((byte)1, (byte)1),49);
		pokerSuit.setPokers(new Poker((byte)4, (byte)1),50);
		pokerSuit.setPokers(new Poker((byte)4, (byte)1),51);
		pokerSuit.DNDeal(11);
		
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.setPokers(new Poker((byte)11, (byte)1),46);
		pokerSuit.setPokers(new Poker((byte)11, (byte)2),47);
		pokerSuit.setPokers(new Poker((byte)11, (byte)3),48);
		pokerSuit.setPokers(new Poker((byte)11, (byte)4),49);
		pokerSuit.setPokers(new Poker((byte)12, (byte)1),50);
		pokerSuit.setPokers(new Poker((byte)13, (byte)1),51);
		pokerSuit.DNDeal(11);
		
		pokerSuit.shuffle((short)30);
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.setPokers(new Poker((byte)11, (byte)1),46);
		pokerSuit.setPokers(new Poker((byte)11, (byte)2),47);
		pokerSuit.setPokers(new Poker((byte)11, (byte)3),48);
		pokerSuit.setPokers(new Poker((byte)11, (byte)4),49);
		pokerSuit.setPokers(new Poker((byte)8, (byte)1),50);
		pokerSuit.setPokers(new Poker((byte)9, (byte)1),51);
		pokerSuit.DNDeal(11);
		
		for (int i = 0; i < 14; i++) {
			pokerSuit.shuffle((short)30);
			for (int j = 0; j < 1000; j++) {
				 pokerSuit.DNDeal(i);
			}
		}
	}

	@Test
	public void testExchange_TowPoker() {
		Poker aPoker = new Poker((byte)3,(byte)3);
		Poker bPoker = new Poker((byte)1,(byte)4);
		pokerSuit.exchange_TowPoker(aPoker, bPoker);
		assertEquals(1, aPoker.getPoker_value());
		assertEquals(4, aPoker.getPoker_color());
		assertEquals(3, bPoker.getPoker_value());
		assertEquals(3, bPoker.getPoker_color());		
	}

	@Test
	public void testMeiNiuCheck() {
//		fail("Not yet implemented");
	}

	@Test
	public void testHuiSuabcde() {
		DNPokers pokers = new DNPokers();
		
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()] = new Poker((byte)4, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+1] = new Poker((byte)6, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+2] = new Poker((byte)6, (byte)1);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+3] = new Poker((byte)5, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+4] = new Poker((byte)4, (byte)1);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+5] = new Poker((byte)4, (byte)3);
		pokerSuit.HuiSuabcde(pokers.getPoker());
		
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()] = new Poker((byte)3, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+1] = new Poker((byte)4, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+2] = new Poker((byte)2, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+3] = new Poker((byte)5, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+4] = new Poker((byte)4, (byte)1);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+5] = new Poker((byte)4, (byte)3);
		pokerSuit.HuiSuabcde(pokers.getPoker());
		
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()] = new Poker((byte)3, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+1] = new Poker((byte)3, (byte)1);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+2] = new Poker((byte)2, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+3] = new Poker((byte)5, (byte)3);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+4] = new Poker((byte)4, (byte)3);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+5] = new Poker((byte)4, (byte)2);
		pokerSuit.HuiSuabcde(pokers.getPoker());
		
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()] = new Poker((byte)3, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+1] = new Poker((byte)3, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+2] = new Poker((byte)1, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+3] = new Poker((byte)1, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+4] = new Poker((byte)2, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+5] = new Poker((byte)4, (byte)2);
		pokerSuit.HuiSuabcde(pokers.getPoker());
		
		pokerSuit.setPoker_Position((byte)46);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()] = new Poker((byte)3, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+1] = new Poker((byte)4, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+2] = new Poker((byte)1, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+3] = new Poker((byte)1, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+4] = new Poker((byte)10, (byte)2);
		pokerSuit.getPokers()[pokerSuit.getPoker_Position()+5] = new Poker((byte)11, (byte)2);
		pokerSuit.HuiSuabcde(pokers.getPoker());
		
		pokerSuit.shuffle((short)30);
		for (int i = 0; i < 100; i++) {
			pokerSuit.HuiSuabcde(pokers.getPoker());
		}
	}

	@Test
	public void testFirstLessSix() {
//		fail("Not yet implemented");
	}

	@Test
	public void testCount_list() {
//		fail("Not yet implemented");
	}

	@Test
	public void testHuiSuTwo() {
//		fail("Not yet implemented");
	}

	@Test
	public void testHuiSuThree() {
		pokerSuit.shuffle((short)30);
		for (int i = 0; i < 50; i++) {
			pokerSuit.HuiSuThree(i, i+1, i+2);
		}
	}

}
