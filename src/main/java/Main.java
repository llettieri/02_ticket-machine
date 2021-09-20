import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static final Scanner keyboard = new Scanner(System.in);
    private static TicketMachine tMachine = new TicketMachine();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Insert Destination ZIP:");
            try {
                int zipcode = keyboard.nextInt();
                if (tMachine.getDestinationsList().contains(zipcode)) {
                    tMachine.setDestination(zipcode);
                    break;
                } else {
                    System.out.println("ZIP doesn't exists!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Try again!");
                keyboard.next();
            }
        }

        System.out.println("Insert your preferred mode (first (f), second (s), halfPrice (hp), with back ride (b)):");
        switch (keyboard.next().toLowerCase()) {
            case "f" -> tMachine.setMode("f");
            case "s" -> tMachine.setMode("s");
            case "hp" -> tMachine.setMode("hp");
            case "b" -> tMachine.setMode("b");
        }

        System.out.println(tMachine.showPrice());

        System.out.println("Do you wanna buy it? (y/n)");
        switch (keyboard.next()) {
            case "y" -> {
                while (true) {
                    System.out.println("Please Insert money:");
                    tMachine.insertMoney(keyboard.nextInt());

                    if (tMachine.getBalance() >= tMachine.getPrice()) {
                        tMachine.printTicket();
                        break;
                    } else {
                        System.out.println("Not enough money! Please try again!");
                    }
                }
            }
            case "b" -> exit(0);
        }

        if (tMachine.getBalance() != 0) {
            System.out.println("Your cashback. See ya!");
            tMachine.cashBack();
        }
    }

    private static void createTicket() {
        clear();
        System.out.println("Price? (standard 1000");
        tMachine = new TicketMachine(keyboard.nextInt());
    }

    private static void insertMoney() {
        clear();
        System.out.println("How much money would you insert?");
        tMachine.insertMoney(keyboard.nextInt());

        System.out.println("\nYour current balance: " + tMachine.getBalance());
    }

    private static void updateTicket() {
        clear();
        System.out.println("What should the new price be?");
        tMachine.setPrice(keyboard.nextInt());

        System.out.println("\nThe ticket has been updated!");
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

