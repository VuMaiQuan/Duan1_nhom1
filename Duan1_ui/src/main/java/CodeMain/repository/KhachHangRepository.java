/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hungs
 */
public class KhachHangRepository {
    
    private final Session s = HibernateUtil.getFactory().openSession();

    public List<KhachHang> getListAll() {
        List<KhachHang> list = new ArrayList<>();
        try {
            TypedQuery<KhachHang> qr = s.createQuery("from KhachHang");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public KhachHang getOneKhachHang(String sdt) {
        KhachHang nd;
        try {
            Query qr = s.createQuery("from KhachHang where sdt=:sdt", KhachHang.class);
            qr.setParameter("sdt", sdt);
            nd = (KhachHang) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(KhachHang nd) throws Exception {
        Transaction trans = s.getTransaction();
        try {
            trans.begin();
            s.saveOrUpdate(nd);
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();;
            throw e;
        }
    }

    public void delete(String ma) throws Exception {
        Transaction trans = s.getTransaction();
        try {
            trans.begin();
            Query qr = s.createQuery("delete from KhachHang where ma=:ma");
            qr.setParameter("ma", ma);
            qr.executeUpdate();
            trans.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();;
            throw e;
        }
    }

    public static void main(String[] args) {
       KhachHangRepository kh = new KhachHangRepository();
        System.out.println(kh.getOneKhachHang("0934874321"));
    }
}
