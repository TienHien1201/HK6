package com.example.ecommerceshopping.Model;
public class UserSession {
    private static UserSession instance;
    private int userId;
    private String username;
    private String role;

    private UserSession() {}

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    // Lưu thông tin user vào session
    public void setUser(int userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    // Lấy thông tin user từ session
    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
