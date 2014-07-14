package com.baina.GameServer.sxiong;

public class DN_TYPE {
	public static byte UNDEFINED = -2;//未定义
	public static byte MEI_NIU = 0; // 没牛
	public static byte NIU_DING = 1; // 牛丁
	public static byte NIU_ER = 2; // 牛二
	public static byte NIU_SAN = 3; // 牛三
	public static byte NIU_SI = 4; // 牛四
	public static byte NIU_WU = 5; // 牛五
	public static byte NIU_LIU = 6; // 牛六
	public static byte NIU_QI = 7; // 牛七
	public static byte NIU_BA = 8; // 牛八
	public static byte NIU_JIU = 9; // 牛九
	public static byte NIU_NIU = 10; // 牛牛

	public static byte SI_ZHA = 11; // 四炸
	public static byte WU_HUA_NIU = 12; // 五花牛
	public static byte WU_XIAO_NIU = 13; // 五小牛

	public static byte FangKuai = 1;
	public static byte YingTao = 2;
	public static byte TaoHua = 3;
	public static byte HeiTao = 4;

	public static byte DN_TYPE_COUNT;// place holder.

	public static String GetDNType(byte type2) {
		String type = "error";
		switch (type2) {
		case -2:
			type = "未定义";
			break;
		case 0:
			type = "没牛";
			break;
		case 1:
			type = "牛丁";
			break;
		case 2:
			type = "牛二";
			break;
		case 3:
			type = "牛三";
			break;
		case 4:
			type = "牛四";
			break;
		case 5:
			type = "牛五";
			break;
		case 6:
			type = "牛六";
			break;
		case 7:
			type = "牛七";
			break;
		case 8:
			type = "牛八";
			break;
		case 9:
			type = "牛九";
			break;
		case 10:
			type = "牛牛";
			break;
		case 11:
			type = "四炸";
			break;
		case 12:
			type = "五花牛";
			break;
		case 13:
			type = "五小牛";
			break;
		default:
			type = "error";
			break;
		}
		return type;
	}

	public static String GetColorType(byte tType) {
		String type = "";
		switch (tType) {
		case 1:
			type = "方块";
			break;
		case 2:
			type = "樱桃";
			break;
		case 3:
			type = "桃花";
			break;
		case 4:
			type = "黑桃";
			break;
		default:
			type = "error";
			break;
		}
		return type;
	}
}
