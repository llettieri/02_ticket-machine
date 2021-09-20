import java.util.ArrayList;
import java.util.List;

public class TicketMachine {
    private int price;
    private int balance;
    private int total;
    private int destination;
    private final List<Integer> destinationsList = new ArrayList<>();
    private String mode;

    public TicketMachine() {
        price = 1000;
        genDestinationList();
    }

    public TicketMachine(int ticketCost) {
        if (ticketCost > 0) {
            price = ticketCost;
        } else {
            price = 1000;
        }
        balance = 0;
        total = 0;
        genDestinationList();
    }

    private void genDestinationList() {
        destinationsList.add(8633);
        destinationsList.add(8630);
        destinationsList.add(1000);
        destinationsList.add(1212);
    }

    public List<Integer> getDestinationsList() {
        return destinationsList;
    }

    public int getPrice() {
        return price;
    }

    public int getBalance() {
        return balance;
    }

    public int getTotal() {
        return total;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be more than 0.");
        }
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void reset() {
        balance = 0;
    }

    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Amount must be more than 0.");
        }
    }

    public void printTicket() {
        if (balance >= price) {
            System.out.println("##################");
            System.out.println("# Destination: " + destination);
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            total += balance;

            balance -= price;
            System.out.println("You have " + balance + " left.");
        } else {
            System.out.println("You haven't enough money. You have only " + balance + " cents.");
        }
    }

    public void empty() {
        balance = 0;
    }

    public void cashBack() {
        if (balance > 0) {
            System.out.println("You received " + balance + " cents back.");
        } else {
            System.out.println("You have no money left.");
        }
    }

    public String showPrice() {
        switch (destination) {
            case 8633 -> price = 100;
            case 8630 -> price = 90;
            case 1000 -> price = 300;
            case 1212 -> price = 190;
        }

        switch (mode) {
            case "f" -> price += price / 2;
            case "hp" -> price /= 2;
            case "b" -> price *= 2;
        }

        return "The price of a ticket is " + price + " cents";
    }
}
