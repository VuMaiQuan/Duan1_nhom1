package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.TaiKhoan;
import CodeMain.domainModel.SanPham;
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
public class SanPhamRepository {

    private final Session s = HibernateUtil.getFactory().openSession();

    public List<SanPham> getList() {
        List<SanPham> list = new ArrayList<>();
        try {
            TypedQuery<SanPham> qr = s.createQuery("from SanPham");
            list = qr.getResultList();
            //s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public void create(TaiKhoan nd) throws Exception {
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
            Query qr = s.createQuery("delete from TaiKhoan where ma=:ma");
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

    public SanPham getOneSanPham(String ma) throws Exception {
        SanPham nd;
        try {
            Query qr = s.createQuery("from SanPham where ma=:ma", SanPham.class);
            qr.setParameter("ma", ma);
            nd = (SanPham) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }

    public static void main(String[] args) {
        SanPhamRepository sp = new SanPhamRepository();
        for (var x : sp.getList()) {
            System.out.println(x);
        }
    }
}
