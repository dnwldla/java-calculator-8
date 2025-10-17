package calculator;

public class BasicSeparator extends Separator {

    public BasicSeparator(String input) {
        super(input);
    }


    @Override
    public String extractDelimiter() {
        return "[:,]";
    }

    @Override
    public String extractNumbers() {
        return input;
    }

}
