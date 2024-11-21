package com.example.ecommerceshopping.Model;
// Lớp CartItem để chứa dữ liệu của mỗi mục trong bảng cart
public class CartItem {
    private int cartId;
    private int menuId;
    private String name;
    private int price;
    private byte[] image;
    private int quality;

        public CartItem(int cartId, int menuId, String name, int price, byte[] image, int quality) {
        this.cartId = cartId;
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quality = quality;
    }

    // Getter và Setter cho các thuộc tính
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
