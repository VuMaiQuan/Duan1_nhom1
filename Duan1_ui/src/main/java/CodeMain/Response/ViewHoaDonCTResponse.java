/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.Response;

import CodeMain.domainModel.ChiTietSP;
import CodeMain.domainModel.HoaDonCT;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hungs
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ViewHoaDonCTResponse {

    private String ma;
    private String tenSp;
    private int soLuong;
    private BigDecimal donGia;

    public ViewHoaDonCTResponse(String ma, String tenSp, int soLuong, BigDecimal donGia) {
        this.ma = ma;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

   

    public Object[] rowData() {
        return new Object[]{
            this.ma, this.tenSp, this.soLuong, this.donGia
        };
    }

}
