/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.repository;

import com.CodeMain.Config.HibernateUtil;
import com.CodeMain.domainModel.Hang;
import com.CodeMain.domainModel.Hang;
import com.CodeMain.domainModel.Hang;
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
//import org.apache.log4j.Logger;
//import org.springframework.util.ObjectUtils;

/**
 *
 * @author NhatAn
 */
public class HangRepository {

    public List<Hang> getAll() {
        List<Hang> list = new ArrayList<>();
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            TypedQuery<Hang> qr = s.createQuery("from Hang");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public Hang getOneId(String id) {
        Hang nsx;
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Query qr = s.createQuery("from Hang where id like:ma", Hang.class);
            qr.setParameter("id", "%" + id + "%");
            nsx = (Hang) qr.getSingleResult();
            s.close();
            return nsx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Hang getOneHang(String ma) {
        Hang nd;
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            javax.persistence.Query qr = s.createQuery("from Hang where ma=:ma", Hang.class);
            qr.setParameter("ma", ma);
            nd = (Hang) qr.getSingleResult();
            //tat tam close 
            s.close();
            return nd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(Hang nd) throws Exception {

        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                s.saveOrUpdate(nd);
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

    public void delete(String ma) throws Exception {
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                javax.persistence.Query qr = s.createQuery("delete from Hang where ma=:ma");
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
        HangRepository hd = new HangRepository();
        hd.getAll().forEach(x -> {
            System.out.println(x);
        });

    }
}
