package com.codegym;


import java.util.Scanner;

public class Main {
    public static Scanner inputNumber = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        int choice = -1;
        do {
            studentManagement.menu();

            System.out.println("Nhập lựa chọn của bạn: ");
            choice = inputNumber.nextInt();


            switch (choice) {
                case 1: {
                    System.out.println("----Hiển thị toàn bộ thông tin sinh viên----");
                    studentManagement.displayAllStudent();
                    if (studentManagement.getStudents().size() == 0) {
                        System.out.println("Không có sinh viên nào để hiển thị!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("----Thêm sinh viên----");
                    Student newStudent = studentManagement.inputNewStudent();
                    studentManagement.addStudent(newStudent);
                    System.out.println("Đã thêm thành công!");
                    break;
                }
                case 3: {
                    System.out.println("---Sửa thông tin sinh viên----");
                    System.out.println("Nhập STT sinh viên cần sửa: ");
                    int index = inputNumber.nextInt();
                    if (index - 1 < 0 || index - 1 >= studentManagement.getStudents().size()) {
                        System.out.println("STT không đúng!");
                    } else {
                        Student newStudent = studentManagement.inputNewStudent();
                        studentManagement.updateStudent(index - 1, newStudent);
                        System.out.println("Đã cập nhật thông tin thành công!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("----Xóa sinh viên----");
                    System.out.println("Nhập STT sinh viên cần xóa: ");
                    int index = inputNumber.nextInt();
                    if (index - 1 < 0 || index - 1 >= studentManagement.getStudents().size()) {
                        System.out.println("STT không đúng!");
                    } else {
                        studentManagement.removeStudent(index);
                        System.out.println("Đã xóa thành công!");
                    }
                    break;
                }
                case 5: {
                    System.out.println("----Sắp xếp danh sách sinh viên theo điểm giảm dân----");
                    studentManagement.sortStudents();
                    break;
                }
                case 6: {
                    System.out.println("----Tìm kiếm sinh viên theo MSSV----");
                    studentManagement.findNameStudent();
                    break;
                }
            }
        } while (choice != 0);
    }
}
