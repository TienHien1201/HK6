package com.example.listview;

public class SinhVien {
    private String ten;
    private int tuoi;
    private int anh; // ID của ảnh trong thư mục drawable

    // Constructor
    public SinhVien(String ten, int tuoi, int anh) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.anh = anh;
    }

    // Getters và Setters
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
