package org.example.Lv3;

public enum OperatorTypeLv3 {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    OperatorTypeLv3(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperatorTypeLv3 fromChar(char symbol) { // 문자열을 연산자로 변환
        for (OperatorTypeLv3 operator : OperatorTypeLv3.values()) { // 모든 연산자 타입을 순회
            if (operator.getSymbol() == symbol) {
                return operator;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
}
