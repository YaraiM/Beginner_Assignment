package org.example;

import java.util.Scanner;

public class Question3 {

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {

      System.out.print("携帯電話番号を入力してください（○○○-○○○○-○○○○の形式）：");
      String phoneNumber = scanner.next();

      if (phoneNumber.matches("^(070|080|090)-\\d{4}-\\d{4}$")) {
        System.out.println(phoneNumber + "は国内で有効な携帯電話番号の形式です。");
      } else {
        System.out.println(phoneNumber + "は国内で無効な携帯電話番号の形式です。");
      }

    } catch (Exception ex) {
      System.out.println("エラー：予期しないエラーが発生しました。プログラムを強制終了します。");

    }

  }

}
