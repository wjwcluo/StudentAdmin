package NewDay2;

import java.util.Scanner;

import org.junit.Test;

public class Score {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的成绩：");
		int score = sc.nextInt();
		if (score <= 100 && score >= 90) {
			System.out.println("优秀");
		} else if (score >= 80) {
			System.out.println("良好");
		} else if (score >= 70) {
			System.out.println("一般");
		} else if (score >= 60) {
			System.out.println("及格");
		} else {
			System.out.println("不及格");
		}
	}
    @Test
    public void scoreSwitch() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入你的成绩：");
    	int score = scanner.nextInt();
    	int type = score / 10;
    	if (score > 100 || score < 0) {
    		System.out.println("输入有误！");
    		return;
    	}
    	switch (type) {
		case 10:
		case 9:
			System.out.println("优秀");
			break;
		case 8:
			System.out.println("良好");
			break;	
		case 7:
			System.out.println("一般");
			break;
		case 6:
			System.out.println("及格");
			break;
		default:
			System.out.println("不及格");
			break;
		}
    }
}
