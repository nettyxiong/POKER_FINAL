package com.baina.GameServer.sxiong;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PokerTest {
	Poker poker = null;
	@Before
	public void setUp() throws Exception {
		poker = new Poker((byte)0,(byte)0);
	}

	@Test
	public void testGetPoker_value() {
		assertEquals(0,poker.getPoker_value());
	}

	@Test
	public void testSetPoker_value() {
		poker.setPoker_value((byte)4);
		assertEquals(4,poker.getPoker_value());
	}

	@Test
	public void testGetPoker_color() {
		assertEquals(0, poker.getPoker_color());
	}

	@Test
	public void testSetPoker_color() {
		poker.setPoker_color((byte)1);
		assertEquals(1, poker.getPoker_color());
	}

	@Test
	public void testGetReal_value() {
		poker.setPoker_value((byte)13);
		assertEquals(10, poker.getReal_value());
		poker.setPoker_value((byte)8);
		assertEquals(8, poker.getReal_value());
	}

	@Test
	public void testPoker() {
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
		
		poker = new Poker((byte)0,(byte)3);
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
		
		poker = new Poker((byte)0,(byte)6);
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
		
		poker = new Poker((byte)12,(byte)0);
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
		
		poker = new Poker((byte)12,(byte)3);
		assertNotNull(poker);
		assertEquals(12, poker.getPoker_value());
		assertEquals(3, poker.getPoker_color());
		
		poker = new Poker((byte)12,(byte)6);
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
		
		poker = new Poker((byte)16,(byte)0);
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
		
		poker = new Poker((byte)16,(byte)3);
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
		
		poker = new Poker((byte)16,(byte)6);
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
	}

	@Test
	public void testReset() {
		poker = new Poker((byte)12,(byte)3);
		poker.Reset();
		assertNotNull(poker);
		assertEquals(0, poker.getPoker_value());
		assertEquals(0, poker.getPoker_color());
	}

	@Test
	public void testCompareSinglePoker() {
		
		Poker aPoker = new Poker((byte)12,(byte)3);
		Poker bPoker = new Poker((byte)11,(byte)3);
		assertTrue(aPoker.CompareSinglePoker(bPoker));
		
		aPoker = new Poker((byte)11,(byte)3);
		bPoker = new Poker((byte)12,(byte)3);
		assertFalse(aPoker.CompareSinglePoker(bPoker));
		
		aPoker = new Poker((byte)12,(byte)1);
		bPoker = new Poker((byte)12,(byte)3);
		assertFalse(aPoker.CompareSinglePoker(bPoker));
		
		aPoker = new Poker((byte)12,(byte)3);
		bPoker = new Poker((byte)12,(byte)1);
		assertTrue(aPoker.CompareSinglePoker(bPoker));
	}

}
