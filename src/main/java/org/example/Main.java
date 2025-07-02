package org.example;
import java.util.*;

public class Main {

    private static final ArrayList<String> pizzas = new ArrayList<>();
    private static final ArrayList<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Welcome to the Pizza Palace! === ");
        System.out.println("1. Add Order \n2. Update Order \n3. Remove Order \n4. View Orders \n5. Exit");

        // loop for user input
        while (true) {
            System.out.print("\nEnter your Chosen Option: ");
            int userChoice;
            try{
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("> [ERR: Invalid Option]");
                continue;
            }

            switch (userChoice) {
                case 1:
                    //adding orders
                    System.out.println("\n----- Adding Your Order -----");

                    System.out.print("Enter Pizza Type: ");
                    String pizzaType = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    //input validation for quantity
                    int quantity;
                    try{
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch(NumberFormatException e){
                        System.out.println("\n> [ERR: Invalid Quantity]");
                        break;
                    }

                    addOrder(pizzas, quantities, pizzaType, quantity);

                    break;
                case 2:
                    // updating orders
                    System.out.println("----- Update your Order -----");
                    printOrders(pizzas, quantities);

                    System.out.print("\nEnter Order Number to Update: ");
                    // validation input for chosen index
                    int updateIndex;
                    try{
                        updateIndex = Integer.parseInt(scanner.nextLine())-1;
                    }catch(NumberFormatException e){
                        System.out.println("> [ERR: Invalid Order Number Input]");
                        break;
                    }

                    System.out.print("Enter New Quantity of Order #"+ (updateIndex+1) +": ");
                    int newQuantity;
                    // validation for new quantity
                    try{
                        newQuantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.print("> [ERR: Invalid New Quantity Input]");
                        break;
                    }

                    updateOrder(quantities, updateIndex, newQuantity);

                    break;
                case 3:
                    // removing orders
                    System.out.println("----- Remove an Order -----");
                    printOrders(pizzas, quantities);

                    System.out.print("\nEnter Order Number to Remove: ");

                    int indexRemove;
                    // validation for order number input
                    try{
                        indexRemove = Integer.parseInt(scanner.nextLine())-1;
                    } catch (NumberFormatException e) {
                        System.out.println("> [ERR: Invalid Order Number Input]");
                        break;
                    }

                    removeOrder(pizzas, quantities, indexRemove);

                    break;
                case 4:
                    // viewing orders
                    System.out.println("\n----- Current Order List -----");
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    //Exit
                    System.out.println("\n=== Thank you for Ordering! ===");
                    return;
                default:
                    System.out.println("> [ERR: Invalid Option]");

            }
        }
    }

    // add order method
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity>0){
            pizzas.add(pizzaType);
            quantities.add(quantity);
            System.out.println("\n> [Pizza Added to your Order]");
        } else {
            System.out.println("> [ERR: Quantity must be positive]");
        }
    }

    // update order method
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {

        // validates index range and newQuantity
        if(index >=0 && index< quantities.size() && newQuantity > 0){
            quantities.set(index, newQuantity);
            System.out.println("\n> [Order Updated!]");

        } else if(newQuantity <= 0 && index >=0 && index < quantities.size()){
            System.out.println("> [ERR: Quantity must be positive]");
        } else{
            System.out.println("> [ERR: Invalid Order Number]");

        }
    }

    // remove order method
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {

        //validate index range
        if(index>=0 && index < pizzas.size() && index < quantities.size()){
            pizzas.remove(index);
            quantities.remove(index);
            System.out.println("> [Removed Order #" + (index+1) + "]");
        }else{
            System.out.println("> [ERR: Invalid Order Number Input]");
        }

    }

    // print orders method
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        if(pizzas.isEmpty()){
            System.out.println("No Orders Made");
        }else{
            for(int i = 0; i < pizzas.size(); i++){
                System.out.println((i+1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
            }
        }
    }
}