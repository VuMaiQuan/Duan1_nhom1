/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.HoaDon;
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
public class HoaDonRepository {
    
    private final Session s = HibernateUtil.getFactory().openSession();

    public List<HoaDon> getList() {
        List<HoaDon> list = new ArrayList<>();
        try {
            TypedQuery<HoaDon> qr = s.createQuery("from HoaDon");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public HoaDon getOneNguoiDung(String ma) throws Exception {
        HoaDon nd;
        try {
            Query qr = s.createQuery("from HoaDon where ma=:ma", HoaDon.class);
            qr.setParameter("ma", ma);
            nd = (HoaDon) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    public void create(HoaDon nd) throws Exception {
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
            Query qr = s.createQuery("delete from HoaDon where ma=:ma");
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
        HoaDonRepository nd = new HoaDonRepository();
        for (var x : nd.getList()) {
            System.out.println(x);

        }
    }
    
}
