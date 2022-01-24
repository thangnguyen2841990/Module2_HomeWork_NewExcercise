package com.codegym;

public class Student {
    private int studentCode;
    private String name;
    private String homeTown;
    private String className;
    private double score;

    public Student() {
    }

    public Student(int studentCode, String name, String homeTown, String className, double score) {
        this.studentCode = studentCode;
        this.name = name;
        this.homeTown = homeTown;
        this.className = className;
        this.score = score;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MSSV: "+ this.studentCode + ", Họ và tên: "+this.name + ", Quê quán: "+ this.homeTown + ", Lớp: "+this.className+
                ", Điểm: "+ this.score;
    }
}
