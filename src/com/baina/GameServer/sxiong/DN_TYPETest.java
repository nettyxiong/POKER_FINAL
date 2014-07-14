package com.baina.GameServer.sxiong;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DN_TYPETest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDNType() {
		assertEquals("error", DN_TYPE.GetDNType((byte) 14));
		assertEquals("Î´¶¨Òå", DN_TYPE.GetDNType((byte) -2));
		assertEquals("Ã»Å£", DN_TYPE.GetDNType((byte) 0));
		assertEquals("Å£¶¡", DN_TYPE.GetDNType((byte) 1));
		assertEquals("Å£¶þ", DN_TYPE.GetDNType((byte) 2));
		assertEquals("Å£Èý", DN_TYPE.GetDNType((byte) 3));
		assertEquals("Å£ËÄ", DN_TYPE.GetDNType((byte) 4));
		assertEquals("Å£Îå", DN_TYPE.GetDNType((byte) 5));
		assertEquals("Å£Áù", DN_TYPE.GetDNType((byte) 6));
		assertEquals("Å£Æß", DN_TYPE.GetDNType((byte) 7));
		assertEquals("Å£°Ë", DN_TYPE.GetDNType((byte) 8));
		assertEquals("Å£¾Å", DN_TYPE.GetDNType((byte) 9));
		assertEquals("Å£Å£", DN_TYPE.GetDNType((byte) 10));
		assertEquals("ËÄÕ¨", DN_TYPE.GetDNType((byte) 11));
		assertEquals("Îå»¨Å£", DN_TYPE.GetDNType((byte) 12));
		assertEquals("ÎåÐ¡Å£", DN_TYPE.GetDNType((byte) 13));
	}

	@Test
	public void testGetColorType() {
		assertEquals("error", DN_TYPE.GetColorType((byte) 8));
		assertEquals("·½¿é", DN_TYPE.GetColorType((byte) 1));
		assertEquals("Ó£ÌÒ", DN_TYPE.GetColorType((byte) 2));
		assertEquals("ÌÒ»¨", DN_TYPE.GetColorType((byte) 3));
		assertEquals("ºÚÌÒ", DN_TYPE.GetColorType((byte) 4));
	}

}
