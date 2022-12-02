package com.CodeMain.services.serviceImp;

import com.CodeMain.domainModel.Hang;
import com.CodeMain.repository.HangRepository;
import com.com.CodeMain.services.HangService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NhatAn
 */
public class HangServiceImp implements HangService {

    HangRepository hangrepo;
    List<Hang> listH;

    public HangServiceImp() {
        hangrepo = new HangRepository();
        listH = hangrepo.getAll();
    }

    @Override
    public List<Hang> getAll() {
        listH = hangrepo.getAll();
        List<Hang> list = new ArrayList<>();
        for (Hang x : listH) {
            list.add(x);
        }
        return list.isEmpty() ? null : list;

    }

    @Override
    public Hang getOneObj(String ma) {
//        return hangrepo
        return hangrepo.getOneHang(ma);
    }

    @Override
    public void save(Hang hang) throws Exception {
        hang.setId(null);
        try {
            hangrepo.create(hang);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(Hang hang) throws Exception {
        try {
            hangrepo.create(hang);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
        try {
            hangrepo.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void getId(String id) {
        try {
            hangrepo.getOneId(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        HangServiceImp hangImp = new HangServiceImp();
        for (var o : hangImp.getAll()) {
            System.out.println(o.toString());
        }
    }
}
