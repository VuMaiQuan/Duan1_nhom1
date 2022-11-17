/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.domainModel;

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
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hungs
 */
@Entity
@Table(name = "[user]")
public class NguoiDung {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")

    private String id;
    private String ma;
    private String hoten;
    private boolean gioitinh;
    private String email;
    private String images;
    private boolean chucvu;
    private boolean deleted;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY)
    private List<TaiKhoan> list_tk = new ArrayList<>();

    public NguoiDung(String id, String ma, String hoten, boolean gioitinh, String email, String images, boolean chucvu, boolean deleted) {
        this.id = id;
        this.ma = ma;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.email = email;
        this.images = images;
        this.chucvu = chucvu;
        this.deleted = deleted;
    }

    public NguoiDung() {
    }

    public List<TaiKhoan> getList_tk() {
        return list_tk;
    }

    public void setList_tk(List<TaiKhoan> list_tk) {
        this.list_tk = list_tk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public boolean isChucvu() {
        return chucvu;
    }

    public void setChucvu(boolean chucvu) {
        this.chucvu = chucvu;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "NguoiDung{" + "id=" + id + ", ma=" + ma + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", email=" + email + ", images=" + images + ", chucvu=" + chucvu + ", deleted=" + deleted + '}';
    }

}
