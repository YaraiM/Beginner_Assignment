package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question1 {

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {

      System.out.print("1番目の数字を入力してください：");
      double number1 = scanner.nextDouble();

      System.out.print("演算子を入力してください（+, -, *, /）：");
      String operator = scanner.next();

      System.out.print("2番目の数字を入力してください：");
      double number2 = scanner.nextDouble();

      double result;
      boolean isValid = true;

      switch (operator) {
        case "+" -> result = number1 + number2;
        case "-" -> result = number1 - number2;
        case "*" -> result = number1 * number2;
        case "/" -> {
          if (number2 == 0) {
            System.out.println("エラー：0で割ることはできません");
            isValid = false;
            result = 0; //resultにダミー値を入力

          } else {
            result = number1 / number2;
          }

        }

        default -> {
          System.out.println(
              "エラー：演算子が入力されなかったため、計算できません。入力値: " + operator);
          isValid = false;
          result = 0; //resultにダミー値を入力
        }
      }

      if (isValid) {
        System.out.println(number1 + " " + operator + " " + number2 + " " + "= " + result);
      }

    } catch (InputMismatchException ex) {
      System.out.println("エラー：数値が入力されなかったため、計算できませんでした");
    }

  }

}
