package calculator;

public class CustomSeparator extends Separator {

    private static final int LIMIT = 1;
    private static final String START = "//";
    private static final String END = "\\n";

    public CustomSeparator(String input) {
        super(input);

    }

    @Override
    protected String extractDelimiter() {
        int startIndex = input.indexOf(START) + 2;
        int endIndex = input.indexOf(END);

        String delimiter = input.substring(startIndex, endIndex);
        validate(delimiter);

        return "\\" + delimiter;

    }

    @Override
    protected String extractNumbers() {
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


}
