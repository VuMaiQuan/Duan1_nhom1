/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.NguoiDung;
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
public class NguoiDungRepository {

    private final Session s = HibernateUtil.getFactory().openSession();

    public List<NguoiDung> getList() {
        List<NguoiDung> list = new ArrayList<>();
        try {
            TypedQuery<NguoiDung> qr = s.createQuery("from NguoiDung");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public NguoiDung getOneNguoiDung(String ma) throws Exception {
        NguoiDung nd;
        try {
            Query qr = s.createQuery("from NguoiDung where ma=:ma", NguoiDung.class);
            qr.setParameter("ma", ma);
            nd = (NguoiDung) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    public void create(NguoiDung nd) throws Exception {
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
            Query qr = s.createQuery("delete from NguoiDung where ma=:ma");
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
        NguoiDungRepository nd = new NguoiDungRepository();
        for (var x : nd.getList()) {
            System.out.println(x);

        }
    }
}
