CREATE DATABASE TEST
USE TEST

CREATE TABLE TaiKhoan (
    MaTaiKhoan INT PRIMARY KEY IDENTITY(1,1),  -- Mã định danh duy nhất cho tài khoản, tự động tăng
    TenDangNhap NVARCHAR(50) NOT NULL,  -- Tên đăng nhập
    MatKhau NVARCHAR(255) NOT NULL,  -- Mật khẩu (được mã hóa)
    PhanQuyen NVARCHAR(20) CHECK (PhanQuyen IN ('Admin', 'Nhân viên')) NOT NULL,  -- Phân quyền (Admin hoặc Nhân viên)
    TenDayDu NVARCHAR(100) NOT NULL,  -- Tên đầy đủ của người dùng
    NgayTao DATETIME DEFAULT GETDATE()  -- Ngày tạo tài khoản, giá trị mặc định là thời gian hiện tại
);

CREATE TABLE ThucDon (
    MaMon INT PRIMARY KEY IDENTITY(1,1),  -- Mã định danh món, tự động tăng
    TenMon NVARCHAR(100) NOT NULL,  -- Tên món
    LoaiMon NVARCHAR(50),  -- Loại món (thức uống, đồ ăn)
    Gia DECIMAL(10, 2) NOT NULL,  -- Giá của món
    ConBan BIT DEFAULT 1,  -- Trạng thái còn bán (TRUE) hoặc hết hàng (FALSE), mặc định là còn bán
    Hinh VARBINARY(MAX) -- Cột ảnh (lưu trữ dữ liệu nhị phân)
);

CREATE TABLE NguyenLieu (
    MaNguyenLieu INT PRIMARY KEY IDENTITY(1,1),  -- Mã định danh nguyên liệu, tự động tăng
    MaMon INT FOREIGN KEY REFERENCES ThucDon(MaMon),  -- Mã món (khóa ngoại)
    TenNguyenLieu NVARCHAR(100) NOT NULL,  -- Tên nguyên liệu
    SoLuong DECIMAL(10, 2) NOT NULL,  -- Số lượng nguyên liệu trong kho
    DonVi NVARCHAR(50) NOT NULL,  -- Đơn vị tính (kg, lít, gói,...)
    NgayCapNhat DATETIME DEFAULT GETDATE(),  -- Ngày cập nhật gần nhất số lượng, mặc định là thời gian hiện tại
    Hinh VARBINARY(MAX) -- Cột ảnh (lưu trữ dữ liệu nhị phân)
);

CREATE TABLE DonHang (
    MaDonHang INT PRIMARY KEY IDENTITY(1,1),  -- Mã định danh đơn hàng, tự động tăng
    MaTaiKhoan INT FOREIGN KEY REFERENCES TaiKhoan(MaTaiKhoan) ON DELETE CASCADE,  -- Mã tài khoản người tạo đơn hàng (khóa ngoại)
    TongGia DECIMAL(10, 2) NOT NULL,  -- Tổng giá trị đơn hàng
    NgayDat DATETIME DEFAULT GETDATE(),  -- Ngày giờ tạo đơn hàng, mặc định là thời gian hiện tại
    TrangThai NVARCHAR(50) CHECK (TrangThai IN (N'Đang chờ', N'Đã thanh toán', N'Đã hủy')) NOT NULL  -- Trạng thái đơn hàng (Đang chờ, Đã thanh toán, Đã hủy)
);

CREATE TABLE ChiTietDonHang (
    MaChiTietDonHang INT PRIMARY KEY IDENTITY(1,1),  -- Mã định danh chi tiết đơn hàng, tự động tăng
    MaDonHang INT FOREIGN KEY REFERENCES DonHang(MaDonHang) ON DELETE CASCADE,  -- Mã định danh đơn hàng (khóa ngoại)
    MaMon INT FOREIGN KEY REFERENCES ThucDon(MaMon) ON DELETE CASCADE,  -- Mã định danh món trong đơn hàng (khóa ngoại)
    SoLuong INT NOT NULL,  -- Số lượng món
    NgayDat DATETIME DEFAULT GETDATE(),
    Gia DECIMAL(10, 2) NOT NULL  -- Giá của món tại thời điểm bán
);

CREATE TABLE DoanhThu (
    MaBaoCao INT PRIMARY KEY IDENTITY(1,1),  -- Mã định danh báo cáo, tự động tăng
    MaChiTietDonHang INT FOREIGN KEY REFERENCES ChiTietDonHang(MaChiTietDonHang),
    NgayThongKe DATE NOT NULL,  -- Ngày thống kê
    TongDoanhThu DECIMAL(10, 2) NOT NULL,  -- Tổng doanh thu trong ngày
    TongNguyenLieuSuDung DECIMAL(10, 2) NOT NULL,  -- Tổng lượng nguyên liệu đã tiêu thụ
    MonBanChay NVARCHAR(100)  -- Món bán chạy nhất
);

INSERT INTO TaiKhoan (TenDangNhap, MatKhau, PhanQuyen, TenDayDu)
VALUES ('admin', HASHBYTES('SHA2_256', 'adminpass'), 'Admin', N'Nguyễn Văn A'),
       ('staff1', HASHBYTES('SHA2_256', 'staffpass1'), 'Nhân viên', N'Trần Thị B'),
       ('staff2', HASHBYTES('SHA2_256', 'staffpass2'), 'Nhân viên', N'Lê Văn C');

