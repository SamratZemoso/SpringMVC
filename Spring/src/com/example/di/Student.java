package com.example.di;

public class Student {

    private String studentName;
    private int id;
    private Course course;

    // Object Dependency Injection
    public void setCourse(Course course) {
        this.course = course;
    }

    public void courseDetails() {
        course.courseEnroll();
    }

//    constructor Setter

//    public Student(String studentName, int id) {
//        this.id = id;
//        this.studentName = studentName;
//    }

//    Setter Methods

//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//    void displayName() {
//        System.out.println("Student Name is : " + studentName + " Student ID is : " + id);
//    }

}
