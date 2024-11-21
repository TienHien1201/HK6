package com.example.ecommerceshopping.Model;

public class MenuItem {
    private int id;
    private String name;
    private int price;
    private byte[] image;

    public MenuItem(int id, String name, int price, byte[] image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }
}
