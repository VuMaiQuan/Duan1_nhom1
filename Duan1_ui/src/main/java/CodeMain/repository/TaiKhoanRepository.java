package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaiKhoanRepository {

    private final Session s = HibernateUtil.getFactory().openSession();

    public List<TaiKhoan> getList() {
        List<TaiKhoan> list = new ArrayList<>();
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            TypedQuery<TaiKhoan> qr = s.createQuery("from TaiKhoan");
            list = qr.getResultList();
            s.close();
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

    public static void main(String[] args) {
        TaiKhoanRepository tk = new TaiKhoanRepository();
        for (TaiKhoan x : tk.getList()) {
            System.out.println(x);
        }

    }
}
