/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.ChiTietSP;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author hungs
 */
public class CTSPRepository {

    private final Session s = HibernateUtil.getFactory().openSession();

    public List<ChiTietSP> getList() {
        List<ChiTietSP> list = new ArrayList<>();
        try {
            TypedQuery<ChiTietSP> qr = s.createQuery("from ChiTietSP");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public ChiTietSP getOneChiTietSP(String ma) throws Exception {
        ChiTietSP nd;
        try {
            Query qr = s.createQuery("from ChiTietSP where ma=:ma", ChiTietSP.class);
            qr.setParameter("ma", ma);
            nd = (ChiTietSP) qr.getSingleResult();
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        CTSPRepository ctsp = new CTSPRepository();
        for (var x : ctsp.getList()) {
            System.out.println(x);
        }
    }
}
