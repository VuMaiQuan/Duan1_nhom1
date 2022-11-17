select * from nguoidung
select * from taikhoan
INSERT INTO NguoiDung
                  (ma, hoTen, gioiTinh, ngaySinh, diaChi, email, sdt, image, chucVu, createdDate, updatedDate, deleted)
VALUES ('nd1',N'Trương Duy Hưng',0,'10/3/2002','Yên sơn - Tuyên Quang','hungtd@gmail.com','0943452343','anhList1.png',1,cast(getdate() as date),null,0),
('nd2',N'Vũ Mai Quân',0,'10/3/2003','Thanh Hóa','quan@gmail.com','0933452343','anhList2.png',0,cast(getdate() as date),null,0)

INSERT INTO TaiKhoan
                  (ma, idNguoiDung, userName, passWord, createdDate, updatedDate, deleted)
VALUES ('tk1','0271A2C2-995B-4028-9F41-07E22DF73EA9','admin','123',cast(getdate() as date),null,0),
('tk2','FB51AC55-5B63-4D5E-A334-7F04CEC1E4B0','quan','123',cast(getdate() as date),null,0)




select * from nguoidung
select * from taikhoan




