package CodeMain.domainModel;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "TaiKhoan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaiKhoan {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    private String ma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNguoiDung")
    private NguoiDung nguoiDung;

    private String userName;

    private String passWord;
    
    private Date createdDate;
    
    private Date updatedDate;

    private boolean deleted;

}
