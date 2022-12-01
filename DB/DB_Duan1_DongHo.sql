create database DUAN1_DONGHO
go
use DUAN1_DONGHO
go

-- danh muc
CREATE TABLE DanhMuc(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
createdDate date,
updatedDate date,
deleted bit default 0
)

go
-- mau sac
CREATE TABLE MauSac(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
createdDate date ,
updatedDate date,
deleted bit default 0
)

go
-- hang
CREATE TABLE Hang(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
createdDate date ,
updatedDate date,
deleted bit default 0
)
go
-- Noi sx
CREATE TABLE NoiSX(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
createdDate date ,
updatedDate date,
deleted bit default 0
)

go
-- san pham
CREATE TABLE SanPham(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
createdDate date ,
updatedDate date,
deleted bit default 0
)
go
-- mat kinh
CREATE TABLE MatKinh(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30),
createdDate date ,
updatedDate date,
deleted bit default 0
)
go
--ctsp
create table CTSP(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma varchar(10) unique,
idSP uniqueidentifier ,
idNoiSX uniqueidentifier ,
idHang uniqueidentifier ,
idMauSac uniqueidentifier ,
idMatKinh uniqueidentifier ,
idDanhMuc uniqueidentifier ,
image nvarchar(50) ,
namBH int default 0,
moTa nvarchar(150) ,
donGia money default 0,
soLuong int ,
createdDate date ,
updatedDate date ,
deleted bit default 0 
)

GO
-- HDCT
CREATE TABLE HDCT(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
idCTSP uniqueidentifier ,
idHD uniqueidentifier ,
soLuong int ,
donGia money default 0,
trangThai int default 0,
createdDate date ,
updatedDate date ,
deleted bit default 0 ,
)

GO
--hoadon
create table HoaDon(
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ma varchar(50)  unique,
	idND uniqueidentifier  ,
	idKH uniqueidentifier ,
	idVoucher uniqueidentifier ,
	tongTien money  ,
	createdDate date  ,
	updatedDate date ,
	trangThai int  
)

GO
--khach hang
CREATE TABLE KhachHang(
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ma varchar(10)  unique,
	hoTen nvarchar(30)  ,
	gioiTinh bit  ,
	ngaySinh date ,
	email varchar(30) ,
	sdt varchar(10) ,
	diaChi nvarchar(50) ,
	createdDate date  ,
	updatedDate date ,
	deleted bit default 0
)
go
--nguoi dung
CREATE TABLE NguoiDung(
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ma varchar(10) unique ,
	hoTen nvarchar(30)  ,
	gioiTinh bit ,
	ngaySinh date ,
	diaChi nvarchar(50) ,
	email varchar(30) ,
	sdt varchar(10) ,
	image nvarchar(50) ,
	chucVu bit  ,
	createdDate date  ,
	updatedDate date ,
	deleted bit default 0
)

go
--tai khoan
CREATE TABLE TaiKhoan(
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ma varchar(10)  unique,
	idNguoiDung uniqueidentifier  ,
	userName varchar(20)  ,
	passWord nvarchar(100)  ,
	createdDate date  ,
	updatedDate date ,
	deleted bit default 0
)
go
--voucher
CREATE TABLE Voucher(
	id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ma varchar(10) unique ,
	ten nvarchar(30)  ,
	giamGia float  default 0,
	ngayBD date ,
	ngayKT date ,
	createdDate date  ,
	updatedDate date ,
	deleted bit default 0
)
go

--TẠO QUAN HỆ GIỮA CÁC BẢNG
--ctsp - thuộc tính
ALTER TABLE CTSP ADD FOREIGN KEY (idSP) REFERENCES SanPham(id)
ALTER TABLE CTSP ADD FOREIGN KEY (idNoiSX) REFERENCES NoiSX(id)
ALTER TABLE CTSP ADD FOREIGN KEY (idHang) REFERENCES Hang(id)
ALTER TABLE CTSP ADD FOREIGN KEY (idMauSac) REFERENCES MauSac(id)
ALTER TABLE CTSP ADD FOREIGN KEY (idMatKinh) REFERENCES MatKinh(id)
ALTER TABLE CTSP ADD FOREIGN KEY (idDanhMuc) REFERENCES DanhMuc(id)




--hdct - ctsp
ALTER TABLE HDCT ADD FOREIGN KEY (idCTSP) REFERENCES CTSP(id)
ALTER TABLE HDCT ADD FOREIGN KEY (idHD) REFERENCES HoaDon(id)

--hóa đơn 
ALTER TABLE HoaDon ADD FOREIGN KEY (idND) REFERENCES NguoiDung(id)
ALTER TABLE HoaDon ADD FOREIGN KEY (idKH) REFERENCES KhachHang(id)
ALTER TABLE HoaDon ADD FOREIGN KEY (idVoucher) REFERENCES Voucher(id)

-- tài khoản
ALTER TABLE TaiKhoan ADD FOREIGN KEY (idNguoiDung) REFERENCES NguoiDung(id)




