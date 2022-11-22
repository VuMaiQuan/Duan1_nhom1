package CodeMain.Response;

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

    private String idHDCT;
    private String ma;
    private String tenSp;
    private int soLuong;
    private BigDecimal donGia;

    public ViewHoaDonCTResponse(HoaDonCT hdct) {
        this.idHDCT = hdct.getId();
        this.ma = hdct.getChiTietSP().getMa();
        this.tenSp = hdct.getChiTietSP().getSanPham().getTen() + " " + hdct.getChiTietSP().getHang().getTen() + " " + hdct.getChiTietSP().getDanhMuc().getTen();
        this.soLuong = hdct.getSoLuong();
        this.donGia = hdct.getDonGia().setScale(1);
    }

    public Object[] rowData() {
        return new Object[]{
            this.ma, this.tenSp, this.soLuong, this.donGia
        };
    }

}
