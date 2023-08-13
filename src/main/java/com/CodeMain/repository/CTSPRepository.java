package com.CodeMain.repository;

import com.CodeMain.Config.HibernateUtil;
import com.CodeMain.domainModel.ChiTietSP;
import com.CodeMain.domainModel.DanhMuc;
import com.CodeMain.domainModel.Hang;
import com.CodeMain.domainModel.MatKinh;
import com.CodeMain.domainModel.MauSac;
import com.CodeMain.domainModel.NoiSX;
import com.CodeMain.domainModel.SanPham;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hungs
 */
public class CTSPRepository {

//list
    public List<ChiTietSP> getListAll() {
        List<ChiTietSP> list = new ArrayList<>();
        try ( Session s = HibernateUtil.getFactory().openSession()) {
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
        try ( Session s = HibernateUtil.getFactory().openSession()) {
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

    public void create(ChiTietSP ctsp) throws Exception {
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                s.saveOrUpdate(ctsp);
                trans.commit();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(String ma) throws Exception {//xóa là update deleted =1;
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                Query qr = s.createQuery("delete from ChiTietSP where ma=:ma");
                qr.setParameter("ma", ma);
                qr.executeUpdate();
                trans.commit();

                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        CTSPRepository ctsp = new CTSPRepository();
//        for (var x : ctsp.getListAll()) {
//            System.out.println(x);
//        }
        Session s = HibernateUtil.getFactory().openSession();
        SanPham sp = s.get(SanPham.class, "17AE886E-F066-4EEC-A204-2454AD772206");
        DanhMuc dm = s.get(DanhMuc.class, "7907C782-60EF-4996-B195-51D28B29D63A");
        MauSac ms = s.get(MauSac.class, "BF5B2B71-3152-45F6-B70D-72D3B09E50CA");
        MatKinh mk = s.get(MatKinh.class, "3ECA6E0C-888A-4888-9AD7-82D7CCCA94F5");
        NoiSX nsx = s.get(NoiSX.class, "4F746BEC-C514-4053-9031-0223A9AFE565");
        Hang h = s.get(Hang.class, "E3AD0E43-0885-40A3-9B7A-580F2946CA82");
        s.close();
        ChiTietSP ct = new ChiTietSP(null, "ctsp5", sp, nsx, h, ms, mk, dm, null, 0, "hfd", 0, 0, new Date(), null, false);
        try {
            ctsp.create(ct);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(CTSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

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
