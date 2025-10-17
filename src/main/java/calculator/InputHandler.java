package calculator;

public class InputHandler {

    private final String input;

    public InputHandler(String input) {
        this.input = input;
    }

    public boolean isBlank() {
        return input.isEmpty();
    }

    public Separator getSeparator() {

        if (input.startsWith("//") && input.contains("\\n")) {
            return new CustomSeparator(input);
        }
        return new BasicSeparator(input);
    }

}
