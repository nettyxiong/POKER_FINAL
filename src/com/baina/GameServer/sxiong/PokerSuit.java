package com.baina.GameServer.sxiong;

import java.util.Random;

public class PokerSuit {
	public static final int MAX_DNPOKER_COUNT = 52; // 去掉大小王 Joker
	public static final byte MIN_DNPOKER_VALUE = 1; // A
	public static final byte MAX_DNPOKER_VALUE = 13; // K
	public static final byte DNPOKER_COLOR_COUNT = 4;
	public static final byte MIN_DNPOKER_COLOR_VALUE = 1;
	public static final byte MAX_DNPOKER_COLOR_VALUE = 4;
	public static final short XiPai_CiShu = 30;// 洗牌次数

	private Poker pokers[] = new Poker[MAX_DNPOKER_COUNT];
	private byte poker_Position = 0;

	private int[] indexOfThree = new int[3];
	private int[] indexOfTwo = new int[2];

	public PokerSuit(byte minPoker, byte maxPoker) {
		initPokers(MIN_DNPOKER_VALUE, MAX_DNPOKER_VALUE);
		shuffle(XiPai_CiShu);
	}

	public void initPokers(byte minPoker, byte maxPoker)// 初始化牌
	{
		assert (minPoker <= maxPoker);

		int poker_count_color = maxPoker - minPoker + 1;
		int total_poker_count = DNPOKER_COLOR_COUNT * poker_count_color;

		for (int i = 0; i < total_poker_count; ++i) {
			byte byValue = (byte) ((i % poker_count_color) + minPoker);
			byte byColor = (byte) ((i / poker_count_color) + 1);
			pokers[i] = new Poker(byValue, byColor);
		}
	}

	public boolean shuffle(short iTimes)// 随机洗牌
	{
		for (int iT = 0; iT < iTimes; ++iT) {
			int iValue = 0;
			Poker median = null;
			for (int index = 0; index < MAX_DNPOKER_COUNT; index++) {
				Random random = new Random();

				iValue = index + random.nextInt(MAX_DNPOKER_COUNT - index);
				median = pokers[index];
				pokers[index] = pokers[iValue];
				pokers[iValue] = median;
			}
		}
		poker_Position = 0;
		return true;
	}

	public DNPokers DNDeal()// 随机发牌
	{
		DNPokers dnPokers = new DNPokers();
		if (poker_Position > MAX_DNPOKER_COUNT - 5)
			return null;

		for (int i = 0; i < dnPokers.getPoker().length; i++) {
			dnPokers.setPoker(pokers[poker_Position++], i);
		}
		return dnPokers;
	}

