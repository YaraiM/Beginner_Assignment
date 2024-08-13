package org.example;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Question2 {

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {
      int option = 0;
      List<Student> studentList = new ArrayList<>();

      while (option != 6) {
        printMenu();

        try {
          option = scanner.nextInt();
        } catch (InputMismatchException ex) {
          System.out.println("エラー：数値を入力してください");
          scanner.nextLine();
          continue;
        }

        switch (option) {
          case 1 -> addStudent(scanner, studentList);
          case 2 -> removeStudent(scanner, studentList);
          case 3 -> updateScore(scanner, studentList);
          case 4 -> calculateAverage(studentList);
          case 5 -> displayAllStudent(studentList);
          case 6 -> System.out.println("プログラムを終了します。");
          default -> System.out.println("エラー：選択した値が無効です。1~6を入力してください");
        }
      }

    } catch (Exception ex) {
      System.out.println("エラー：予期しないエラーが発生しました。プログラムを強制終了します。");
    }
  }

  private static void printMenu() {
    System.out.println("1.学生を追加");
    System.out.println("2.学生を削除");
    System.out.println("3.点数を更新");
    System.out.println("4.平均点を計算");
    System.out.println("5.全学生の情報を表示");
    System.out.println("6.終了");
    System.out.print("実行したい操作を選択してください：");
  }

  private static void addStudent(Scanner scanner, List<Student> studentList) {
    String studentName;

    while (true) {
      System.out.print("学生の名前を入力してください：");
      studentName = scanner.next();

      if (findStudent(studentList, studentName) != null) {
        System.out.println("その名前の受講生はすでに存在します。別の名前を入力してください。");
      } else {
        break;
      }
    }

    System.out.print(studentName + "の点数を入力してください：");
    int studentScore = getValidScore(scanner);

    Student student = new Student(studentName, studentScore);
    studentList.add(student);
    System.out.println("以下の情報が登録されました。");
    System.out.println("学生名：" + studentName + "、点数：" + studentScore);
  }

  private static void removeStudent(Scanner scanner, List<Student> studentList) {
    System.out.print("学生の名前を入力してください：");
    String studentName = scanner.next();

    Student studentToRemove = findStudent(studentList, studentName);
    if (studentToRemove != null) {
      studentList.remove(studentToRemove);
      System.out.println(studentName + "を削除しました。");
    } else {
      System.out.println(studentName + "は存在しないため、削除処理ができませんでした。");
    }
  }

  private static void updateScore(Scanner scanner, List<Student> studentList) {
    System.out.print("学生の名前を入力してください：");
    String studentName = scanner.next();

    Student studentToUpdate = findStudent(studentList, studentName);
    if (studentToUpdate != null) {
      System.out.print(studentName + "の点数を入力してください：");
      int studentScore = getValidScore(scanner);
      studentToUpdate.setStudentScore(studentScore);
      System.out.println(studentName + "の点数を" + studentScore + "に更新しました。");
    } else {
      System.out.println(studentName + "は存在しないため、更新処理ができませんでした。");
    }
  }

  private static void calculateAverage(List<Student> studentList) {

    if (studentList.isEmpty()) {
      System.out.println("受講生が登録されていません。");
      return;
    }

    double averageScore = studentList.stream()
        .mapToInt(Student::getStudentScore)
        .average()
        .orElse(0);

    System.out.println("受講生の平均点は" + averageScore + "です。");
  }

  private static void displayAllStudent(List<Student> studentList) {
    if (studentList.isEmpty()) {
      System.out.println("受講生が登録されていません。");
      return;
    }

    studentList.forEach(student -> System.out.println(
        "名前：" + student.getStudentName() + "、点数：" + student.getStudentScore()));
  }

  private static Student findStudent(List<Student> studentList, String studentName) {
    return studentList.stream()
        .filter(student -> student.getStudentName().equals(studentName))
        .findFirst()
        .orElse(null);
  }

  private static int getValidScore(Scanner scanner) {
    while (true) {
      try {
        int score = scanner.nextInt();

        if (score < 0 || score > 100) {
          System.out.print("エラー：0から100までの数値を入力してください：");
        } else {
          return score;
        }

      } catch (InputMismatchException ex) {
        System.out.print("エラー：数値を入力してください：");
        scanner.next(); //無効な入力値を削除
      }
    }
  }
}
