package com.baina.GameServer.sxiong;

public class Poker {
	private byte poker_value = 0;// �Ƶ���ʾֵ
	private byte poker_color = 0;// �Ƶ���ʾ��ɫ
	private byte real_value = 0;// �Ƶļ���ֵ�����Ϊ10��

	public byte getPoker_value() {
		return poker_value;
	}

	public void setPoker_value(byte poker_value) {
		this.poker_value = poker_value;
	}

	public byte getPoker_color() {
		return poker_color;
	}

	public void setPoker_color(byte poker_color) {
		this.poker_color = poker_color;
	}

	public byte getReal_value() {
		if (poker_value > 10) {
			this.real_value = 10;
		} else {
			real_value = poker_value;
		}
		return real_value;
	}

	public Poker(byte i, byte j) {// ���캯��
		if (i > PokerSuit.MAX_DNPOKER_VALUE || i < PokerSuit.MIN_DNPOKER_VALUE
				|| j < PokerSuit.MIN_DNPOKER_COLOR_VALUE
				|| j > PokerSuit.MAX_DNPOKER_COLOR_VALUE)// ������Ҫ��
		{
			Reset();// ����Ϊ0
		} else {// ����Ҫ��
			poker_value = i;
			poker_color = j;
		}
	}

	public void Reset() {
		poker_value = 0;
		poker_color = 0;
	}

	public boolean CompareSinglePoker(Poker poker_b)// �Ƚϵ����ƵĴ�С
	{
		if (this.poker_value == poker_b.poker_value) {
			return this.poker_color > poker_b.poker_color;
		} else {
			return this.poker_value > poker_b.poker_value;
		}
	}

}
