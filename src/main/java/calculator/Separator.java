package calculator;

import java.util.List;

public abstract class Separator {

    String input;
    Parser parser;

    public Separator(String input) {
        this.input = input;
    }

    public List<Integer> buildNumbers() {
        parser = createParser();
        return parser.parseNumbers();
    }

    protected Parser createParser() {
        return new Parser(extractNumbers(), extractDelimiter());
    }

    protected abstract String extractNumbers();

    protected abstract String extractDelimiter();

}
