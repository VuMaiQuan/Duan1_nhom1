/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.repository;

import CodeMain.Config.HibernateUtil;
import CodeMain.domainModel.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

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
