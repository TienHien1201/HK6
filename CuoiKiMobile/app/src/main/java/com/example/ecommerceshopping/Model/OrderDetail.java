package com.example.ecommerceshopping.Model;
public class OrderDetail {
    private int orderDetailId;
    private int userId;
    private String productName;
    private double totalPrice;
    private String status;
    private byte[] image; // Thêm trường image

    public OrderDetail(int orderDetailId, int userId, String productName, double totalPrice, String status, byte[] image) {
        this.orderDetailId = orderDetailId;
        this.userId = userId;
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.image = image;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter và Setter cho các thuộc tính
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    // Các getter và setter khác...
}