	public DNPokers DNDeal(int niu_type)// 特殊牌型发牌(没牛~小五)都可以
	{
		DNPokers dnPokers = new DNPokers();
		int poker_Num_Left = MAX_DNPOKER_COUNT - poker_Position;
		if (poker_Position > MAX_DNPOKER_COUNT - 5)
			return null;
		else {
			if (niu_type == 0) {
				for (int i = poker_Position; i < poker_Num_Left - 5; i++) {
					for (int j = i + 1; j < poker_Num_Left - 4; j++) {
						for (int j2 = j + 1; j2 < poker_Num_Left - 3; j2++) {
							for (int k = j2 + 1; k < poker_Num_Left - 2; k++) {
								for (int k2 = k + 1; k2 < poker_Num_Left - 1; k2++) {
									dnPokers.setPoker(pokers[i], 0);
									dnPokers.setPoker(pokers[j], 1);
									dnPokers.setPoker(pokers[j2], 2);
									dnPokers.setPoker(pokers[k], 3);
									dnPokers.setPoker(pokers[k2], 4);
									if (MeiNiuCheck(dnPokers.getPoker()) == true) {
										for (int l = 0; l < dnPokers.getPoker().length; l++) {
											exchange_TowPoker(
													pokers[poker_Position++],
													dnPokers.getPoker()[l]);
										}
										poker_Position -= DNPokers.NUM;
										for (int l = 0; l < dnPokers.getPoker().length; l++) {
											dnPokers.setPoker(
													pokers[poker_Position++], l);
										}
										return dnPokers;
									}
								}
							}
						}
					}
				}
				return null;
			} else if (niu_type >= 1 && niu_type <= 10) {
				if (HuiSuThree(poker_Position, poker_Position + 1,
						poker_Position + 2) == true) {
					exchange_TowPoker(pokers[poker_Position++],
							pokers[indexOfThree[0]]);
					exchange_TowPoker(pokers[poker_Position++],
							pokers[indexOfThree[1]]);
					exchange_TowPoker(pokers[poker_Position++],
							pokers[indexOfThree[2]]);
					poker_Position -= 3;
					dnPokers.getPoker()[0] = pokers[poker_Position++];
					dnPokers.getPoker()[1] = pokers[poker_Position++];
					dnPokers.getPoker()[2] = pokers[poker_Position++];

					if (HuiSuTwo(poker_Position, poker_Position + 1, niu_type) == true) {
						exchange_TowPoker(pokers[poker_Position++],
								pokers[indexOfTwo[0]]);
						exchange_TowPoker(pokers[poker_Position++],
								pokers[indexOfTwo[1]]);
						poker_Position -= 2;
						dnPokers.getPoker()[3] = pokers[poker_Position++];
						dnPokers.getPoker()[4] = pokers[poker_Position++];
						return dnPokers;
					} else {
						poker_Position -= 3;
						return null;
					}
				} else
					return null;
			} else if (niu_type == 11) {
				int k = 0;
				int jj = 0;
				for (jj = 1; jj < 14; jj++) {
					if (count_list(jj) == (byte) 4) {

						k = jj;
						break;
					}
				}
				if (jj >= 14) {
					return null;
				} else {
					for (int i = poker_Position, numk = 0; i < MAX_DNPOKER_COUNT; i++) {
						if (k == pokers[i].getPoker_value()) {
							exchange_TowPoker(pokers[poker_Position], pokers[i]);
							dnPokers.getPoker()[numk++] = pokers[poker_Position++];
						}
					}

					if (k < 10) {
						for (int i = poker_Position; i < MAX_DNPOKER_COUNT; i++) {
							if (pokers[i].getPoker_value() != k
									&& (4 * k + pokers[i].getPoker_value()) > 10) {
								exchange_TowPoker(pokers[poker_Position],
										pokers[i]);
								dnPokers.getPoker()[4] = pokers[poker_Position++];
								return dnPokers;
							}
						}
						poker_Position -= 4;
						return null;
					} else {
						for (int i = poker_Position; i < poker_Num_Left; i++) {
							if (pokers[i].getPoker_value() != k
									&& (4 * k + pokers[i].getPoker_value()) > 10
									&& pokers[i].getPoker_value() < 10) {
								exchange_TowPoker(pokers[poker_Position],
										pokers[i]);
								dnPokers.getPoker()[4] = pokers[poker_Position++];
								return dnPokers;
							}
						}
						poker_Position -= 4;
						return null;
					}
				}
			} else if (niu_type == 12) {
				byte index = 0;
				for (int i = poker_Position; i < MAX_DNPOKER_COUNT; i++) {
					if (pokers[i].getReal_value() == 10) {
						exchange_TowPoker(pokers[poker_Position], pokers[i]);
						dnPokers.getPoker()[index++] = pokers[poker_Position++];
						if (index == 5) {
							break;
						}
					}
				}
				if (index == 5) {
					return dnPokers;
				} else {
					poker_Position = (byte) (poker_Position - index);
					return null;
				}
			} else if (niu_type == 13) {
				if (HuiSuabcde(dnPokers.getPoker()) == true) {
					for (int i = 0; i < dnPokers.getPoker().length; i++) {
						exchange_TowPoker(pokers[poker_Position++],
								dnPokers.getPoker()[i]);
					}
					poker_Position -= dnPokers.getPoker().length;
					for (int i = 0; i < dnPokers.getPoker().length; i++) {
						dnPokers.setPoker(pokers[poker_Position++], i);
					}
					return dnPokers;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
	}

	public void exchange_TowPoker(Poker poker_a, Poker poker_b) {
		Poker poker_tempPoker = null;
		poker_tempPoker = poker_a;
		poker_a = poker_b;
		poker_b = poker_tempPoker;
	}

	public boolean MeiNiuCheck(Poker[] poker) {
		for (int i = 0; i < 3; i++)
			for (int j = i + 1; j < 4; j++)
				for (int k = j + 1; k < 5; k++)
					if ((poker[i].getReal_value() + poker[j].getReal_value() + poker[k]
							.getReal_value()) % 10 == 0) {
						return false;
					}
		return true;
	}

	public boolean HuiSuabcde(Poker[] poker) {
		int indexOfb = 0;
		int indexOfc = 0;
		int indexOfd = 0;
		int indexOfe = 0;
		int indexOfa = 0;
		indexOfa = FirstLessSix();
		poker[0] = pokers[indexOfa];

		for (int i = indexOfa + 1; i < MAX_DNPOKER_COUNT; i++) {
			if ((poker[0].getPoker_value() + pokers[i].getPoker_value()) <= 7) {
				indexOfb = i;
				break;
			}
		}
		if (indexOfb == 0) {
			System.out.println("indexOfb==0!");
			return false;
		}

		else {
			poker[1] = pokers[indexOfb];
			for (int i = indexOfb + 1; i < MAX_DNPOKER_COUNT; i++) {
				if ((poker[0].getReal_value() + poker[1].getReal_value() + pokers[i]
						.getReal_value()) <= 8) {
					indexOfc = i;
					break;
				}
			}
			if (indexOfc == 0) {
				System.out.println("indexOfc==0!");
				return false;
			} else {
				poker[2] = pokers[indexOfc];
				for (int i = indexOfc + 1; i < MAX_DNPOKER_COUNT; i++) {
					if ((poker[0].getReal_value() + poker[1].getReal_value()
							+ poker[2].getReal_value() + pokers[i]
								.getReal_value()) <= 9) {
						indexOfd = i;
						break;
					}
				}
				if (indexOfd == 0) {
					return false;
				} else {
					poker[3] = pokers[indexOfd];

					for (int i = indexOfd + 1; i < MAX_DNPOKER_COUNT; i++) {
						if ((poker[0].getReal_value()
								+ poker[1].getReal_value()
								+ poker[2].getReal_value()
								+ poker[3].getReal_value() + pokers[i]
									.getReal_value()) <= 10) {
							indexOfe = i;
							break;
						}
					}
					if (indexOfe == 0) {
						return false;
					} else {

						poker[4] = pokers[indexOfe];
						return true;
					}
				}
			}
		}
	}

	public int FirstLessSix() {
		int num = -1;
		for (int i = poker_Position; i < MAX_DNPOKER_COUNT; i++) {
			if (pokers[i].getReal_value() <= 6) {
				num = i;
				break;
			}
		}
		return num;
	}

	public byte count_list(int j) {
		byte num = 0;
		for (int i = poker_Position; i < MAX_DNPOKER_COUNT; i++) {
			if (pokers[i].getPoker_value() == j) {
				num++;
			}
		}
		return num;
	}

	public boolean HuiSuTwo(int a, int b, int niu_num) {
		Poker poker1, poker2;
		poker1 = pokers[a];
		int i = b;
		while (i < MAX_DNPOKER_COUNT) {
			poker2 = pokers[i];
			i++;
			if (niu_num != 10) {
				if ((poker1.getReal_value() + poker2.getReal_value()) % 10 == niu_num) {
					indexOfTwo[0] = a;
					indexOfTwo[1] = i - 1;
					return true;
				}
			} else {
				if ((poker1.getReal_value() + poker2.getReal_value()) % 10 == 0) {
					indexOfTwo[0] = a;
					indexOfTwo[1] = i - 1;
					return true;
				}
			}

		}
		if (i >= MAX_DNPOKER_COUNT && a < MAX_DNPOKER_COUNT - 2) {
			a++;
			b = a + 1;
			return HuiSuTwo(a, b, niu_num);
		} else
			return false;

	}

	public boolean HuiSuThree(int a, int b, int c) {
		Poker poker1, poker2, poker3;
		poker1 = pokers[a];
		poker2 = pokers[b];
		int i = c;
		while (i < MAX_DNPOKER_COUNT) {
			poker3 = pokers[i];
			++i;
			if ((poker1.getReal_value() + poker2.getReal_value() + poker3
					.getReal_value()) % 10 == 0) {
				indexOfThree[0] = a;
				indexOfThree[1] = b;
				indexOfThree[2] = i - 1;
				return true;
			}

		}
		if (i >= MAX_DNPOKER_COUNT
				&& (a < MAX_DNPOKER_COUNT - 3 || b < MAX_DNPOKER_COUNT - 2)) {
			b++;
			c = b + 1;
			if (b >= MAX_DNPOKER_COUNT - 2) {
				a++;
				b = a + 1;
				c = b + 1;
			}
			return HuiSuThree(a, b, c);
		} else
			return false;
	}

}
