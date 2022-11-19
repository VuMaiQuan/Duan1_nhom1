/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class SanPhamRepositoriy {

    private final Session s = HibernateUtil.getFactory().openSession();

    public List<SanPham> getListSP() {
        List<SanPham> sp = new ArrayList<>();
        try {
            TypedQuery<SanPham> qr = s.createQuery("Form SanPham");
            sp = qr.getResultList();
            s.close();
            return sp;
        } catch (Exception e) {
            return null;
        }

    }
    
    public SanPham getOneSP(String ma) throws Exception {
        SanPham nd;
        try {
            Query qr = s.createQuery("from NguoiDung where ma=:ma", SanPham.class);
            qr.setParameter("ma", ma);
            nd = (SanPham) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    public void create(SanPham nd) throws Exception {
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
            Query qr = s.createQuery("delete from SanPham where ma=:ma");
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
    
}
