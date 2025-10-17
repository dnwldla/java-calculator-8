package calculator;

import java.util.List;

public class CustomSeparator implements Separator {

    private static final int LIMIT = 1;
    private static final String START = "//";
    private static final String END = "\\n";

    private final Parser parser;
    private final String input;

    public CustomSeparator(String input) {
        this.input = input;
        this.parser = new Parser();
    }

    @Override
    public List<Integer> buildNumbers() {
        return build();
    }

    private String getPattern() {
        int startIndex = input.indexOf(START) + 2;
        int endIndex = input.indexOf(END);

        String delimiter = input.substring(startIndex, endIndex);
        validate(delimiter);

        return "\\" + delimiter;

    }

    private String getNumbers() {
        int endIndex = input.indexOf(END);
        return input.substring(endIndex + 2);
    }

    private void validate(String delimiter) {

        if (delimiter.length() > LIMIT) {
            throw new IllegalArgumentException("단일 구분자이어야 합니다");

        }

        if (delimiter.equals(":") || delimiter.equals(",")) {
            throw new IllegalArgumentException("구분자는 : 또는 , 일수 없습니다");
        }

        char firstChar = delimiter.charAt(0);
        if (Character.isDigit(firstChar)) {
            throw new IllegalArgumentException("구분자는 숫자일 수 없습니다");
        }
    }


    private List<Integer> build() {
        return parser.parseNumbers(getNumbers(), getPattern());
    }
}
