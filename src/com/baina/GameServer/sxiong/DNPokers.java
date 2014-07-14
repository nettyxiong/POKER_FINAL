package com.baina.GameServer.sxiong;

public class DNPokers {
	public static final int NUM = 5;// һ���Ƶ�����
	private Poker[] poker;
	private byte dn_type;

	public byte getDn_type() {
		return dn_type;
	}

	public void setDn_type(byte dn_type) {
		this.dn_type = dn_type;
	}

	public Poker[] getPoker() {
		return poker;
	}

	public void setPoker(Poker[] poker) {
		this.poker = poker;
	}

	public void setPoker(Poker apoker, int index) {
		poker[index] = apoker;
	}
	
	public DNPokers() {
		poker = new Poker[NUM];
		dn_type = DN_TYPE.UNDEFINED;
	}

	/**
	 * 
	 * @return the Niu_type of poker
	 */
	public byte getTypeofNiuNum() {
		boolean hasNiu = false;
		boolean siZha = false;
		boolean wuXiao = false;
		boolean wuHua = false;

		int[] threeInt = new int[3];// ��������ֵ�ĺ�Ϊ10�����������е��±�
		threeInt = threeOfFive_Poker();// ��ȡ�����±�
		if (threeInt[0] == threeInt[1] && threeInt[1] == threeInt[2]) {
			hasNiu = false;
		}
		else {
			hasNiu = true;
		}
		if (hasNiu == false)
			dn_type = DN_TYPE.MEI_NIU;// ûţ
		else {// ��ţ
			int[] twoInt = new int[2];// ���������������������е��±�
			twoInt = twoOfFive_Poker(threeInt[0], threeInt[1], threeInt[2]);// ��ȡ���������±�
			dn_type = (byte) ((byte) (poker[twoInt[0]].getReal_value() + poker[twoInt[1]]
					.getReal_value()) % 10);// ţһ~~ţ��
			if (dn_type == 0)
				dn_type = DN_TYPE.NIU_NIU;// ţţ
		}

		siZha = siZhaCheck();
		wuHua = wuHuaCheck();
		wuXiao = wuXiaoCheck();

		if (siZha == true)
			dn_type = DN_TYPE.SI_ZHA;
		if (wuHua == true)
			dn_type = DN_TYPE.WU_HUA_NIU;
		if (wuXiao == true)
			dn_type = DN_TYPE.WU_XIAO_NIU;
		return dn_type;
	}

	/**
	 * 
	 * @return if wuXiao return true;
	 */
	public boolean wuXiaoCheck() {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += poker[i].getReal_value();
		}
		if (sum <= 10)
			return true;
		else {
			return false;
		}
	}
	/**
	 * 
	 * @return if wuHua return true;
	 */
	public boolean wuHuaCheck() {
		for (int i = 0; i < 5; i++)
			if (poker[i].getReal_value() != 10) {
				return false;
			}
		return true;
	}

	/**
	 * 
	 * @return find three of five
	 */
	public int[] threeOfFive_Poker()// ��ţ���������Ƶ��±꣬ûţ���������±�Ϊ0��ֵ
	{
		int[] threeInt = new int[3];// ��������ֵ�ĺ�Ϊ10�����������е��±�
		for (int i = 0; i < NUM - 2; i++)
			for (int j = i + 1; j < NUM - 1; j++)
				for (int k = j + 1; k < NUM; k++)
					if ((poker[i].getReal_value() + poker[j].getReal_value() + poker[k]
							.getReal_value()) % 10 == 0) {
						threeInt[0] = i;
						threeInt[1] = j;
						threeInt[2] = k;
						i = j = k = NUM;//����ѭ��
					}
		return threeInt;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return find two of five except a,b,c
	 */
	public int[] twoOfFive_Poker(int a, int b, int c) {
		int[] twoInt = new int[2];// ���������������������е��±�
		boolean flagFirstOrSecond = false;
		for (int index = 0; index < NUM; index++) {
			if (index != a && index != b && index != c) {
				if (!flagFirstOrSecond) {
					twoInt[0] = index;
					flagFirstOrSecond = true;
				} else {
					twoInt[1] = index;
				}
			}
		}
		return twoInt;
	}
	
	/**
	 * 
	 * @return if siZha then return true;
	 */
	public boolean siZhaCheck() {
		boolean siZha = false;
		if (isEqualFour(poker[0].getPoker_value(), poker[1].getPoker_value(),
				poker[2].getPoker_value(), poker[3].getPoker_value()) == true)
			siZha = true;
		else if (isEqualFour(poker[0].getPoker_value(),
				poker[1].getPoker_value(), poker[2].getPoker_value(),
				poker[4].getPoker_value()) == true)
			siZha = true;
		else if (isEqualFour(poker[0].getPoker_value(),
				poker[1].getPoker_value(), poker[3].getPoker_value(),
				poker[4].getPoker_value()) == true)
			siZha = true;
		else if (isEqualFour(poker[0].getPoker_value(),
				poker[2].getPoker_value(), poker[3].getPoker_value(),
				poker[4].getPoker_value()) == true)
			siZha = true;
		else if (isEqualFour(poker[1].getPoker_value(),
				poker[2].getPoker_value(), poker[3].getPoker_value(),
				poker[4].getPoker_value()) == true)
			siZha = true;
		else
			siZha = false;
		return siZha;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return true if a=b=c=d
	 */
	boolean isEqualFour(byte a, byte b, byte c, byte d) {
		if (a == b && a == c && c == d)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @return the max poker of five pokers;
	 */
	public Poker GetMaxPoker()// Ѱ��5������������һ����
	{
		Poker max_poker = poker[0];
		Poker current_poker = null;

		for (int i = 1; i < NUM; i++) {
			current_poker = poker[i];
			if ((max_poker.getPoker_value() < current_poker.getPoker_value())
					|| (max_poker.getPoker_value() == current_poker
							.getPoker_value() && max_poker.getPoker_color() < current_poker
							.getPoker_color())) {
				max_poker = poker[i];
			}
		}
		return max_poker;
	}

	/**
	 * 
	 * @param a_niu_type
	 * @param b_niu_type
	 * @return -1 a < b; 0 a==b ; 1 a > b
	 */
	public int CompareNiutype(byte a_niu_type, byte b_niu_type)// ����ţ����Ƚ�
	{
		// �Ƚ�ţ��
		if (a_niu_type < b_niu_type) {
			return -1;
		} else if (a_niu_type == b_niu_type) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * 
	 * @param poker_b
	 * @return true this < b;false this > b;
	 */
	boolean ComparePokers(DNPokers poker_b) {// �ж�poker_a�Ƿ��poker_bС

		boolean a_lose = false;

		// �Ƚ�ţ�ͣ����ţ����ͬ���Ƚ��������ƴ�С��ֱ����ɫ
		int ret = CompareNiutype(this.getTypeofNiuNum(),
				poker_b.getTypeofNiuNum());
		if (ret == 0) {
			// ��5�������ҵ�������,�ж�.��С���ұ�
			if (this.GetMaxPoker().CompareSinglePoker(poker_b.GetMaxPoker()) == false) {
				a_lose = true;// a lose
			} else {
				a_lose = false;// a win
			}
		} else if (ret == -1) {
			a_lose = true;// a lose
		} else {
			a_lose = false;// a win
		}
		return a_lose;
	}
}
