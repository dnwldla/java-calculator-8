package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final String input;
    private final String regex;

    public Parser(String input, String regex) {
        this.input = input;
        this.regex = regex;
    }

    List<Integer> parseNumbers() {
        String[] parts = input.split(regex);
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            int number;
            try {
                number = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력 형태가 올바르지 않습니다");
            }
            if (number <= 0) {
                throw new IllegalArgumentException("1 이상의 숫자를 입력해야 합니다");
            }

            numbers.add(number);

        }

        return numbers;


    }

}
