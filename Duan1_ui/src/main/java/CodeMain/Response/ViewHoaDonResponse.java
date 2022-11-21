package CodeMain.Response;

import CodeMain.domainModel.HoaDon;
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
        this.tenNV = hd.getNguoiDung() == null ? "Duy Hưng" : hd.getNguoiDung().getHoTen();
        this.tenKH = hd.getKhachHang() == null ? "Khách lẻ" : hd.getKhachHang().getHoTen();
        switch (hd.getTrangThai()) {
            case 0:
                this.trangThai = "Đã thanh toán";
                break;
            case 1:
                this.trangThai = "Chờ thanh toán";
                break;
            default:
                this.trangThai = "Đã Hủy";
                break;
        }
        
    }

    public Object[] rowData() {
        return new Object[]{
            this.maHD, this.ngayTao, this.tenNV, this.tenKH, this.trangThai
        };
    }

}
