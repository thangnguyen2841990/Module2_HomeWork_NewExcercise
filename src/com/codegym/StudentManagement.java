package com.codegym;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<>();

    public StudentManagement() {
    }

    public StudentManagement(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void updateStudent(int index, Student newStudent) {
        students.set(index, newStudent);
    }

    public void removeStudent(int index) {
        students.remove(index);
    }

    public void displayAllStudent() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public Student inputNewStudent() {
        System.out.println("MSSV: ");
        int studentCode = inputNumber.nextInt();
        System.out.println("Họ và tên: ");
        String name = inputString.nextLine();
        System.out.println("Quê quán: ");
        String homeTown = inputString.nextLine();
        System.out.println("Lớp: ");
        String className = inputString.nextLine();
        System.out.println("Điểm: ");
        double score = inputNumber.nextDouble();
        return new Student(studentCode, name, homeTown, className, score);
    }

    public void menu() {
        System.out.println("----QUẢN LÝ SINH VIÊN----");
        System.out.println("1. Hiển thị toàn bộ danh sách sinh viên.");
        System.out.println("2. Thêm sinh viên.");
        System.out.println("3. Sửa thông tin sinh viên");
        System.out.println("4. Xóa sinh viên.");
        System.out.println("5. Sắp xếp sinh viên theo điểm giảm dần.");
        System.out.println("6. Tìm kiếm sinh viên theo MSSV.");
        System.out.println("0. Thoát.");
    }

    public void sortStudents() {
        System.out.println("1. Sử dụng sắp xếp nổi bọt.");
        System.out.println("2. Sử dụng sắp xếp chọn.");
        System.out.println("3. sử dụng sắp xếp chèn.");
        System.out.println("4. Quay lại");
        int choice = -1;
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("----Sử dụng sắp xếp nổi bọt----");
                    for (int i = 0; i < students.size(); i++) {
                        for (int j = 0; j < students.size() - i - 1; j++) {
                            if (students.get(j).getScore() < students.get(j + 1).getScore()) {
                                Student temp = students.get(j);
                                students.set(j, students.get(j + 1));
                                students.set(j + 1, temp);
                            }
                        }
                    }
                    displayAllStudent();
                    break;
                }
                case 2: {
                    System.out.println("----Sử dụng sắp xếp chọn----");
                    for (int i = 0; i < students.size(); i++) {
                        int maxIndex = i;
                        for (int j = i + 1; j < students.size(); j++)
                            if (students.get(j).getScore() > students.get(maxIndex).getScore())
                                maxIndex = j;
                        if (maxIndex != i) {
                            Student temp = students.get(i);
                            students.set(i, students.get(maxIndex));
                            students.set(maxIndex, temp);
                        }
                    }
                    displayAllStudent();
                    break;
                }
                case 3: {
                    System.out.println("----Sử dụng sắp xếp chèn----");

                    for (int i = 1; i < students.size(); i++) { //đoạn array[0] đã sắp xếp
                        Student student = students.get(i);
                        int j = i - 1;
                        while (j >= 0 && student.getScore() > students.get(j).getScore()) {
//                            students.get(pos) = students.get(pos-1); // đổi chỗ
                            students.set(j + 1, students.get(j));
                            j--;
                        }
                        students.set(j + 1, student);
                    }
                    displayAllStudent();
                    break;
                }

            }
            break;
        } while (choice != 4);
    }


    public void findNameStudent() {

        System.out.println("1. Tìm kiếm tuyến tính.");
        System.out.println("2. Tìm kiếm nhị phân.");
        System.out.println("3. Quay lại menu chính");
        int choice = -1;
        int index = -1;
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("----Tìm kiếm tuyến tính----");
                    System.out.println("Nhập MSSV cần tìm: ");
                    int studentCode = inputNumber.nextInt();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getStudentCode() == studentCode) {
                            index = i;
                        }
                    }
                    if (index == -1) {
                        System.out.println("Không tìm thấy sinh viên có MSSV: " + studentCode);
                    } else {
                        System.out.println(students.get(index));
                    }

                    break;
                }
                case 2: {
                    System.out.println("----Tìm kiếm nhị phân----");
                    System.out.println("Nhập MSSV cần tìm: ");
                    int studentCode = inputNumber.nextInt();
                    int low = 0;
                    int high = students.size() - 1;
                    int mid = -1;
                    while (high >= low) {
                        mid = (low + high) / 2;
                        if (studentCode > students.get(mid).getStudentCode()) {
                            low = mid + 1;
                        } else if (studentCode < students.get(mid).getStudentCode()) {
                            high = mid - 1;
                        } else if (studentCode == students.get(mid).getStudentCode()) {
                            index = mid;
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("Không tìm thấy sinh viên có MSSV: " + studentCode);
                    } else {
                        System.out.println(students.get(index));
                    }
                    break;

                }
            }
            break;
        } while (choice != 3);

    }
}
