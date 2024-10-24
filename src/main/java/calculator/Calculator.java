package calculator;

import java.util.List;

public class Calculator {
    public static int calculateString(String expression, List<Character> delimiters) {
        String[] numberTokens = splitString(expression, delimiters);

        int sum = 0;
        for (String numberToken : numberTokens) {
            if (numberToken.isEmpty()) {
                continue;
            }
            try {
                int numberTokenValue = Integer.parseInt(numberToken);
                if (numberTokenValue < 0) {
                    throw new IllegalArgumentException("숫자는 양수만 입력할 수 있습니다.");
                }
                sum += numberTokenValue;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자와 양수만 입력할 수 있습니다.");
            }
        }
        return sum;
    }

    private static String[] splitString(String expression, List<Character> delimiters) {
        for (char delimiter : delimiters) {
            expression = expression.replace(delimiter, ',');
        }
        expression = expression.replace(':', ',');
        return expression.split(",");
    }
}
