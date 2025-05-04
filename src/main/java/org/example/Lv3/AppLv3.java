package org.example.Lv3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppLv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculatorLv3<Double> calculator = new ArithmeticCalculatorLv3<>();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = sc.nextDouble();

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = sc.nextDouble();

            System.out.print("연산 기호를 입력하세요: ");
            char opChar = sc.next().charAt(0);

            try {
                OperatorTypeLv3 op = OperatorTypeLv3.fromChar(opChar);
                double result = calculator.calculate(num1, num2, op);
                System.out.printf("결과: %.2f\n", result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (calculator.getResults().size() > 5) {
                System.out.println("계산 결과 목록이 5개를 초과했습니다. 첫 번째 결과를 삭제합니다.");
                calculator.removeResult();
            }

            List<String> formattedResults = calculator.getResults().stream()
                    .map(r -> String.format("%.2f", r))
                    .collect(Collectors.toList());
            System.out.println("계산 결과 목록: " + formattedResults);
            System.out.println();

            System.out.println("입력 값보다 큰 결과를 조회합니다.");
            System.out.print("기준 값을 입력하세요: ");
            double threshold = sc.nextDouble();

            List<String> filtered = calculator.ResultsGreaterThan(threshold).stream()
                    .map(r -> String.format("%.2f", r))
                    .collect(Collectors.toList());
            System.out.println("기준값보다 큰 결과: " + filtered);

            System.out.print("계속 하시겠습니까? (exit 입력 시 종료): ");
            if (sc.next().equals("exit")) break;
            System.out.println();
        }
    }
}
