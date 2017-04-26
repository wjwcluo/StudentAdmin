package NewDay2;

import java.util.Scanner;

public class StudentAdmin {
    public static void main(String[] args) {
    	Student[] stus = new Student[2];
    	Scanner scanner = new Scanner(System.in);
    	for (int i = 0; i < stus.length; i++) {
    		Student student = new Student();
			System.out.println("请输入第" + (i + 1) + "个学生的姓名：");
			String name = scanner.next();
			student.setName(name);
			System.out.println("请输入第" + (i + 1) + "个学生的性别：");
			String sex = scanner.next();
			student.setSex(sex);
			System.out.println("请输入第" + (i + 1) + "个学生的年龄：");
			int age = scanner.nextInt();
			student.setAge(age);
			stus[i] = student;
		}
    	for (int i = 0; i < stus.length; i++) {
			System.out.println(stus[i].getName() + " " + stus[i].getSex() + " " + stus[i].getAge());
		}
    	while(true) {
    		System.out.println("根据条件查询学生信息：\n" + "1、根据姓名查询\n" + "2、根据性别查询\n" + "3、根据年龄查询\n" + "0、退出");
    		int type = scanner.nextInt();
    		if (type == 0) {
    			return;
    		}
    		switch(type) {
    		case 1:
    			System.out.println("请输入要查找的学生姓名：");
    			String name = scanner.next();
    			boolean isSearchByName = false;
    			for (int i = 0; i < stus.length; i++) {
					if (name.equals(stus[i].getName())) {
						isSearchByName = true;
						System.out.println(stus[i].getName() + " " + stus[i].getSex() + " " + stus[i].getAge());
					}
				}
    			if (isSearchByName == false) {
					System.out.println("没有查询到该姓名的学生");
				}
    		case 2:
    			System.out.println("请输入要查找的学生性别：");
    			String sex = scanner.next();
    			boolean isSearchBySex = false;
    			for (int i = 0; i < stus.length; i++) {
					if (sex.equals(stus[i].getSex())) {
						isSearchBySex = true;
						System.out.println(stus[i].getName() + " " + stus[i].getSex() + " " + stus[i].getAge());
					}
				}
    			if (isSearchBySex == false) {
					System.out.println("没有查询到该性别的学生");
				}
    		case 3:
    			System.out.println("请输入要查找的学生年龄：");
    			int age = scanner.nextInt();
    			boolean isSearchByAge = false;
    			for (int i = 0; i < stus.length; i++) {
					if (age == stus[i].getAge()) {
						isSearchByAge = true;
						System.out.println(stus[i].getName() + " " + stus[i].getSex() + " " + stus[i].getAge());
					}
				}
    			if (isSearchByAge == false) {
					System.out.println("没有查询到该年龄的学生");
				}
    		}
    	}
	}
}