INSERT INTO ThucDon (TenMon, LoaiMon, Gia, ConBan, Hinh)
VALUES (N'Bánh mì', N'Đồ ăn', 20000, 1, NULL),
       (N'Cà phê sữa', N'Thức uống', 25000, 1, NULL),
       (N'Nước cam', N'Thức uống', 30000, 1, NULL),
       (N'Phở bò', N'Đồ ăn', 50000, 1, NULL);

INSERT INTO NguyenLieu (MaMon, TenNguyenLieu, SoLuong, DonVi, Hinh)
VALUES (1, N'Bột mì', 50, 'kg', NULL),
       (1, N'Thịt bò', 30, 'kg', NULL),
       (2, N'Cà phê', 10, 'kg', NULL),
       (2, N'Sữa tươi', 20, 'lít', NULL),
       (3, N'Cam tươi', 100, 'quả', NULL),
       (4, N'Bánh phở', 40, 'kg', NULL),    
       (4, N'Thịt bò', 30, 'kg', NULL);

INSERT INTO DonHang (MaTaiKhoan, TongGia, TrangThai)
VALUES (1, 70000, N'Đã thanh toán'),
       (2, 50000, N'Đang chờ'),
       (3, 30000, N'Đã hủy');

INSERT INTO ChiTietDonHang (MaDonHang, MaMon, SoLuong, Gia)
VALUES (1, 1, 2, 20000),  -- 2 Bánh mì, giá 20000 mỗi cái
       (1, 2, 1, 25000),  -- 1 Cà phê sữa, giá 25000
       (2, 3, 1, 30000),  -- 1 Nước cam, giá 30000
       (3, 4, 1, 50000);  -- 1 Phở bò, giá 50000

INSERT INTO DoanhThu (MaChiTietDonHang, NgayThongKe, TongDoanhThu, TongNguyenLieuSuDung, MonBanChay)
VALUES (1, '2024-10-19', 70000, 80, N'Bánh mì'),
       (2, '2024-10-18', 50000, 50, N'Phở bò'),
       (3, '2024-10-17', 30000, 30, N'Nước cam');

		   ALTER TABLE DonHang
	ADD CONSTRAINT CK__DonHang__TrangTh__14270015
	CHECK (TrangThai IN (N'Đang chờ', N'Đã thanh toán', N'Đã hủy'));

	   ALTER TABLE DonHang DROP CONSTRAINT CK__DonHang__TrangTh__14270015;

	   select TenDangNhap,MatKhau,PhanQuyen,TenDayDu,NgayTao from TaiKhoan
	   INSERT INTO TaiKhoan (TenDangNhap,MatKhau,PhanQuyen,TenDayDu) VALUES ('admin', HASHBYTES('SHA2_256', 'adminpass'), 'Admin', 'Nguyễn Văn phuc');

	   SELECT  TD.TenMon,CTDH.SoLuong,CTDH.Gia,(CTDH.SoLuong * CTDH.Gia) AS TongGia,
	   TK.TenDayDu AS TenNguoiNhap,DH.NgayDat 
	   FROM ChiTietDonHang CTDH JOIN ThucDon TD 
	   ON CTDH.MaMon = TD.MaMon JOIN DonHang DH 
	   ON CTDH.MaDonHang = DH.MaDonHang JOIN TaiKhoan TK 
	   ON DH.MaTaiKhoan = TK.MaTaiKhoan;

	   DELETE FROM ChiTietDonHang
		WHERE MaChiTietDonHang = 1;

		SELECT 
    DH.NgayDat,
    SUM(CTDH.Gia * CTDH.SoLuong) AS TongDoanhThu,  -- Tổng doanh thu
    SUM(NL.SoLuong) AS TongNguyenLieuSuDung,  -- Tổng nguyên liệu đã sử dụng
    (SELECT TOP 1
        TD.TenMon 
     FROM 
        ChiTietDonHang CTDH
     JOIN 
        ThucDon TD ON CTDH.MaMon = TD.MaMon
     GROUP BY 
        TD.TenMon
     ORDER BY 
        SUM(CTDH.SoLuong) DESC) AS MonBanChay  -- Món bán chạy nhất
FROM 
    DonHang DH
JOIN 
    ChiTietDonHang CTDH ON DH.MaDonHang = CTDH.MaDonHang
LEFT JOIN 
    NguyenLieu NL ON CTDH.MaMon = NL.MaMon  -- Giả sử bạn cần thông tin nguyên liệu từ bảng NguyenLieu
GROUP BY 
    DH.NgayDat;

	SELECT CONVERT(varchar, GETDATE(), 102) AS FormattedDate;

	SELECT SUM(DH.TongGia) AS tongGia, CTDH.SoLuong AS Soluong
	FROM DonHang DH
	JOIN ChiTietDonHang CTDH ON DH.MaDonHang = CTDH.MaDonHang
	WHERE CONVERT(varchar, DH.Ngaydat, 102) = '2024.10.24'
	GROUP BY CTDH.SoLuong;



