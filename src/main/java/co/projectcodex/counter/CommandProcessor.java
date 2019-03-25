package co.projectcodex.counter;

public class CommandProcessor {
    private MultiplesCounter multiplesCounter;

    public CommandProcessor(MultiplesCounter multiplesCounter) {
        this.multiplesCounter = multiplesCounter;
    }

    public String process(String commandString) {

        //todo - add a better way of processing commands
        String[] commandParts = commandString.split(" ");
        String command = commandParts[0];

        if (command.equals("up")) {
            multiplesCounter.count();
            return "Counter incremented";
        } else if(command.equals("show")) {
            return String.format("Current value: %d", multiplesCounter.value());
        } else {
            return "Invalid command!";
        }
    }
}
