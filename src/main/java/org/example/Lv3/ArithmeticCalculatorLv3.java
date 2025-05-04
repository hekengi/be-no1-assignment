package org.example.Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculatorLv3<T extends Number> {
    private final List<Double> results = new ArrayList<>();

    public double calculate(T a, T b, OperatorTypeLv3 operator) {
        double number1 = a.doubleValue();
        double number2 = b.doubleValue();
        double result;

        switch (operator) {
            case ADD:
                result = number1 + number2;
                break;
            case SUBTRACT:
                result = number1 - number2;
                break;
            case MULTIPLY:
                result = number1 * number2;
                break;
            case DIVIDE:
                if (number2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

        results.add(result);
        return result;
    }

    public List<Double> getResults() {
        return results;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    public List<Double> ResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(num -> num > threshold)
                .collect(Collectors.toList());
    }
}
