/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import CodeMain.Utilities.HibernateUtil;
import CodeMain.domainModel.NguoiDung;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author hungs
 */
public class NguoiDungRepository {

    public List<NguoiDung> getList() {
        List<NguoiDung> list = new ArrayList<>();
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            TypedQuery<NguoiDung> qr = s.createQuery("from NguoiDung");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public NguoiDung getOneND(String idND) {
        NguoiDung nd;
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Query qr = s.createQuery("from NguoiDung where id=:id", NguoiDung.class);
            qr.setParameter("id", idND);
            nd = (NguoiDung) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        NguoiDungRepository nd = new NguoiDungRepository();
//        for (var x : nd.getList()) {
//            System.out.println(x);
//        }
System.out.println(nd.getOneND("533BA65B-E067-47C8-8863-6089325498F6"));
    }
}
