package co.projectcodex.counter;

import co.projectcodex.counter.multiples.TheMultiplesCounter;

import java.util.Scanner;

public class CounterRunner {
    public static void main(String[] args) {

        MultiplesCounter multiplesCounter = new TheMultiplesCounter(7);

        Scanner commandLineScanner =  new Scanner(System.in);

        boolean exitNow = false;

        while(!exitNow) {
            System.out.print("Please enter your command:");
            String commandString = commandLineScanner.nextLine();
            if (commandString.equals("exit")){
                exitNow = true;
                System.out.println("Bye!");
                return;
            }

            //todo - add a better way of processing commands
            String[] commandParts = commandString.split(" ");
            String command = commandParts[0];

            if (command.equals("up")) {
                multiplesCounter.count();
            } else if(command.equals("show")) {
                System.out.println(String.format("Current value: %d", multiplesCounter.value()));
            } else {
                System.out.println("Invalid command!");
            }


        }

    }
}
