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
		assertEquals("δ����", DN_TYPE.GetDNType((byte) -2));
		assertEquals("ûţ", DN_TYPE.GetDNType((byte) 0));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 1));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 2));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 3));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 4));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 5));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 6));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 7));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 8));
		assertEquals("ţ��", DN_TYPE.GetDNType((byte) 9));
		assertEquals("ţţ", DN_TYPE.GetDNType((byte) 10));
		assertEquals("��ը", DN_TYPE.GetDNType((byte) 11));
		assertEquals("�廨ţ", DN_TYPE.GetDNType((byte) 12));
		assertEquals("��Сţ", DN_TYPE.GetDNType((byte) 13));
	}

	@Test
	public void testGetColorType() {
		assertEquals("error", DN_TYPE.GetColorType((byte) 8));
		assertEquals("����", DN_TYPE.GetColorType((byte) 1));
		assertEquals("ӣ��", DN_TYPE.GetColorType((byte) 2));
		assertEquals("�һ�", DN_TYPE.GetColorType((byte) 3));
		assertEquals("����", DN_TYPE.GetColorType((byte) 4));
	}

}
