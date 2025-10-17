package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Calculator {

    public void start() {
        PromptView.printPrompt();

        InputHandler inputHandler = new InputHandler(readLine());

        if (inputHandler.isBlank()) {
            PromptView.printResult(0);
            return;
        }

        Separator separator = inputHandler.getSeparator();
        List<Integer> numbers = separator.buildNumbers();

        PromptView.printResult(calculate(numbers));

    }

    public int calculate(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

}

