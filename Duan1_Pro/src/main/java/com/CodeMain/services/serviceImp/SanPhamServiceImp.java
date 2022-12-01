/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CodeMain.services.serviceImp;

import com.CodeMain.domainModel.SanPham;
import com.CodeMain.domainModel.SanPham;
import com.CodeMain.repository.SanPhamRepository;
import com.CodeMain.repository.SanPhamRepository;
import com.CodeMain.services.SanPhamService;
import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImp implements SanPhamService {

    SanPhamRepository msRepository;

    public SanPhamServiceImp() {
        msRepository = new SanPhamRepository();
    }

    @Override
    public List<SanPham> getListAll() {
        return msRepository.getListAll();
    }

    @Override
    public SanPham getOneObj(String ma) {
        return msRepository.getOneSanPham(ma);
    }

    @Override
    public void save(SanPham hd) throws Exception {
        hd.setId(null);
        try {
            msRepository.create(hd);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(SanPham hd) throws Exception {
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
        SanPhamServiceImp kh = new SanPhamServiceImp();
        for (var x : kh.getListAll()) {
            System.out.println(x);
        }
    }
}
