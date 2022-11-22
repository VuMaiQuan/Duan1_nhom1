/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import CodeMain.domainModel.DanhMuc;
import CodeMain.Config.HibernateUtil;

//import java.sql.Date;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DanhMucRepository {

    public List<DanhMuc> getAll() {
        List<DanhMuc> list = new ArrayList<>();
        String hql = "from DanhMuc";
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            TypedQuery<DanhMuc> qr = session.createQuery(hql);
            list = qr.getResultList();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean create(DanhMuc dm) {
        Transaction tran = null;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(dm);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String ma) {
        Transaction tran = null;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            tran = session.beginTransaction();
            Query<DanhMuc> qr = session.createQuery("delete from DanhMuc where ma=:ma");
            qr.setParameter("ma", ma);
            qr.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
            return false;
        }
    }

    public DanhMuc getOneId(String id) {
        DanhMuc nsx;
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Query qr = s.createQuery("from DanhMuc where id like:ma", DanhMuc.class);
            qr.setParameter("id", "%" + id + "%");
            nsx = (DanhMuc) qr.getSingleResult();
            s.close();
            return nsx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DanhMuc getOneHang(String ma) {
        String hql = "From DanhMuc where ma=:ma";
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Query query = s.createQuery(hql, DanhMuc.class);
            query.setParameter("ma", ma);
            DanhMuc hang = (DanhMuc) query.getSingleResult();
            return hang == null ? null : hang;
        } catch (Exception e) {
            return null;
        }

//        Hang hang;
//        try ( Session s = HibernateUtil.getFactory().openSession()) {         
//            Query qr = s.createQuery("from Hang where ma =:ma", Hang.class);
//            qr.setParameter("ma", ma);
//            hang = (Hang) qr.getSingleResult();           
//            s.close();
//            return hang;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
    }
    public static void main(String[] args) {
        DanhMucRepository dm=new DanhMucRepository();
        for (var o : dm.getAll()) {
            System.out.println(o.toString());
        }
    }

}
