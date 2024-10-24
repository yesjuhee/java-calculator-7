package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        DelimiterParser delimiterParser = new DelimiterParser(input);
        String expression = delimiterParser.getExpression();
        List<Character> delimiters = delimiterParser.getDelimiters();

        int result = Calculator.calculateString(expression, delimiters);

        System.out.println("결과 : " + result);
    }
}
