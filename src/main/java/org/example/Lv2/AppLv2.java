package org.example.Lv2;

import java.util.List;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {
        CalculatorLv2 calculatorLv2 = new CalculatorLv2();

        Scanner sc = new Scanner(System.in);

        /* 반복문 시작 */
        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try{
                int result = calculatorLv2.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
                calculatorLv2.setResults(result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            List<Integer> results = calculatorLv2.getResults();

            if(results.size() > 5) {
                System.out.println("계산 결과 목록이 5개를 초과했습니다. 첫 번째 결과를 삭제합니다.");
                calculatorLv2.removeResult();
            }

            System.out.println("계산 결과 목록: " + results);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
            System.out.println();

        }
    }
}
