package calculator;

public class BasicSeparator extends Separator {

    public BasicSeparator(String input) {
        super(input);
    }


    @Override
    protected String extractDelimiter() {
        return "[:,]";
    }

    @Override
    protected String extractNumbers() {
        return input;
    }

}
