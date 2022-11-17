/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name = "NguoiDung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NguoiDung {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private String ma;

    private String hoTen;

    private boolean gioiTinh;

    private String diaChi;

    private String email;

    private String sdt;

    private String image;

    private boolean chucVu;

    private Date createdDate;

    private Date updatedDate;

    private boolean deleted;

    @OneToMany(mappedBy = "nguoiDung")
    private List<TaiKhoan> list_tk = new ArrayList<>();

    @Override
    public String toString() {
        return "NguoiDung{" + "id=" + id + ", ma=" + ma + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", email=" + email + ", sdt=" + sdt + ", image=" + image + ", chucVu=" + chucVu + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", deleted=" + deleted + '}';
    }

    
}
