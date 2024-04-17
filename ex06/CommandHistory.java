package ex06;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private static CommandHistory instance;
    private List<Command> history = new ArrayList<>();

    private CommandHistory() {}

    public static synchronized CommandHistory getInstance() {
        if (instance == null) {
            instance = new CommandHistory();
        }
        return instance;
    }

    public void add(Command command) {
        history.add(command);
    }
}
