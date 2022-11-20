package CodeMain.domainModel;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hungs
 */
@Entity
@Table(name = "CTSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    private String ma;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idSP")
    private SanPham sanPham;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idNoiSX")
    private NoiSX noiSX;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idHang")
    private Hang hang;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idMatKinh")
    private MatKinh matKinh;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idDanhMuc")
    private DanhMuc danhMuc;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idImei")
    private Imei imei;

    private String image;

    private int namBH;

    private String moTa;

    private Double donGia;

    private int soLuong;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    private boolean deleted;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<HoaDonCT> ListHDCT = new ArrayList<>();

    @Override
    public String toString() {
        return "ChiTietSP{" + "id=" + id + ", ma=" + ma + ", sanPham=" + sanPham + ", noiSX=" + noiSX + ", hang=" + hang + ", mauSac=" + mauSac + ", matKinh=" + matKinh + ", danhMuc=" + danhMuc + ", imei=" + imei + ", image=" + image + ", namBH=" + namBH + ", moTa=" + moTa + ", donGia=" + donGia + ", soLuong=" + soLuong + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", deleted=" + deleted +  '}';
    }

    
}
