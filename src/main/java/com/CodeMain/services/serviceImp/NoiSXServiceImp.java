/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.services.serviceImp;

import com.CodeMain.domainModel.NoiSX;
import com.CodeMain.repository.NoiSXRepository;
import com.CodeMain.services.NSXService;
import java.util.ArrayList;
import java.util.List;

public class NoiSXServiceImp implements NSXService {

    NoiSXRepository nsxRepo;
    List<NoiSX> listNSX;

    public NoiSXServiceImp() {
        nsxRepo = new NoiSXRepository();
        listNSX = nsxRepo.getAll();
    }

    @Override
    public List<NoiSX> getListAll() {
        listNSX = nsxRepo.getAll();
        List<NoiSX> list = new ArrayList<>();
        for (NoiSX x : listNSX) {
            list.add(x);
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public NoiSX getOneObj(String ma) {
        return nsxRepo.getOneHang(ma);
    }

    @Override
    public void save(NoiSX nsx) throws Exception {
        nsx.setId(null);
        try {
            nsxRepo.create(nsx);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(NoiSX ctsp) throws Exception {
        try {
            nsxRepo.create(ctsp);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
        try {
            nsxRepo.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
