package CodeMain.domainModel;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
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

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    private String ma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idND")
    private NguoiDung nguoiDung;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idKH")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idVoucher")
    private Voucher voucher;

    @Column(name = "tongTien")
    private Double tongTien;

    @Temporal(TemporalType.DATE)
    @Column(name = "createdDate")
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "updatedDate")
    private Date updatedDate;

    private int trangThai;

    @OneToMany(mappedBy = "hoaDon")
    private List<HoaDonCT> ListHDCT = new ArrayList<>();

}
