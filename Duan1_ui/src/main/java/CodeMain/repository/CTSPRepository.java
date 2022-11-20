package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.ChiTietSP;
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
public class CTSPRepository {

    private final Session s = HibernateUtil.getFactory().openSession();
//list

    public List<ChiTietSP> getListAll() {
        List<ChiTietSP> list = new ArrayList<>();
        try {
            TypedQuery<ChiTietSP> qr = s.createQuery("from ChiTietSP");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ChiTietSP getOneChiTietSP(String ma) {
        ChiTietSP nd;
        try {
            Query qr = s.createQuery("from ChiTietSP where ma=:ma", ChiTietSP.class);
            qr.setParameter("ma", ma);
            nd = (ChiTietSP) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(ChiTietSP nd) throws Exception {
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
            Query qr = s.createQuery("delete from ChiTietSP where ma=:ma");
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
        CTSPRepository ctsp = new CTSPRepository();
//        for (var x : ctsp.getListAll()) {
//            System.out.println(x);
//        }

    }
}

//    public List<ChiTietSPCustom> getListCustom() {
//        List<ChiTietSPCustom> list = new ArrayList<>();
//        try {
//            String hql1="select new CodeMain.customModel.ChiTietSPCustom"
//                    + "(ctsp.ma,sp.ten+h.ten+dm.ten,ctsp.donGia,ctsp.soLuong,mk.ten,n.ten,i.maImei) "
//                    + "from ChiTietSP ctsp"
//                    + "inner join SanPham sp on ctsp.sanPham.id=sp.id"
//                    + "inner join NoiSX as n on ctsp.noiSX.id = n.id"
//                    + "inner join DanhMuc as dm ctsp.danhMuc.id=dm.id"
//                    + "inner join Hang as h on ctsp.hang.id=h.id"
//                    + "inner join MauSac as m on ctsp.mauSac.id=m.id"
//                    + "inner join MatKinh as mk on ctsp.matKinh.id=mk.id"
//                    + "inner join Imei as i on ctsp.imei.id=i.id";
//
//            TypedQuery<ChiTietSPCustom> qr = s.createQuery(hql1);
//            list = qr.getResultList();
//            s.close();
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
