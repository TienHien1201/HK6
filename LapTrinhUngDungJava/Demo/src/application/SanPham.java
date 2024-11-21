	package application;

import java.sql.Date;

public class SanPham {
	    private int id;
	    private String ten;
	    private double gia;
	    private Date ngayTao;

	    // Constructor
	    public SanPham(int id, String ten, double gia, Date ngayTao) {
	        this.id = id;
	        this.ten = ten;
	        this.gia = gia;
	        this.ngayTao = ngayTao;
	    }

	    // Getters and setters
	    public int getId() {
	        return id;
	    }

	    public String getTen() {
	        return ten;
	    }

	    public double getGia() {
	        return gia;
	    }

	    public Date getNgayTao() {
	        return ngayTao;
	    }
	}
