
INSERT INTO NguoiDung
                  (id,ma, hoTen, gioiTinh, ngaySinh, diaChi, email, sdt, image, chucVu, createdDate, updatedDate, deleted)
VALUES ('F4144409-CCF5-4995-9D4D-887A221F955D','nd1',N'Trương Duy Hưng',0,'10/3/2002','Yên sơn - Tuyên Quang','hungtd@gmail.com','0943452343','elonMusk.jpg',1,'10/8/2022','10/8/2022',0),
	('AD10F102-62D2-470F-9937-C6CBD468EC96','nd2',N'Vũ Mai Quân',0,'10/3/2003','Thanh Hóa','quan@gmail.com','0933452343','user87.png',0,'10/8/2022','10/8/2022',0),
	('CE7286F1-83E8-4028-9507-30C4E7359F0A','nd3',N'Trần duy',0,'10/3/2004','Nghệ an','duypro@gmail.com','0933452343','question87.png',0,'10/8/2022','10/8/2022',0)

INSERT INTO TaiKhoan
                  (ma, idNguoiDung, userName, passWord, createdDate, updatedDate, deleted)
VALUES ('tk1','F4144409-CCF5-4995-9D4D-887A221F955D','admin','123','10/8/2022','10/8/2022',0),
	('tk2','AD10F102-62D2-470F-9937-C6CBD468EC96','quan','123','10/8/2022','10/8/2022',0),
	('tk3','CE7286F1-83E8-4028-9507-30C4E7359F0A','duy','123','10/8/2022','10/8/2022',0)
	
INSERT INTO DanhMuc
                  (id,ma, ten, createdDate, updatedDate, deleted)
VALUES ('7907C782-60EF-4996-B195-51D28B29D63A','dm1','Nam','10/8/2022','10/8/2022',0),
	('BB62BE0D-7922-49B5-A764-7EACE91D71FD','dm2',N'Nữ','10/8/2022','10/8/2022',0),
	('C0FB5532-1205-4623-8769-B91F573E3301','dm3',N'Nam Nữ','10/8/2022','10/8/2022',0)

	INSERT INTO Hang
                  (id,ma, ten, createdDate, updatedDate, deleted)
VALUES ('E3AD0E43-0885-40A3-9B7A-580F2946CA82','apl1','Apple','11/8/2022','11/8/2022',0),
	('04FA6569-0321-4946-B5A1-9EA6B2820874','rl1','Rolex','11/8/2022','11/8/2022',0),
	('CE85802C-AB70-4728-A580-D8998E230952','HB1','Hublot','11/8/2022','11/8/2022',0)

	INSERT INTO Imei
                  (id,ma, ten, createdDate, updatedDate, deleted)
VALUES ('3DEB8910-67FE-42C2-A03C-1E70FF6E2E35','im1',N'512432123','11/8/2022','11/8/2022',0),
		('F26FB2F1-E942-456D-801F-89D4DCE7B410','aa1',N'111765278','11/8/2022','11/8/2022',0),
		('4A97DF8C-A22F-4C0E-A069-A904D37B9BF8','zz3',N'343453452','10/8/2022','10/8/2022',0)

		INSERT INTO SanPham
                  (id,ma, ten, createdDate, updatedDate, deleted)
VALUES ('17AE886E-F066-4EEC-A204-2454AD772206','im1',N'đồng hồ cơ','11/8/2022','11/8/2022',0),
('D35F32BD-BFFB-42A5-A471-4B340960BCB0','ia2',N'đồng hồ thông minh','11/8/2022','11/8/2022',0),
('2479AFAB-07E4-48D8-AF07-875C888FB7C4','ib3',N'đồng hồ smart','11/8/2022','11/8/2022',0)

INSERT INTO MatKinh
                  (id,ma, ten, createdDate, updatedDate, deleted)
VALUES ('3ECA6E0C-888A-4888-9AD7-82D7CCCA94F5','s1','kính khoáng','10/8/2022','10/8/2022',0),
	('390E21CE-5B76-402F-906D-937B9DF9B10D','z33',N'kính hardlex','10/8/2022','10/8/2022',0),
	('DE34A303-D475-4506-BD0D-97131D49092A','fd66',N'kính sapphire','10/8/2022','10/8/2022',0)

	INSERT INTO MauSac
                  (id,ma, ten, createdDate, updatedDate, deleted)
VALUES ('BF5B2B71-3152-45F6-B70D-72D3B09E50CA','rr1',N'đỏ','10/8/2022','10/8/2022',0),
	('47D52C63-5031-49FE-9578-81AFAE5DE2C2','sd5',N'cam','10/8/2022','10/8/2022',0),
	('D2965781-34D4-40F7-9A4D-A6D1406B1BBD','dz7',N'vàng','10/8/2022','10/8/2022',0)


	INSERT INTO NoiSX
                  (id,ma, ten, createdDate, updatedDate, deleted)
VALUES ('4F746BEC-C514-4053-9031-0223A9AFE565','pp4',N'Thụy Điển','10/8/2022','10/8/2022',0),
	('ABCD49BF-9E91-40DF-ABE1-5FBF99769CBE','oo3',N'Mỹ','10/8/2022','10/8/2022',0),
	('C8B22FF0-1BC5-4B29-A3AE-E643AD83E2A7','dtt4',N'ý','10/8/2022','10/8/2022',0)SELECT ma, idSP, idNoiSX, idHang, idMauSac, idMatKinh, idDanhMuc, idImei, namBH, image, moTa, donGia, soLuong, createdDate, updatedDate, deleted

INSERT INTO CTSP
                  (id, ma, idSP, idNoiSX, idHang, idMauSac, idMatKinh, idDanhMuc, idImei, image, namBH, moTa, donGia, soLuong, createdDate, updatedDate, deleted)
VALUES ('4F746BEC-C514-4053-9031-0223A9AFE566','cts1',,,,,,,,,,,,,,,)



select * from ctsp
	select * from danhmuc
		select * from hang
	select * from imei
	select * from matkinh
	select * from sanpham
	select * from mausac
	select * from NoiSX
