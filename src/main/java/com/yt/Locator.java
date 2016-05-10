package com.yt;

public class Locator {

	public String returnCoordinate(int x, int y) {
		float divisionX = (int) x / 188;
		float modX = x % 188;
		float halfX = 188 / 2; // 94
		float divisionY = (int) y / 100;
		float modY = y % 100;
		float halfY = 100 / 2; // 50

		System.out.println(divisionX);
		System.out.println(modX);
		System.out.println(halfX);
		System.out.println("====>>>>>>>>>>");
		System.out.println(divisionY);
		System.out.println(modY);
		System.out.println(halfY);
		System.out.println("====>>>>>>>>>>");

		float valueY = 0;

		int n = 0;
		int m = 0;

		if (modX < halfX) {
			// zuo shang
			if (modY < halfY) {
				valueY = modX / halfX * halfY;
				if ((50 - modY) > valueY) {
					n = (int) (divisionX - 1 + 1) * 1 - 1;
					m = (int) (divisionY - 1 + 1) * 2 - 1;
				} else if ((50 - modY) < valueY) {
					n = (int) (divisionX - 1 + 1) * 1;
					m = (int) (divisionY - 1 + 1) * 2;
				}
				System.out.println("11111111111");
			}
			// zuo xia
			else if (modY > halfY) {
				valueY = modX / halfX * halfY;
				if ((modY - 50) > valueY) {
					n = (int) (divisionX - 1 + 1) * 1 - 1;
					m = (int) (divisionY - 1 + 1) * 2 + 1;
				} else if ((modY - 50) < valueY) {
					n = (int) (divisionX - 1 + 1) * 1;
					m = (int) (divisionY - 1 + 1) * 2;
				}
				System.out.println("2222222222");
			} else if (modY == halfY) {
				n = (int) (divisionX - 1 + 1) * 1;
				m = (int) (divisionY - 1 + 1) * 2;
			}
		} else if (modX > halfX) {
			// you shang
			if (modY < halfY) {
				valueY = (modX - 94) / halfX * halfY;
				if (modY > valueY) {
					n = (int) (divisionX - 1 + 1) * 1;
					m = (int) (divisionY - 1 + 1) * 2;
				} else if (modY < valueY) {
					n = (int) (divisionX - 1 + 1) * 1;
					m = (int) (divisionY - 1 + 1) * 2 - 1;
				}
				System.out.println("3333333333333333");
				// you xia
			} else if (modY > halfY) {
				valueY = (modX - 94) / halfX * halfY;
				if (50 - (modY - 50) > valueY) {
					n = (int) (divisionX - 1 + 1) * 1;
					m = (int) (divisionY - 1 + 1) * 2;
				} else if (50 - (modY - 50) < valueY) {
					n = (int) (divisionX - 1 + 1) * 1;
					m = (int) (divisionY - 1 + 1) * 2 + 1;
				}
				System.out.println("44444444444444444");
			} else if (modY == halfY) {
				n = (int) (divisionX - 1 + 1) * 1;
				m = (int) (divisionY - 1 + 1) * 2;
			}
		} else if (modX == halfX) {
			n = (int) (divisionX - 1 + 1) * 1;
			m = (int) (divisionY - 1 + 1) * 2;
		}

		// System.out.println(valueY);
		System.out.println(n);
		System.out.println(m);
		System.out.println("=========================");

		return "";

	}

	public void returnXYCoordinate(int a, int b) {

		int divisionB = b / 2;
		int modB = b % 2;
		int x = 0;
		int y = 0;

		if (modB == 0) {
			x = a * 188 + 94;
			y = divisionB * 100 + 50;
		}else{
			x = a * 188 + 188;
			y = divisionB * 100 + 100;
			System.out.println(modB);
			System.out.println(x);
			System.out.println(y);
		}
	}

	public static void main(String[] args) {
		// new TestFirst().returnCoordinate(1322, 105); 1
		// new TestFirst().returnCoordinate(194, 693); 2
		// new TestFirst().returnCoordinate(79, 734); 1
		// new TestFirst().returnCoordinate(2746, 761); 4
		// new TestFirst().returnCoordinate(1, 1);
		// new TestFirst().returnCoordinate(2640, 711); 1
		// new TestFirst().returnCoordinate(1511, 99);
		// new TestFirst().returnCoordinate(1191, 163);
		// new TestFirst().returnCoordinate(1598, 1356);
		// new Locator().returnCoordinate(1411, 1250);
		new Locator().returnXYCoordinate(-1, 1);
	}
}
