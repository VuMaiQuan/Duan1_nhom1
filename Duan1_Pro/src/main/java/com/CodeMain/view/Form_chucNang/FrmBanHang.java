package com.CodeMain.view.Form_chucNang;

import com.CodeMain.Response.ViewCTSPReponse;
import com.CodeMain.Response.ViewHoaDonCTResponse;
import com.CodeMain.Response.ViewHoaDonResponse;
import com.CodeMain.Utilities.Validate;
import com.CodeMain.domainModel.ChiTietSP;
import com.CodeMain.domainModel.DanhMuc;
import com.CodeMain.domainModel.HoaDon;
import com.CodeMain.domainModel.HoaDonCT;
import com.CodeMain.domainModel.KhachHang;
import com.CodeMain.domainModel.MauSac;
import com.CodeMain.domainModel.NguoiDung;
import com.CodeMain.domainModel.Voucher;
import com.CodeMain.services.CTSPService;
import com.CodeMain.services.DanhMucService;
import com.CodeMain.services.HoaDonCTService;
import com.CodeMain.services.HoaDonService;
import com.CodeMain.services.KhachHangService;
import com.CodeMain.services.MauSacService;
import com.CodeMain.services.VoucherService;
import com.CodeMain.services.serviceImp.CTSPServiceImp;
import com.CodeMain.services.serviceImp.DanhMucServiceImp;
import com.CodeMain.services.serviceImp.HoaDonCTServiceImp;
import com.CodeMain.services.serviceImp.HoaDonServiceImp;
import com.CodeMain.services.serviceImp.KhachHangServiceImp;
import com.CodeMain.services.serviceImp.MauSacServiceImp;
import com.CodeMain.services.serviceImp.VoucherServiceImp;
import com.raven.main.Main;
//import RavenLogin.login.Login;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Utilities;

/**
 *
 * @author NhatAn
 */
public class FrmBanHang extends javax.swing.JPanel {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    DefaultTableModel DTMDSSP;
    DefaultTableModel DTMHoaDon;
    DefaultTableModel DTMGioHang;
    DefaultComboBoxModel dcbmDanhMuc;
    DefaultComboBoxModel dcbmMauSac;
    DefaultComboBoxModel dcbmVoucher;
    //
    Main m;
    CTSPService chiTietSPService;
    HoaDonService hoaDonService;
    HoaDonCTService hoaDonCTService;
    KhachHangService khachHangService;
    DanhMucService danhMucService;
    Validate validate;
    MauSacService msService;
    VoucherService vcService;

    //
//    List<ChiTietSP> _loadCTSP = new ArrayList<>();
//    List<HoaDon> _loadHd = new ArrayList<>();
    public HoaDon hoaDonCho = null;
    
    public FrmBanHang() {
        initComponents();
        m = new Main();
        khachHangService = new KhachHangServiceImp();
        chiTietSPService = new CTSPServiceImp();
        hoaDonService = new HoaDonServiceImp();
        hoaDonCTService = new HoaDonCTServiceImp();
        danhMucService = new DanhMucServiceImp();
        msService = new MauSacServiceImp();
        vcService = new VoucherServiceImp();
        validate = new Validate();
//
        DTMDSSP = (DefaultTableModel) tblDSCTSP.getModel();
        DTMGioHang = (DefaultTableModel) tblGioHang.getModel();
        DTMHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        dcbmMauSac = (DefaultComboBoxModel) cbomauSac.getModel();
        dcbmVoucher = (DefaultComboBoxModel) cboVoucher.getModel();
        dcbmDanhMuc = (DefaultComboBoxModel) cboLoaiDH.getModel();

        //
        setCbo();
        
        btnThanhToan.setEnabled(false);
        btnRemoveOne.setEnabled(false);

        //show tbl danh sách sản phẩm khi open form bán hàng
        loadTableChiTietSP(m.MainloadCTSP());
        loadTableHoaDon(m.MainloadHd());
        
    }
    
    public void setCbo() {
        dcbmDanhMuc.removeAllElements();
        for (DanhMuc x : danhMucService.getListAll()) {
            dcbmDanhMuc.addElement(x.getTen());
        }
        dcbmMauSac.removeAllElements();
        for (MauSac x : msService.getListAll()) {
            dcbmMauSac.addElement(x.getTen());
        }
        dcbmVoucher.removeAllElements();
        for (Voucher x : vcService.getListAll()) {
            dcbmVoucher.addElement(x.getMa());
        }
    }

    //
//bảng chi tiết sản phẩm
    public void loadTableChiTietSP(List<ViewCTSPReponse> list) {
        if (list == null) {
            DTMDSSP.setRowCount(0);
            JOptionPane.showMessageDialog(this, "List sản phảm rỗng");
        } else {
            DTMDSSP.setRowCount(0);
            for (ViewCTSPReponse x : list) {
                DTMDSSP.addRow(x.rowData());
            }
            setCbo();
        }
        
    }
// bảng hóa đơn

