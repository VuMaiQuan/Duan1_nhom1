/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.domainModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.internal.Cascade;

/**
 *
 * @author hungs
 */
@Entity
@Table(name = "Voucher")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    @Column(name = "id")
    private String id;
    
    @Column(name="ma")
    private String ma;
    
    @Column(name="ten")
    private String ten;
    @Column(name="giamGia")
    private Float giamGia;
    @Column(name="ngayBD")
    private Date ngayBD;
    @Column(name="ngayKT")
    private Date ngayKT;
    @Column(name="createdDate")
    private Date createdDate;
    @Column(name="updatedDate")
    private Date updatedDate;
    @Column(name="deleted")
    private boolean deleted;
    
    @OneToMany(mappedBy="voucher")
    private List<HoaDon>listVoucherHoaDon= new ArrayList<>();
    
}
