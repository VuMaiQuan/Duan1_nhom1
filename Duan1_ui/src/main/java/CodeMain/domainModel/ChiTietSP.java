/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.domainModel;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hungs
 */
@Entity
@Table(name = "CTSP")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    
    private String ma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSP")
    private SanPham sanPham;

    private String tenSPFull;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNoiSX")
    private NoiSanXuat noiSanXuat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idHang")
    private Hang hang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMatKinh")
    private MatKinh matKinh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDanhMuc")
    private DanhMuc danhMuc;

    private String idImei;

    private String image;

    private int namBH;

    private String moTa;

    private Double donGia;

    private int soLuong;

    private Date createdDate;

    private Date updatedDate;

    private boolean deleted;

}
