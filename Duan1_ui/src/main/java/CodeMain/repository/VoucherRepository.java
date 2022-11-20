/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.Voucher;
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
public class VoucherRepository {

    private final Session s = HibernateUtil.getFactory().openSession();

    public List<Voucher> getList() {
        List<Voucher> list = new ArrayList<>();
        try {
            TypedQuery<Voucher> qr = s.createQuery("from Voucher");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public Voucher getOneVoucher(String ma) {
        Voucher nd;
        try {
            Query qr = s.createQuery("from Voucher where ma=:ma", Voucher.class);
            qr.setParameter("ma", ma);
            nd = (Voucher) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(Voucher nd) throws Exception {
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
            Query qr = s.createQuery("delete from Voucher where ma=:ma");
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
        VoucherRepository vc = new VoucherRepository();
        for (var x : vc.getList()) {
            System.out.println(x);
        }
    }
}
