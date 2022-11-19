/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.domainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hungs
 */
@Entity
@Table(name = "HDCT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDonCT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private ChiTietSP chiTietSP;

    private HoaDon hoaDon;

    private String soLuong;
    private String donGia;
    private String trangThai;

    private String imei;

    private String createdDate;

    private String updatedDate;

    private String delete;
    

}
