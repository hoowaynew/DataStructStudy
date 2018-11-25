package cn.itcast.StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StuManagement {

    public static void main(String[] args) {

        // 创建学生集合
        ArrayList<Student> studentsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------欢迎来到学生管理系统---------");
            System.out.println("1 查看学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 查看所有学生");
            System.out.println("6 退出");

            // 获取用户输入操作选项
            int choose = -1;
            System.out.print("---请输入您的操作>>> ");
            try {
                choose = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("输入错误，请重新输入整数...");
                return;
            }

            try {
                switch (choose) {
                    case 1:
                        checkStu(studentsList);
                        break;
                    case 2:
                        addStu(studentsList);
                        break;
                    case 3:
                        removeStu(studentsList);
                        break;
                    case 4:
                        setStu(studentsList);
                        break;
                    case 5:
                        checkAllStu(studentsList);
                        break;
                    case 6:
                        scanner.close();
                        System.out.println("感谢您的使用,下次再见...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("输入错误，请重新选择...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("请重新输入正确的学号...");
            }
        }
    }

    private static void checkAllStu(ArrayList<Student> studentsList) {
        if (studentsList.size() == 0) {
            System.out.println("学生管理系统为空...");
        } else {
                System.out.println("学号\t\t姓名\t\t年龄\t\t地址");
            for (Student student : studentsList) {
                System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getAddr() + "\t\t");
            }
            System.out.println();
        }
    }

    // 私有方法，用于根据学号id来寻找是否包含此学号学生，有的话返回此学生，没有则返回null
    private static Student findStu(ArrayList<Student> studentArrayList,  int id) {
        for (Student student : studentArrayList) {
            if (id == student.getId()) {
                return student;
            }
        }
        return null;
    }

    private static void checkStu(ArrayList<Student> studentArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要查看学生的学号: ");
        int id = scanner.nextInt();
        Student student = findStu(studentArrayList, id);
        if (student == null) {
            System.out.println("学号为 " + id + " 的学生不存在...");
        } else {
            System.out.println("学号\t\t姓名\t\t年龄\t\t地址");
            System.out.print(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getAddr() + "\t\t");
        }
//        for (int i = 0; i < studentArrayList.size(); i++) {
//            Student student = studentArrayList.get(i);
//            if(student.getId() == id) {
//                System.out.println("学号\t姓名\t年龄\t地址");
//                System.out.print(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getAddr() + "\t");
//            }
//        }
        System.out.println();
    }

    private static void addStu(ArrayList<Student> studentsList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要添加的学生学号: ");
        int id = scanner.nextInt();
        if (findStu(studentsList,id) != null) {
            System.out.println("学号为 " + id + " 的学生已存在...");
        } else {
            System.out.print("请输入需要添加的学生姓名: ");
            String name = scanner.next();
            System.out.print("请输入需要添加的学生年龄: ");
            int age = scanner.nextInt();
            System.out.print("请输入需要添加的学生地址: ");
            String addr = scanner.next();
            Student student = new Student(id,name,age,addr);
            studentsList.add(student);
            System.out.println("学号为" + id +"的学生添加成功...");
        }
    }

    private static Student removeStu(ArrayList<Student> studentArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要查看学生的学号: ");
        int id = scanner.nextInt();
        Student student = findStu(studentArrayList, id);
        if (student != null) {
            studentArrayList.remove(student);
            System.out.println("学号为" + id +"的学生删除成功...");
        } else {
            System.out.println("学号为" + id +"的学生不存在...");
        }
        return student;
    }

    private static Student setStu(ArrayList<Student> studentArrayList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要查看学生的学号: ");
        int id = scanner.nextInt();
        Student student = findStu(studentArrayList, id);
        if (student != null) {
            System.out.print("请输入需要添加的学生姓名: ");
            String name = scanner.next();
            System.out.print("请输入需要添加的学生年龄: ");
            int age = scanner.nextInt();
            System.out.print("请输入需要添加的学生地址: ");
            String addr = scanner.next();
            student.setName(name);
            student.setAge(age);
            student.setAddr(addr);
            System.out.println("学号为" + id +"的学生修改成功...");
        } else {
            System.out.println("学号为" + id +"的学生不存在...");
        }
        return student;
    }
}
