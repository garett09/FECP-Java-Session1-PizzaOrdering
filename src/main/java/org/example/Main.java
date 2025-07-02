package org.example;
import java.util.*;

public class Main {
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity ){
    if (quantity>0) {
        pizzas.add(pizzaType);
        quantities.add(quantity);
        System.out.println("Order added successfully");
    }else {
        System.out.println("Quantity must not be a negative number");
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities,int index, int newQuantity ){
        if(index<0 || index>=quantities.size()){
            System.out.println("Invalid order number.");
            return;
        }

        if(newQuantity >0 ){
            quantities.set(index, newQuantity);
            System.out.println("New quantity added");
        } else {
            System.out.println("Quantity must not be a negative number");
        }
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if(index>=0 && index< pizzas.size()){
            pizzas.remove(index);
            quantities.remove(index);
            System.out.print("Order removed successfully");
        } else {
            System.out.print("Invalid Order Number");
        }
    }

    public static void printOrders (ArrayList<String> pizzas, ArrayList<Integer> quantities){
        System.out.println("\n--- Current Orders ---");
        if(pizzas.isEmpty()){
            System.out.println("No orders yet");
        } else{
            for (int i =0; i < pizzas.size(); i++){
                System.out.println((i + 1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner input =  new Scanner (System.in);
        ArrayList<String> pizzas =  new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        int userChoice = 0;

        System.out.println("------Welcome to The Buni's Pizza Parlor------");

        while(userChoice!=5){
            System.out.println("\n1. Add Order");
            System.out.println("2. Update Order");
            System.out.println("3. Remove an Order");
            System.out.println("4. List all Current Orders");
            System.out.println("5. Exit");

            while(!input.hasNextInt()) {
                System.out.println("Invalid Input. Please input between 1 and 5");
                input.next();
                System.out.println("Choose your option:");
            }
            userChoice = input.nextInt();
            input.nextLine();

            switch(userChoice){
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = input.nextLine();
                    System.out.print("Quantity: ");
                    while(!input.hasNextInt()){
                        System.out.println("Invalid Input. Please input a whole number");
                        input.next();
                        System.out.print("Quantity: ");
                    }
                    int quantity = input.nextInt();
                    addOrder(pizzas,quantities,pizzaType,quantity);
                    break;
                case 2:
                    if(pizzas.isEmpty()){
                        System.out.print("No orders to update");
                        break;
                    }
                    System.out.print("Order number to update:");
                    int updateNumberOrder = input.nextInt();
                    int indexUpdate = updateNumberOrder - 1;

                    if(indexUpdate >=0 && indexUpdate < pizzas.size()){
                        System.out.print("New quantity");
                        int newQuantity = input.nextInt();
                        input.nextLine();
                        updateOrder(quantities,indexUpdate, newQuantity);
                    } else{
                        System.out.println("Invalid Order Number");
                    } break;
                case 3:
                    if (pizzas.isEmpty()){
                        System.out.print("No orders to remove");
                        break;
                    }
                    System.out.print("Order number to remove: ");
                    int orderNumberRemove =  input.nextInt();
                    int removeIndex = orderNumberRemove - 1;
                    removeOrder(pizzas,quantities,removeIndex);
                    break;
                case 4:
                    printOrders(pizzas,quantities);
                    break;
                case 5:
                    System.out.print("---Thank you for ordering at The Buni's Pizza Parlor---");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
                    break;
            }

            }
        input.close();
        }


    }
