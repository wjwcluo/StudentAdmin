package NewDay2;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入想要购买的饮料：1、牛奶 2、雪碧 3、可乐 4、奶茶");
		int type = scanner.nextInt();
		if (type == 1) {
			System.out.println("牛奶");
		} else if (type == 2) {
			System.out.println("雪碧");
		} else if (type == 3) {
			System.out.println("可乐");
		} else if (type == 4) {
			System.out.println("奶茶");
		} else {
		    System.out.println("请输入1-4");
		}
	}
}
