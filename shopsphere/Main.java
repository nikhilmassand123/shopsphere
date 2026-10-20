package com.shopsphere;

import com.shopsphere.model.CartItem;
import com.shopsphere.model.Product;
import com.shopsphere.service.Cart;
import com.shopsphere.service.Catalog;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Catalog catalog = new Catalog();
    private static final Cart cart = new Cart();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to ShopSphere ===");
        boolean running = true;
        while (running) {
            printMenu();
            switch (readInt("Choose an option: ")) {
                case 1 -> listProducts(catalog.all());
                case 2 -> search();
                case 3 -> addToCart();
                case 4 -> viewCart();
                case 5 -> removeFromCart();
                case 6 -> checkout();
                case 0 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
        System.out.println("Thanks for visiting ShopSphere. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\n1. Browse products");
        System.out.println("2. Search products");
        System.out.println("3. Add to cart");
        System.out.println("4. View cart");
        System.out.println("5. Remove from cart");
        System.out.println("6. Checkout");
        System.out.println("0. Exit");
    }

    private static void listProducts(List<Product> list) {
        if (list.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        list.forEach(System.out::println);
    }

    private static void search() {
        System.out.print("Search keyword: ");
        listProducts(catalog.search(in.nextLine().trim()));
    }

    private static void addToCart() {
        int id = readInt("Product id: ");
        Product p = catalog.findById(id);
        if (p == null) {
            System.out.println("No such product.");
            return;
        }
        int qty = readInt("Quantity: ");
        try {
            cart.add(p, qty);
            System.out.println("Added " + qty + " x " + p.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        for (CartItem item : cart.getItems()) {
            System.out.println(item);
        }
        System.out.printf("TOTAL: Rs %.2f%n", cart.total());
    }

    private static void removeFromCart() {
        int id = readInt("Product id to remove: ");
        System.out.println(cart.remove(id) ? "Removed." : "Item not in cart.");
    }

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        viewCart();
        System.out.print("Confirm order? (y/n): ");
        if (in.nextLine().trim().equalsIgnoreCase("y")) {
            for (CartItem item : cart.getItems()) {
                item.getProduct().reduceStock(item.getQuantity());
            }
            cart.clear();
            System.out.println("Order placed. Thank you for shopping!");
        } else {
            System.out.println("Checkout cancelled.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}
