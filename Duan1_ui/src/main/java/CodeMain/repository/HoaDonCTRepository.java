package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.Response.ViewHoaDonCTResponse;
import CodeMain.domainModel.HoaDon;
import CodeMain.domainModel.HoaDonCT;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hungs
 */
public class HoaDonCTRepository {

    private final Session s = HibernateUtil.getFactory().openSession();

    public List<HoaDonCT> getListAll() {
        List<HoaDonCT> list = new ArrayList<>();
        try {
            TypedQuery<HoaDonCT> qr = s.createQuery("from HoaDonCT");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public HoaDonCT getOneHoaDonCT(String id) {
        HoaDonCT nd;
        try {
            Query qr = s.createQuery("from HoaDonCT where id=:id", HoaDonCT.class);
            qr.setParameter("id", id);
            nd = (HoaDonCT) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(HoaDonCT nd) throws Exception {
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
            Query qr = s.createQuery("delete from HoaDonCT where ma=:ma");
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
        HoaDonCTRepository hdct = new HoaDonCTRepository();
//        for (var x : hdct.getList()) {
//            System.out.println(x);
//        }
        System.out.println(hdct.getOneHoaDonCT("ABCD49AF-9E91-40DF-445A-5FBF99769C75"));
    }
}
