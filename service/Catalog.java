package com.shopsphere.service;

import com.shopsphere.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {
    private final Map<Integer, Product> products = new LinkedHashMap<>();

    public Catalog() {
        add(new Product(1, "Wireless Mouse", "Electronics", 599.00, 25));
        add(new Product(2, "Mechanical Keyboard", "Electronics", 2499.00, 10));
        add(new Product(3, "USB-C Cable", "Electronics", 299.00, 50));
        add(new Product(4, "Notebook (A4)", "Stationery", 120.00, 100));
        add(new Product(5, "Gel Pen Pack", "Stationery", 90.00, 80));
        add(new Product(6, "Backpack", "Accessories", 1299.00, 15));
        add(new Product(7, "Water Bottle", "Accessories", 349.00, 40));
    }

    public void add(Product p) {
        products.put(p.getId(), p);
    }

    public Product findById(int id) {
        return products.get(id);
    }

    public List<Product> all() {
        return new ArrayList<>(products.values());
    }

    public List<Product> search(String keyword) {
        String k = keyword.toLowerCase();
        return products.values().stream()
                .filter(p -> p.getName().toLowerCase().contains(k)
                        || p.getCategory().toLowerCase().contains(k))
                .collect(Collectors.toList());
    }
}
