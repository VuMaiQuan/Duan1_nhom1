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
    private String maCTSP;
    private String tenCTSP;
    private int soLuong;
    private BigDecimal donGia;

    public ViewHoaDonCTResponse(HoaDonCT hdct) {
        this.idHDCT = hdct.getId();
        this.maCTSP = hdct.getChiTietSP().getMa();
        this.tenCTSP = hdct.getChiTietSP().getSanPham().getTen() + " " + hdct.getChiTietSP().getHang().getTen() + " " + hdct.getChiTietSP().getDanhMuc().getTen();
        this.soLuong = hdct.getSoLuong();
        this.donGia = hdct.getDonGia().setScale(1);
    }

    public Object[] rowData() {
        return new Object[]{
            this.maCTSP, this.tenCTSP, this.soLuong, this.donGia
        };
    }

}
