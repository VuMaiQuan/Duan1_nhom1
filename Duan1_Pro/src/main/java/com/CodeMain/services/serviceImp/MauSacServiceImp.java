/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.services.serviceImp;

import com.CodeMain.domainModel.MauSac;
import com.CodeMain.repository.MauSacRepository;
import com.CodeMain.services.MauSacService;
import java.util.List;

/**
 *
 * @author hungs
 */
public class MauSacServiceImp implements MauSacService {

    MauSacRepository msRepository;

    public MauSacServiceImp() {
        msRepository = new MauSacRepository();
    }

    @Override
    public List<MauSac> getListAll() {
        return msRepository.getListAll();
    }

    @Override
    public MauSac getOneObj(String ma) {
        return msRepository.getOneMauSac(ma);
    }

    @Override
    public void save(MauSac hd) throws Exception {
        hd.setId(null);
        try {
            msRepository.create(hd);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(MauSac hd) throws Exception {
        try {
            msRepository.create(hd);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
        try {
            msRepository.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        MauSacServiceImp kh = new MauSacServiceImp();
        for (var x : kh.getListAll()) {
            System.out.println(x);
        }
    }

}
