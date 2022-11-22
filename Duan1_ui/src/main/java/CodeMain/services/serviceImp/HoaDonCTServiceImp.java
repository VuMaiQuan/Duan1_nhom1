/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeMain.services.serviceImp;

import CodeMain.Response.ViewHoaDonCTResponse;
import CodeMain.domainModel.HoaDon;
import CodeMain.domainModel.HoaDonCT;
import CodeMain.repository.HoaDonCTRepository;
import CodeMain.services.HoaDonCTService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungs
 */
public class HoaDonCTServiceImp implements HoaDonCTService {

    HoaDonCTRepository hdctRepository;

    public HoaDonCTServiceImp() {
        hdctRepository = new HoaDonCTRepository();
        getListAll();
    }

    @Override
    public List<ViewHoaDonCTResponse> getListAll() {
        List<ViewHoaDonCTResponse> list = new ArrayList<>();
        for (HoaDonCT x : hdctRepository.getListAll()) {
            list.add(new ViewHoaDonCTResponse(x));
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public HoaDonCT getOneObj(String ma) {
        return hdctRepository.getOneHoaDonCT(ma);
    }

    @Override
    public void save(HoaDonCT hdct) throws Exception {
        try {
            hdctRepository.create(hdct);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(HoaDonCT hdct) throws Exception {
        try {
            hdctRepository.create(hdct);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(String ma) throws Exception {
        try {
            hdctRepository.delete(ma);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        HoaDonCTServiceImp hd = new HoaDonCTServiceImp();
        for (ViewHoaDonCTResponse x : hd.getListAll()) {
            System.out.println(x);
        }
    }

    @Override
    public List<ViewHoaDonCTResponse> getListShowTBLAll(HoaDon hd) {
        List<ViewHoaDonCTResponse> list = new ArrayList<>();
        if (hd.getListHDCT().isEmpty()) {
            return null;
        } else {
            for (HoaDonCT x : hd.getListHDCT()) {
                list.add(new ViewHoaDonCTResponse(x));
            }
            return list;
        }

    }
}
