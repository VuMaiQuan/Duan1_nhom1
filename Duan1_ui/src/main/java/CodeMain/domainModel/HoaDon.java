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
import javax.persistence.GenerationType;
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
@Table(name = "HoaDon")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    
    private String ma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idND")
    private NguoiDung nguoiDung;

    @Column(name = "idKH")
    private String khachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idVoucher")
    private Voucher voucher;

    @Column(name = "tongTien")
    private Double tongTien;

    @Column(name = "createdDate")
    private Date createdDate;
    
    @Column(name = "updatedDate")
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTrangThai")
    private TrangThai trangThai;

}
