/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.services.serviceImp;

import CodeMain.domainModel.MauSac;
import CodeMain.repository.MauSacRepository;
import CodeMain.services.MauSacService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public class MauSacServiceImp implements MauSacService{
      MauSacRepository msrepo;
    List<MauSac> listms;

    public MauSacServiceImp() {
        msrepo=new MauSacRepository();
        listms=msrepo.getAll();
    }
    
    @Override
    public List<MauSac> getListAll() {
         listms = msrepo.getAll();
        List<MauSac> list = new ArrayList<>();
        for (MauSac x : listms) {
            list.add(x);
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public MauSac getOneObj(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(MauSac ms) throws Exception {     
         ms.setId(null);
        try {
            msrepo.create(ms);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(MauSac ms) throws Exception {
         try {
            msrepo.create(ms);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
         try {
            msrepo.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
      
    public static void main(String[] args) {
        MauSacServiceImp msImp=new MauSacServiceImp();
        for (var o : msImp.getListAll()) {
            System.out.println(o.toString());
        }
    }
}
