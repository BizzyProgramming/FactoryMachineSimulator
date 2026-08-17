package bbrown2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MachineOperator {
    private List<Order> orders = new ArrayList<>();
    private Order currentOrder;
    private Scanner scan = new Scanner(System.in);
    private boolean machineWorking = true;
    private int partsMade = 0;
    private int breakdownThreshold;
    private Random random = new Random();

    public MachineOperator() {
        orders.add(new Order(1, 2000, 5.00));
        orders.add(new Order(2, 1500, 4.50));
        orders.add(new Order(3, 3000, 6.75));
    }

    public void createOrder() {
        System.out.println("\n📦 Creating a New Order:");
        try {
            System.out.print("Enter Order Number: ");
            int orderNumber = Integer.parseInt(scan.nextLine());

            System.out.print("Enter Quantity: ");
            int quantity = Integer.parseInt(scan.nextLine());

            System.out.print("Enter Price per Piece: ");
            double price = Double.parseDouble(scan.nextLine());

            Order newOrder = new Order(orderNumber, quantity, price);
            orders.add(newOrder);
            System.out.println("\n✅ Order Created: " + newOrder);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter numbers correctly.");
        }
    }

    public void startOrder(int index) {
        if (index < 0 || index >= orders.size()) {
            System.out.println("❌ Invalid order index.");
            return;
        }
        currentOrder = orders.get(index);
        partsMade = 0;
        breakdownThreshold = random.nextInt(800) + 1; // Random breakdown between 1-800 parts

        System.out.println("\n🚀 Machine started for Order: " + currentOrder);
        machineGo();
    }

    public void machineGo() {
        if (!machineWorking) {
            System.out.println("\n⚠️ The machine is broken. Press 4 to fix it.");
            return;
        }

        System.out.println("\n⚙️ Machine is now running...");

        while (partsMade < currentOrder.getQuantity()) {
            // Simulate part being made
            partsMade++;
            System.out.println(partsMade + " parts made...");

            // Check if the machine should break down
            if (partsMade % breakdownThreshold == 0) {  // Breakdowns occur multiple times
                System.out.println("\n🚨 Machine has broken down after " + partsMade + " parts! Press 4 to fix it.");
                machineWorking = false;
                return;  // Exit loop until user fixes machine
            }

            // Simulate machine speed (0.5 seconds per part)
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n✅ Order " + currentOrder.getOrderNumber() + " is COMPLETE! 🎉");
    }

    public void fixMachine() {
        System.out.println("\n🔧 Repairing machine...");
        int repairTime = random.nextInt(5) + 1;
        try {
            Thread.sleep(repairTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        machineWorking = true;
        breakdownThreshold = random.nextInt(800) + 1; // Set new breakdown point after fixing
        System.out.println("\n🛠️ Machine has been fixed in " + repairTime + " seconds! It may break down again at part " + (partsMade + breakdownThreshold) + ".");
        
        // Continue production
        machineGo();
    }

    public void listOrders() {
        System.out.println("\n📜 Available Orders:");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i));
        }
    }

    public void promptNextAction() {
        while (true) {
            System.out.println("\nWhat would you like to do next?");
            System.out.println("1 - Start another order");
            System.out.println("2 - Create a new order");
            System.out.println("3 - Exit");

            try {
                int choice = Integer.parseInt(scan.nextLine());

                if (choice == 1) {
                    listOrders();
                    System.out.println("Enter order number to start:");
                    int orderIndex = Integer.parseInt(scan.nextLine()) - 1;
                    startOrder(orderIndex);
                    break;
                } else if (choice == 2) {
                    createOrder();
                    listOrders();
                } else if (choice == 3) {
                    System.out.println("\nGoodbye! 👋");
                    System.exit(0);
                } else {
                    System.out.println("❌ Invalid input. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
            }
        }
    }

    public void operateMachine() {
        while (true) {
            System.out.println("\nEnter a command:");
            System.out.println("1 - List Orders");
            System.out.println("2 - Start an Order");
            System.out.println("3 - Create a New Order");
            System.out.println("4 - Fix Machine (if broken)");
            System.out.println("5 - Exit");

            try {
                int choice = Integer.parseInt(scan.nextLine());

                if (choice == 1) {
                    listOrders();
                } else if (choice == 2) {
                    System.out.println("Enter order number to start:");
                    int orderIndex = Integer.parseInt(scan.nextLine()) - 1;
                    startOrder(orderIndex);
                } else if (choice == 3) {
                    createOrder();
                } else if (choice == 4) {
                    fixMachine();
                } else if (choice == 5) {
                    System.out.println("\nGoodbye! 👋");
                    break;
                } else {
                    System.out.println("❌ Invalid input. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
            }
        }
    }
}
