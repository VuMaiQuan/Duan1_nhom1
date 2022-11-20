/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.Response;

import CodeMain.domainModel.HoaDon;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ViewHoaDonResponse {

    private String maHD;

    private Date ngayTao;

    private String tenNV;

    private String tenKH;

    private String trangThai;

    public ViewHoaDonResponse(HoaDon hd) {
        this.maHD = hd.getMa();
        this.ngayTao = hd.getCreatedDate();
        this.tenNV = hd.getNguoiDung().getHoTen();
        this.tenKH = hd.getKhachHang().getHoTen();
        this.trangThai = hd.getTrangThai() == 0 ? "Đã thanh toán" : "Chờ";
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Object[] rowData() {
        return new Object[]{
            this.maHD, this.ngayTao, sdf.format(this.tenNV), this.tenKH, this.trangThai
        };
    }

}
