package com.CodeMain.Response;

import com.CodeMain.domainModel.ChiTietSP;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ViewCTSPReponse {

    private String id;
    private String ma;
    private String tenCTSP;
    private String mauSac;
    private double donGia;
    private int soLuong;
    private int namBH;
    private String matKinh;
    private String noiSX;

    public ViewCTSPReponse(ChiTietSP ctsp) {
        this.id = ctsp.getId();
        this.ma = ctsp.getMa();
        this.tenCTSP = ctsp.getSanPham().getTen() + " " + ctsp.getHang().getTen() + " " + ctsp.getDanhMuc().getTen();
        this.mauSac = ctsp.getMauSac().getTen();
        this.donGia = ctsp.getDonGia();
        this.soLuong = ctsp.getSoLuong();
        this.namBH = ctsp.getNamBH();
        this.matKinh = ctsp.getMatKinh().getTen();
        this.noiSX = ctsp.getNoiSX().getTen();
    }
// giữ lại imei

    public Object[] rowData() {
//        DecimalFormat df = new DecimalFormat("#,###.0");
        Locale lc = new Locale("nv", "VN");
        NumberFormat nf = NumberFormat.getInstance(lc);
        return new Object[]{
            this.ma, this.tenCTSP, this.mauSac, nf.format(new BigDecimal(this.donGia))+ " đ", this.soLuong, this.namBH, this.matKinh, this.noiSX
        };
    }

}
