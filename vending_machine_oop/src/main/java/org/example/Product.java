package org.example;

public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }

    // 재고 감소
    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        }
    }
}
