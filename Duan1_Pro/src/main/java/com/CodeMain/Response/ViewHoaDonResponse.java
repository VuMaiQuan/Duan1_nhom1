package com.CodeMain.Response;

import com.CodeMain.domainModel.HoaDon;
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

    private String id;

    private String ma;

    private Date ngayTao;

    private String tenNV;

    private String tenKH;

    private int trangThai;

    public ViewHoaDonResponse(HoaDon hd) {
        this.ma = hd.getMa();
        this.ngayTao = hd.getCreatedDate();
        this.tenNV = hd.getNguoiDung() == null ? "Duy Hưng" : hd.getNguoiDung().getHoTen();
        this.tenKH = hd.getKhachHang() == null ? "Khách lẻ" : hd.getKhachHang().getHoTen();
        this.trangThai = hd.getTrangThai();
    }

    public Object[] rowData() {
        return new Object[]{
            this.ma, this.ngayTao, this.tenNV, this.tenKH, this.trangThai == 0 ? "Đã thanh toán" : "Chưa thanh toán"
        };
    }

}
