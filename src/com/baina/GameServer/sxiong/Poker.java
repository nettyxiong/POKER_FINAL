package com.baina.GameServer.sxiong;

public class Poker {
	private byte poker_value = 0;// 牌的显示值
	private byte poker_color = 0;// 牌的显示花色
	private byte real_value = 0;// 牌的计算值（最大为10）

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

	public Poker(byte i, byte j) {// 构造函数
		if (i > PokerSuit.MAX_DNPOKER_VALUE || i < PokerSuit.MIN_DNPOKER_VALUE
				|| j < PokerSuit.MIN_DNPOKER_COLOR_VALUE
				|| j > PokerSuit.MAX_DNPOKER_COLOR_VALUE)// 不符合要求
		{
			Reset();// 都置为0
		} else {// 符合要求
			poker_value = i;
			poker_color = j;
		}
	}

	public void Reset() {
		poker_value = 0;
		poker_color = 0;
	}

	public boolean CompareSinglePoker(Poker poker_b)// 比较单张牌的大小
	{
		if (this.poker_value == poker_b.poker_value) {
			return this.poker_color > poker_b.poker_color;
		} else {
			return this.poker_value > poker_b.poker_value;
		}
	}

}
