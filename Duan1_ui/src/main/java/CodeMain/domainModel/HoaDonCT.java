package CodeMain.domainModel;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HDCT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonCT {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCTSP")
    private ChiTietSP chiTietSP;
     
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHD")
    private HoaDon hoaDon;

    private int soLuong;

    private double donGia;

    private int trangThai;

    private String imei;

    @Temporal(TemporalType.DATE)
    private Date createdDate;
    
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    private boolean deleted;

}
