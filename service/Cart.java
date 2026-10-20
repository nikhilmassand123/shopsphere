package com.shopsphere.service;

import com.shopsphere.model.CartItem;
import com.shopsphere.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void add(Product product, int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive");
        int already = items.containsKey(product.getId()) ? items.get(product.getId()).getQuantity() : 0;
        if (already + qty > product.getStock()) {
            throw new IllegalArgumentException("Only " + product.getStock() + " in stock for " + product.getName());
        }
        if (items.containsKey(product.getId())) {
            items.get(product.getId()).addQuantity(qty);
        } else {
            items.put(product.getId(), new CartItem(product, qty));
        }
    }

    public boolean remove(int productId) {
        return items.remove(productId) != null;
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double total() {
        return items.values().stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public void clear() {
        items.clear();
    }
}
