package calculator;

import java.util.List;

public class BasicSeparator implements Separator {

    private final String input;
    private final Parser parser;

    public BasicSeparator(String input) {
        this.input = input;
        this.parser = new Parser();
    }

    @Override
    public List<Integer> buildNumbers() {
        return getParse();
    }

    private String getPattern() {
        return "[:,]";
    }

    private String getNumbers() {
        return input;
    }

    private List<Integer> getParse() {
        return parser.parseNumbers(getNumbers(), getPattern());
    }

}
