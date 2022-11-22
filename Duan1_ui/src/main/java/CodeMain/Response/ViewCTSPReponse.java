package CodeMain.Response;

import CodeMain.domainModel.ChiTietSP;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ViewCTSPReponse {

    private String ma;
    private String tenCTSP;
    //
    private String tenHang;
    private String tenDanhMuc;
    private String mauSac;
//    private BigDecimal donGia;
    private double donGia;
    private int soLuong;
    private int namBH;
    private String matKinh;
    private String noiSX;

    public ViewCTSPReponse(ChiTietSP ctsp) {
        this.ma = ctsp.getMa();
//        this.tenCTSP = ctsp.getSanPham().getTen() + " " + ctsp.getHang().getTen() + " " + ctsp.getDanhMuc().getTen();
        this.tenCTSP = ctsp.getSanPham().getTen();
        this.tenDanhMuc=ctsp.getDanhMuc().getTen();
        this.tenHang=ctsp.getHang().getTen();
        this.mauSac = ctsp.getMauSac().getTen();
//        this.donGia = ctsp.getDonGia().setScale(1);
        this.donGia = ctsp.getDonGia();
        this.soLuong = ctsp.getSoLuong();
        this.namBH = ctsp.getNamBH();
        this.matKinh = ctsp.getMatKinh().getTen();
        this.noiSX = ctsp.getNoiSX().getTen();
    }
// giữ lại imei
  

    public Object[] rowData() {
        return new Object[]{
            this.ma, this.tenCTSP, this.mauSac, this.donGia, this.soLuong, this.namBH, this.matKinh, this.noiSX
        };
    }

}
