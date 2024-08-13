package org.example;

public class Student {

  String studentName;
  int studentScore;

  public Student(String studentName, int studentScore) {
    this.studentName = studentName;
    this.studentScore = studentScore;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public int getStudentScore() {
    return studentScore;
  }

  public void setStudentScore(int studentScore) {
    this.studentScore = studentScore;
  }
}
