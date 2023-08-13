/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.services.serviceImp;

import com.CodeMain.domainModel.DanhMuc;
import com.CodeMain.domainModel.DanhMuc;
import com.CodeMain.repository.DanhMucRepository;
import com.CodeMain.services.DanhMucService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungs
 */
public class DanhMucServiceImp implements DanhMucService {

    DanhMucRepository dmRepository;
    List<DanhMuc> listDM;

    public DanhMucServiceImp() {
        dmRepository = new DanhMucRepository();
        listDM = dmRepository.getListAll();
    }

    @Override
    public List<DanhMuc> getListAll() {
        listDM = dmRepository.getListAll();
        return listDM.isEmpty() ? null : listDM;
    }

    @Override
    public DanhMuc getOneObj(String ma) {
        return dmRepository.getOneDanhMuc(ma);
    }

    @Override
    public void save(DanhMuc hd) throws Exception {
        hd.setId(null);
        try {
            dmRepository.create(hd);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(DanhMuc hd) throws Exception {
        try {
            dmRepository.create(hd);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
        try {
            dmRepository.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        DanhMucServiceImp hd = new DanhMucServiceImp();
        hd.getListAll().forEach(x
                -> {
            System.out.println(x);
        }
        );
    }

}