    public void cleanHD() {
        txtSDTKH.setText("");
        txtSDTKH.setText("");
        txtSearch.setText("");
        txtTienKhachDua.setText("");
        lblGiamGia.setText("");
        lblMaHD.setText("");
        txtThanhToan.setText("");
        lblTienThua.setText("");
        txtTongTien.setText("");
    }
    
    public void loadTableHoaDon(List<ViewHoaDonResponse> list) {
        if (list == null) {
            DTMHoaDon.setRowCount(0);
        } else {
            DTMHoaDon.setRowCount(0);
            for (var x : list) {
                if (x.getTrangThai() == 1) {
                    DTMHoaDon.addRow(x.rowData());
                }
            }
        }
        cleanHD();
    }
    
    public void loadTableHoaDonCTfromDB(List<ViewHoaDonCTResponse> list) {
        if (list == null) {
            DTMGioHang.setRowCount(0);
        } else {
            DTMGioHang.setRowCount(0);
            for (var x : list) {
                DTMGioHang.addRow(x.rowData());
            }
            tinhTienHd();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboLoaiDH = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSCTSP = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cbomauSac = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtSDTKH = new javax.swing.JTextField();
        btnChon = new javax.swing.JButton();
        btnThayDoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnHuyHD = new javax.swing.JButton();
        btnRefrest = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        chkApMaVoucher = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboVoucher = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnRemoveOne = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnRemoveOne1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " Hóa Đơn Chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Nhân viên tạo", "Khách hàng", "Trạng Thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Loại đồng hồ");

        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm sản phẩm");

        cboLoaiDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblDSCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Màu Sắc", "Đơn Giá", "Số Lượng", "Năm BH", "Mặt Kính", "Nơi Sản Xuất"
            }
        ));
        tblDSCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSCTSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSCTSP);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Màu sắc");

        cbomauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboLoaiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbomauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbomauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cboLoaiDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("SDT Khách Hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên khách hàng");

        txtTenKH.setEnabled(false);

        btnChon.setText("Chọn ");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChon)
                    .addComponent(btnThayDoi))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChon))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThayDoi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Thanh toán");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tiền thừa trả khách");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tiền khách đưa");

        btnHuyHD.setText("Hủy Hóa đơn");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        btnRefrest.setText("Làm mới");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHD.setText("Tạo");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã hóa đơn");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("VND");

        chkApMaVoucher.setText("Áp mã voucher");
        chkApMaVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkApMaVoucherActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("VND");

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("VND");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("voucher");

        cboVoucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVoucherActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("% giảm giá");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("VND");

        txtThanhToan.setEnabled(false);

        txtTongTien.setEnabled(false);
        txtTongTien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTongTienCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cboVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(chkApMaVoucher))
                            .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel18)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnRefrest)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel21)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnHuyHD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkApMaVoucher)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyHD)
                    .addComponent(btnRefrest))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Giỏ Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btnRemoveOne.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemoveOne.setText("xoá sản phẩm");
        btnRemoveOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOneActionPerformed(evt);
            }
        });

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblGioHang);

        btnRemoveOne1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRemoveOne1.setText("xoá tất cả");
        btnRemoveOne1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOne1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnRemoveOne)
                .addGap(87, 87, 87)
                .addComponent(btnRemoveOne1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveOne)
                    .addComponent(btnRemoveOne1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public List<ViewHoaDonResponse> getListHoaDonRes() {
        return hoaDonService.getListAll();
    }
    
    public List<ViewCTSPReponse> getListChiTietSPRes() {
        return chiTietSPService.getListAll();
    }
    
    public List<ViewHoaDonCTResponse> getListGioHangResByHoaDonCho() {
        hoaDonCho = hoaDonService.getOneObj(maHoaDon);
        List<ViewHoaDonCTResponse> list = new ArrayList<>();
        for (HoaDonCT x : hoaDonCho.getListHDCT()) {
            list.add(new ViewHoaDonCTResponse(x));
        }
        tinhTienHd();
        return list;
        
    }
    
    public void updateSLCTSPKhiBan(ChiTietSP ctsp) {
        try {
            chiTietSPService.update(ctsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getIndex(ChiTietSP ctsp) {
        List<HoaDonCT> list = hoaDonCho.getListHDCT();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getChiTietSP().getId().equals(ctsp.getId())) {
                return i;
            }
        }
        return -1;
    }
    
    public void saveHDCT(HoaDonCT hdct) {
        try {
            hoaDonCTService.save(hdct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateHDct(HoaDonCT hdct) {
        try {
            hoaDonCTService.update(hdct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void tblDSCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSCTSPMouseClicked
        int rowCL = tblDSCTSP.getSelectedRow();
        String ma = tblDSCTSP.getModel().getValueAt(rowCL, 0).toString();
        ChiTietSP ctsp = chiTietSPService.getOneObj(ma);
        
        double donGia = ctsp.getDonGia();
        
        if (hoaDonCho == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn");
            return;
        }
        String slText = JOptionPane.showInputDialog(this, "Nhập số lượng: ");
        
        if (slText != null && validate.validateNumber(slText)) {
            int sl = Integer.parseInt(slText);
            if (sl > ctsp.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "So luong vuot qua");
                return;
            }
            HoaDonCT hdct = new HoaDonCT(null, ctsp, hoaDonCho, sl, donGia, WIDTH, new Date(), null, false);
            
            if (hoaDonCho.getListHDCT() == null) {
                saveHDCT(hdct);
                loadTableHoaDonCTfromDB(getListGioHangResByHoaDonCho());
                ctsp.setSoLuong(ctsp.getSoLuong() - sl);
                updateSLCTSPKhiBan(ctsp);
                loadTableChiTietSP(getListChiTietSPRes());
            } else {
                //cehck trùng
                if (getIndex(ctsp) == -1) {
                    saveHDCT(hdct);
                    loadTableHoaDonCTfromDB(getListGioHangResByHoaDonCho());
                    ctsp.setSoLuong(ctsp.getSoLuong() - sl);
                    updateSLCTSPKhiBan(ctsp);
                    loadTableChiTietSP(getListChiTietSPRes());
                } else {
                    HoaDonCT hdcttemp = hoaDonCho.getListHDCT().get(getIndex(ctsp));
                    hdcttemp.setSoLuong(hdcttemp.getSoLuong() + sl);
                    updateHDct(hdcttemp);
                    loadTableHoaDonCTfromDB(getListGioHangResByHoaDonCho());
                    ctsp.setSoLuong(ctsp.getSoLuong() - sl);
                    updateSLCTSPKhiBan(ctsp);
                    loadTableChiTietSP(getListChiTietSPRes());
                }
            }
        }
    }//GEN-LAST:event_tblDSCTSPMouseClicked
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        btnThanhToan.setEnabled(true);
        int choiceTblHoaDon = tblHoaDon.getSelectedRow();
        maHoaDon = tblHoaDon.getValueAt(choiceTblHoaDon, 0).toString();
        hoaDonCho = hoaDonService.getOneObj(maHoaDon);
        lblMaHD.setText(hoaDonCho.getMa());
        if (hoaDonCho == null) {
            DTMGioHang.setRowCount(0);
        } else {
            loadTableHoaDonCTfromDB(getListGioHangResByHoaDonCho());
            tinhTienHd();
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked
    
    public void tinhTienHd() {
        double moneyHoaDon = 0;
        int rowCount = DTMGioHang.getRowCount();
        
        for (int i = 0; i < rowCount; i++) {
            double donGia = Double.parseDouble(tblGioHang.getModel().getValueAt(i, 3).toString());
            int sl = Integer.parseInt(tblGioHang.getModel().getValueAt(i, 2).toString());
            moneyHoaDon += donGia * sl;
        }
        txtTongTien.setText(String.format("%.1f", moneyHoaDon));
    }
    String maHoaDon = null;

    //HoaDon getHDChoXuat = null;
    public HoaDon getHD() {
        return hoaDonCho;
    }

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        // TODO add your handling code here:
        if (txtSearch.getText().trim().length() != 0) {
            loadTableChiTietSP(chiTietSPService.getListCustom(txtSearch.getText()));
        } else {
            loadTableChiTietSP(chiTietSPService.getListAll());
        }
    }//GEN-LAST:event_txtSearchCaretUpdate
    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
        int rowCL = -1;
        rowCL = tblGioHang.getSelectedRow();
        if (rowCL != -1) {
            btnRemoveOne.setEnabled(true);
        }

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnRemoveOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOneActionPerformed
        int rowCL = tblGioHang.getSelectedRow();
        HoaDonCT hdct = hoaDonCho.getListHDCT().get(rowCL);
        ChiTietSP ctsp = hdct.getChiTietSP();
        try {
            hoaDonCTService.delete(hdct.getId());
            loadTableHoaDonCTfromDB(getListGioHangResByHoaDonCho());
            ctsp.setSoLuong(ctsp.getSoLuong() + hdct.getSoLuong());
            updateSLCTSPKhiBan(ctsp);
            loadTableChiTietSP(getListChiTietSPRes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnRemoveOneActionPerformed

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        String sdt = txtSDTKH.getText();
        boolean checkkk = false;
        for (KhachHang x : khachHangService.getListAll()) {
            if (sdt.equals(x.getSdt())) {
                txtTenKH.setText(x.getHoTen());
                kh = x;
                checkkk = true;
            }
        }
        if (checkkk == false) {
            int dki = JOptionPane.showConfirmDialog(this, "Không tìm thấy khách hàng. bạn có muốn đăng kí mới");
            if (dki == 0) {
                //gọi màn đăng kí
            }
            kh = null;
        }
    }//GEN-LAST:event_btnChonActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        // TODO add your handling code here:
        HoaDon hdWait = hoaDonCho;
        hdWait.setTrangThai(2);
        try {
            hoaDonService.update(hdWait);
            loadTableHoaDon(getListHoaDonRes());
            cleanHD();
            DTMGioHang.setRowCount(0);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi hủy hóa đơn");
        }
    }//GEN-LAST:event_btnHuyHDActionPerformed
    public static HoaDon hoaDonXuat = null;
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (validate.validateNumber(txtTienKhachDua.getText()) != true || txtTienKhachDua.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Lỗi. hãy nhập lại số");
        } else if (Double.parseDouble(txtTienKhachDua.getText()) < Double.parseDouble(txtTongTien.getText())) {
            JOptionPane.showMessageDialog(this, "Tiền khách đưa phải lớn hơn hoặc = tổng tiền");
        } else {
            try {
                HoaDon hdct = hoaDonCho;
                hdct.setTongTien(Double.parseDouble(txtThanhToan.getText()));
                hdct.setTrangThai(0);
                hoaDonService.update(hoaDonCho);
                loadTableHoaDon(getListHoaDonRes());
                DTMGioHang.setRowCount(0);
                JOptionPane.showMessageDialog(this, "thanh toan thanh cong");
                int xuat = JOptionPane.showConfirmDialog(this, "Bạn muốn in hóa đơn", "In hóa đơn", 1);
                if (xuat == 0) {
                    hoaDonXuat = hoaDonCho;
                    new HoaDonXuat().setVisible(true);
                }
                cleanHD();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        int a = getListHoaDonRes().size();
        String mahd = "hd" + ++a;
        
        HoaDon hoadonTemp = new HoaDon(null, mahd, DangNhap.ndLogin, kh, null, 0, new Date(), null, 1);
        try {
            hoaDonService.save(hoadonTemp);
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn mới thành công");
            loadTableHoaDon(getListHoaDonRes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        
        if (txtTienKhachDua.getText().trim().length() != 0 && validate.validateNumber(txtTienKhachDua.getText())) {
            double tienKH = Double.parseDouble(txtTienKhachDua.getText());
            if (tienKH > Double.parseDouble(txtThanhToan.getText())) {
                double tt = tienKH - Double.parseDouble(txtThanhToan.getText());
                lblTienThua.setText(String.format("%.0f", tt));
            } else {
                lblTienThua.setText("");
            }
        }
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void cboVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVoucherActionPerformed
        int index = 0;
        if (chkApMaVoucher.isSelected()) {
            index = cboVoucher.getSelectedIndex();
            Voucher vc = vcService.getListAll().get(index);
            lblGiamGia.setText(vc.getGiamGia().toString());
        }
        

    }//GEN-LAST:event_cboVoucherActionPerformed

    private void chkApMaVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkApMaVoucherActionPerformed
        // TODO add your handling code here:
        double tongtien = Double.parseDouble(txtTongTien.getText());
        if (chkApMaVoucher.isSelected()) {
            int index = cboVoucher.getSelectedIndex();
            Voucher vc = vcService.getListAll().get(index);
            lblGiamGia.setText(vc.getGiamGia().toString());
            double giamGia = Double.parseDouble(lblGiamGia.getText());
            txtThanhToan.setText(String.format("%.1f", tongtien * (giamGia / 100)));
        } else {
            txtThanhToan.setText(String.format("%.1f", tongtien));
        }

    }//GEN-LAST:event_chkApMaVoucherActionPerformed

    private void txtTongTienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTongTienCaretUpdate
        txtThanhToan.setText(txtTongTien.getText());
    }//GEN-LAST:event_txtTongTienCaretUpdate

    private void btnRemoveOne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOne1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveOne1ActionPerformed
    KhachHang kh = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnRefrest;
    private javax.swing.JButton btnRemoveOne;
    private javax.swing.JButton btnRemoveOne1;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JComboBox<String> cboLoaiDH;
    private javax.swing.JComboBox<String> cboVoucher;
    private javax.swing.JComboBox<String> cbomauSac;
    private javax.swing.JCheckBox chkApMaVoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JTable tblDSCTSP;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
