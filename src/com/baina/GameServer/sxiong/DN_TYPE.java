package com.baina.GameServer.sxiong;

public class DN_TYPE {
	public static byte UNDEFINED = -2;//δ����
	public static byte MEI_NIU = 0; // ûţ
	public static byte NIU_DING = 1; // ţ��
	public static byte NIU_ER = 2; // ţ��
	public static byte NIU_SAN = 3; // ţ��
	public static byte NIU_SI = 4; // ţ��
	public static byte NIU_WU = 5; // ţ��
	public static byte NIU_LIU = 6; // ţ��
	public static byte NIU_QI = 7; // ţ��
	public static byte NIU_BA = 8; // ţ��
	public static byte NIU_JIU = 9; // ţ��
	public static byte NIU_NIU = 10; // ţţ

	public static byte SI_ZHA = 11; // ��ը
	public static byte WU_HUA_NIU = 12; // �廨ţ
	public static byte WU_XIAO_NIU = 13; // ��Сţ

	public static byte FangKuai = 1;
	public static byte YingTao = 2;
	public static byte TaoHua = 3;
	public static byte HeiTao = 4;

	public static byte DN_TYPE_COUNT;// place holder.

	public static String GetDNType(byte type2) {
		String type = "error";
		switch (type2) {
		case -2:
			type = "δ����";
			break;
		case 0:
			type = "ûţ";
			break;
		case 1:
			type = "ţ��";
			break;
		case 2:
			type = "ţ��";
			break;
		case 3:
			type = "ţ��";
			break;
		case 4:
			type = "ţ��";
			break;
		case 5:
			type = "ţ��";
			break;
		case 6:
			type = "ţ��";
			break;
		case 7:
			type = "ţ��";
			break;
		case 8:
			type = "ţ��";
			break;
		case 9:
			type = "ţ��";
			break;
		case 10:
			type = "ţţ";
			break;
		case 11:
			type = "��ը";
			break;
		case 12:
			type = "�廨ţ";
			break;
		case 13:
			type = "��Сţ";
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
			type = "����";
			break;
		case 2:
			type = "ӣ��";
			break;
		case 3:
			type = "�һ�";
			break;
		case 4:
			type = "����";
			break;
		default:
			type = "error";
			break;
		}
		return type;
	}
}
