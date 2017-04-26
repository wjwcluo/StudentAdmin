package NewDay2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	List<Student> list = new ArrayList<Student>();
	Scanner scanner = new Scanner(System.in);
	
	public void load() {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			File file = new File("d:/test.txt");
			if (file.exists()) {
				fileInputStream = new FileInputStream("d:/test.txt");
				objectInputStream = new ObjectInputStream(fileInputStream);
				list = (List<Student>) objectInputStream.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void addStuInfo() {
		System.out.println("请输入要录入的学生的个数：");
		int num = scanner.nextInt();
		for (int i = 0; i < num; i++) {
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
			list.add(student);
		}
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("d:/test.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void showAll() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName()
					+ " " + list.get(i).getSex() + " " + list.get(i).getAge());
		}
	}
	
	public void deleteStuInfo() {
		System.out.println("请输入要删除的学生姓名：");
		String name = scanner.next();
		Iterator<Student> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getName().equals(name)) {
				iterator.remove();
			}
		}
		showAll();
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("d:/test.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void searchStuInfo() {
		System.out.println("请输入要查找的学生姓名：");
		String name = scanner.next();
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				System.out.println(list.get(i).getName()
						+ " " + list.get(i).getSex() + " " + list.get(i).getAge());
			}
		}
	}
	
    public static void main(String[] args) {
    	StudentManager studentManager = new StudentManager();
    	studentManager.load();
    	System.out.println("------------欢迎使用学生管理系统--------------");
		while (true) {
			System.out.println("请输入要执行的操作：1-录入 2-展示 3-删除 4-查找 0-退出");
			System.out.println("-----------------------------------------");
			int type = studentManager.scanner.nextInt();
			if (type == 1) {
				studentManager.addStuInfo();
			} else if (type == 2) {
				studentManager.showAll();
			} else if (type == 3) {
				studentManager.deleteStuInfo();
			} else if (type == 4) {
				studentManager.searchStuInfo();
			} else {
				return;
			} 
		}
	}
}
