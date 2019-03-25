package co.projectcodex.counter;

import co.projectcodex.counter.multiples.JdbcMultiplesCounter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class CounterRunner {
    public static void main(String[] args) {

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/multiples_counter_test", "sa", "");

            MultiplesCounter multiplesCounter = new JdbcMultiplesCounter(7, conn);
            CommandProcessor commandProcessor = new CommandProcessor(multiplesCounter);

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
                String result = commandProcessor.process(commandString);
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
