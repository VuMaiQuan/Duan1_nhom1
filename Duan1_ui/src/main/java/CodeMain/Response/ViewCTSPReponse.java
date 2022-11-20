package CodeMain.Response;

import CodeMain.domainModel.ChiTietSP;
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
public class ViewCTSPReponse {

    private String ma;
    private String tenCTSP;
    private String mauSac;
    private BigDecimal donGia;
    private int soLuong;
    private int namBH;
    private String matKinh;
    private String noiSX;
    private String imei;

    public ViewCTSPReponse(ChiTietSP ctsp) {
        this.ma = ctsp.getMa();
        this.tenCTSP = ctsp.getSanPham().getTen() + " " + ctsp.getHang().getTen() + " " + ctsp.getDanhMuc().getTen();
        this.mauSac = ctsp.getMauSac().getTen();
        this.donGia = ctsp.getDonGia().setScale(1);
        this.soLuong = ctsp.getSoLuong();
        this.namBH = ctsp.getNamBH();
        this.matKinh = ctsp.getMatKinh().getTen();
        this.noiSX = ctsp.getNoiSX().getTen();
        this.imei = ctsp.getImei().getMaImei();
    }
// giữ lại imei

    public Object[] rowData() {
        return new Object[]{
            this.ma, this.tenCTSP, this.mauSac, this.donGia, this.soLuong, this.namBH, this.matKinh, this.noiSX
        };
    }

}
