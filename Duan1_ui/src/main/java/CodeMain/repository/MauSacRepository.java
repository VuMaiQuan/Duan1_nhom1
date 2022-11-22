/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import java.util.Date;
import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.Hang;
import CodeMain.domainModel.MauSac;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author NhatAn
 */
public class MauSacRepository {
     public List<MauSac>getAll(){
        List<MauSac>list=new ArrayList<>();
        String hql="from MauSac";
        try (Session session=HibernateUtil.getFactory().openSession()){
            TypedQuery<MauSac>qr=session.createQuery(hql);
            list=qr.getResultList();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
       public boolean create(MauSac ms){
        Transaction tran=null;
        try (Session session=HibernateUtil.getFactory().openSession()){
            tran=session.beginTransaction();
            session.save(ms);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
       
        public boolean delete(String ma){
        Transaction tran=null;
        try(Session session =HibernateUtil.getFactory().openSession()) {
            tran=session.beginTransaction();
            Query<Hang>qr=session.createQuery("delete from MauSac where ma=:ma");
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
        public MauSac getOneMauSac(String ma) {
        MauSac ms;
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Query qr = s.createQuery("from MauSac where ma like:ma", MauSac.class);
            qr.setParameter("ma", ma+"%");
            ms = (MauSac) qr.getSingleResult();
            s.close();
            return ms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
//       
      public static void main(String[] args) {
        MauSacRepository msrepo=new MauSacRepository();
          for (var o : msrepo.getAll()) {
//              System.out.println(o.toString());
System.out.println(msrepo.getOneMauSac("ms1").toString());
          }
            
        
    }
     
}
